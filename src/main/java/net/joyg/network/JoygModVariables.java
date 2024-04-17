package net.joyg.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.joyg.JoygMod;

import java.util.function.Supplier;

import java.io.File;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JoygModVariables {
	public static File partylist = new File("");

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		JoygMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		JoygMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.karma = original.karma;
			clone.karmaBar = original.karmaBar;
			clone.indirectMoH = original.indirectMoH;
			clone.hollow = original.hollow;
			clone.barbedarrow = original.barbedarrow;
			clone.splinter = original.splinter;
			clone.ruleofthree = original.ruleofthree;
			clone.battleMage = original.battleMage;
			clone.team = original.team;
			clone.canLoot = original.canLoot;
			clone.invited = original.invited;
			clone.invFrom = original.invFrom;
			clone.portal = original.portal;
			clone.portalTaken = original.portalTaken;
			clone.arcaneFamiliar = original.arcaneFamiliar;
			clone.arcanKnowledge = original.arcanKnowledge;
			clone.idolatry = original.idolatry;
			clone.fanaticism = original.fanaticism;
			clone.totemcount = original.totemcount;
			clone.maxCharges = original.maxCharges;
			clone.manaBlast = original.manaBlast;
			clone.manaShield = original.manaShield;
			clone.artillerist = original.artillerist;
			clone.manathorn = original.manathorn;
			clone.escapeArtist = original.escapeArtist;
			clone.escapeArtistCD = original.escapeArtistCD;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					JoygMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					JoygMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					JoygMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "joyg_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				JoygMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "joyg_mapvars";
		public double karmaDmg = 0.1;
		public double karmaEffChance = 0.2;
		public double karmaWeakness = 3.0;
		public double karmaSlowness = 2.0;
		public double karmaPoison = 5.0;
		public double karmaBleed = 1.0;
		public double karmaEffDuration = 60.0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			karmaDmg = nbt.getDouble("karmaDmg");
			karmaEffChance = nbt.getDouble("karmaEffChance");
			karmaWeakness = nbt.getDouble("karmaWeakness");
			karmaSlowness = nbt.getDouble("karmaSlowness");
			karmaPoison = nbt.getDouble("karmaPoison");
			karmaBleed = nbt.getDouble("karmaBleed");
			karmaEffDuration = nbt.getDouble("karmaEffDuration");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("karmaDmg", karmaDmg);
			nbt.putDouble("karmaEffChance", karmaEffChance);
			nbt.putDouble("karmaWeakness", karmaWeakness);
			nbt.putDouble("karmaSlowness", karmaSlowness);
			nbt.putDouble("karmaPoison", karmaPoison);
			nbt.putDouble("karmaBleed", karmaBleed);
			nbt.putDouble("karmaEffDuration", karmaEffDuration);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				JoygMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("joyg", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double karma = 0;
		public double karmaBar = 0;
		public boolean indirectMoH = false;
		public boolean hollow = false;
		public boolean barbedarrow = false;
		public boolean splinter = false;
		public boolean ruleofthree = false;
		public boolean battleMage = false;
		public String team = "\"\"";
		public boolean canLoot = false;
		public boolean invited = false;
		public String invFrom = "\"\"";
		public boolean portal = false;
		public String portalTaken = "\"\"";
		public boolean arcaneFamiliar = false;
		public boolean arcanKnowledge = false;
		public boolean idolatry = false;
		public boolean fanaticism = false;
		public double totemcount = 0;
		public double maxCharges = 0;
		public boolean manaBlast = false;
		public boolean manaShield = false;
		public boolean artillerist = false;
		public boolean manathorn = false;
		public boolean escapeArtist = false;
		public double escapeArtistCD = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				JoygMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("karma", karma);
			nbt.putDouble("karmaBar", karmaBar);
			nbt.putBoolean("indirectMoH", indirectMoH);
			nbt.putBoolean("hollow", hollow);
			nbt.putBoolean("barbedarrow", barbedarrow);
			nbt.putBoolean("splinter", splinter);
			nbt.putBoolean("ruleofthree", ruleofthree);
			nbt.putBoolean("battleMage", battleMage);
			nbt.putString("team", team);
			nbt.putBoolean("canLoot", canLoot);
			nbt.putBoolean("invited", invited);
			nbt.putString("invFrom", invFrom);
			nbt.putBoolean("portal", portal);
			nbt.putString("portalTaken", portalTaken);
			nbt.putBoolean("arcaneFamiliar", arcaneFamiliar);
			nbt.putBoolean("arcanKnowledge", arcanKnowledge);
			nbt.putBoolean("idolatry", idolatry);
			nbt.putBoolean("fanaticism", fanaticism);
			nbt.putDouble("totemcount", totemcount);
			nbt.putDouble("maxCharges", maxCharges);
			nbt.putBoolean("manaBlast", manaBlast);
			nbt.putBoolean("manaShield", manaShield);
			nbt.putBoolean("artillerist", artillerist);
			nbt.putBoolean("manathorn", manathorn);
			nbt.putBoolean("escapeArtist", escapeArtist);
			nbt.putDouble("escapeArtistCD", escapeArtistCD);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			karma = nbt.getDouble("karma");
			karmaBar = nbt.getDouble("karmaBar");
			indirectMoH = nbt.getBoolean("indirectMoH");
			hollow = nbt.getBoolean("hollow");
			barbedarrow = nbt.getBoolean("barbedarrow");
			splinter = nbt.getBoolean("splinter");
			ruleofthree = nbt.getBoolean("ruleofthree");
			battleMage = nbt.getBoolean("battleMage");
			team = nbt.getString("team");
			canLoot = nbt.getBoolean("canLoot");
			invited = nbt.getBoolean("invited");
			invFrom = nbt.getString("invFrom");
			portal = nbt.getBoolean("portal");
			portalTaken = nbt.getString("portalTaken");
			arcaneFamiliar = nbt.getBoolean("arcaneFamiliar");
			arcanKnowledge = nbt.getBoolean("arcanKnowledge");
			idolatry = nbt.getBoolean("idolatry");
			fanaticism = nbt.getBoolean("fanaticism");
			totemcount = nbt.getDouble("totemcount");
			maxCharges = nbt.getDouble("maxCharges");
			manaBlast = nbt.getBoolean("manaBlast");
			manaShield = nbt.getBoolean("manaShield");
			artillerist = nbt.getBoolean("artillerist");
			manathorn = nbt.getBoolean("manathorn");
			escapeArtist = nbt.getBoolean("escapeArtist");
			escapeArtistCD = nbt.getDouble("escapeArtistCD");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.karma = message.data.karma;
					variables.karmaBar = message.data.karmaBar;
					variables.indirectMoH = message.data.indirectMoH;
					variables.hollow = message.data.hollow;
					variables.barbedarrow = message.data.barbedarrow;
					variables.splinter = message.data.splinter;
					variables.ruleofthree = message.data.ruleofthree;
					variables.battleMage = message.data.battleMage;
					variables.team = message.data.team;
					variables.canLoot = message.data.canLoot;
					variables.invited = message.data.invited;
					variables.invFrom = message.data.invFrom;
					variables.portal = message.data.portal;
					variables.portalTaken = message.data.portalTaken;
					variables.arcaneFamiliar = message.data.arcaneFamiliar;
					variables.arcanKnowledge = message.data.arcanKnowledge;
					variables.idolatry = message.data.idolatry;
					variables.fanaticism = message.data.fanaticism;
					variables.totemcount = message.data.totemcount;
					variables.maxCharges = message.data.maxCharges;
					variables.manaBlast = message.data.manaBlast;
					variables.manaShield = message.data.manaShield;
					variables.artillerist = message.data.artillerist;
					variables.manathorn = message.data.manathorn;
					variables.escapeArtist = message.data.escapeArtist;
					variables.escapeArtistCD = message.data.escapeArtistCD;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
