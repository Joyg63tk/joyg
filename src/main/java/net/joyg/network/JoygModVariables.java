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

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.joyg.JoygMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JoygModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
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
			clone.indirectMoH = original.indirectMoH;
			clone.hollow = original.hollow;
			clone.barbedarrow = original.barbedarrow;
			clone.splinter = original.splinter;
			clone.ruleofthree = original.ruleofthree;
			clone.battleMage = original.battleMage;
			clone.canLoot = original.canLoot;
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
			clone.unbreakableGuardian = original.unbreakableGuardian;
			clone.manaGuardian = original.manaGuardian;
			clone.affinityForSuffering = original.affinityForSuffering;
			clone.intimidatingPresence = original.intimidatingPresence;
			clone.guardingPresence = original.guardingPresence;
			clone.juggernaut = original.juggernaut;
			clone.aegisGuardian = original.aegisGuardian;
			clone.tornadoShots = original.tornadoShots;
			if (!event.isWasDeath()) {
				clone.lowLife = original.lowLife;
				clone.ShieldRegenDelay = original.ShieldRegenDelay;
				clone.absoptionRegenStarted = original.absoptionRegenStarted;
			}
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
		public boolean indirectMoH = false;
		public boolean hollow = false;
		public boolean barbedarrow = false;
		public boolean splinter = false;
		public boolean ruleofthree = false;
		public boolean battleMage = false;
		public boolean canLoot = false;
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
		public boolean unbreakableGuardian = false;
		public boolean manaGuardian = false;
		public boolean lowLife = false;
		public boolean affinityForSuffering = false;
		public boolean intimidatingPresence = false;
		public boolean guardingPresence = false;
		public boolean juggernaut = false;
		public boolean aegisGuardian = false;
		public double ShieldRegenDelay = 0;
		public boolean absoptionRegenStarted = false;
		public boolean tornadoShots = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				JoygMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("indirectMoH", indirectMoH);
			nbt.putBoolean("hollow", hollow);
			nbt.putBoolean("barbedarrow", barbedarrow);
			nbt.putBoolean("splinter", splinter);
			nbt.putBoolean("ruleofthree", ruleofthree);
			nbt.putBoolean("battleMage", battleMage);
			nbt.putBoolean("canLoot", canLoot);
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
			nbt.putBoolean("unbreakableGuardian", unbreakableGuardian);
			nbt.putBoolean("manaGuardian", manaGuardian);
			nbt.putBoolean("lowLife", lowLife);
			nbt.putBoolean("affinityForSuffering", affinityForSuffering);
			nbt.putBoolean("intimidatingPresence", intimidatingPresence);
			nbt.putBoolean("guardingPresence", guardingPresence);
			nbt.putBoolean("juggernaut", juggernaut);
			nbt.putBoolean("aegisGuardian", aegisGuardian);
			nbt.putDouble("ShieldRegenDelay", ShieldRegenDelay);
			nbt.putBoolean("absoptionRegenStarted", absoptionRegenStarted);
			nbt.putBoolean("tornadoShots", tornadoShots);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			indirectMoH = nbt.getBoolean("indirectMoH");
			hollow = nbt.getBoolean("hollow");
			barbedarrow = nbt.getBoolean("barbedarrow");
			splinter = nbt.getBoolean("splinter");
			ruleofthree = nbt.getBoolean("ruleofthree");
			battleMage = nbt.getBoolean("battleMage");
			canLoot = nbt.getBoolean("canLoot");
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
			unbreakableGuardian = nbt.getBoolean("unbreakableGuardian");
			manaGuardian = nbt.getBoolean("manaGuardian");
			lowLife = nbt.getBoolean("lowLife");
			affinityForSuffering = nbt.getBoolean("affinityForSuffering");
			intimidatingPresence = nbt.getBoolean("intimidatingPresence");
			guardingPresence = nbt.getBoolean("guardingPresence");
			juggernaut = nbt.getBoolean("juggernaut");
			aegisGuardian = nbt.getBoolean("aegisGuardian");
			ShieldRegenDelay = nbt.getDouble("ShieldRegenDelay");
			absoptionRegenStarted = nbt.getBoolean("absoptionRegenStarted");
			tornadoShots = nbt.getBoolean("tornadoShots");
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
					variables.indirectMoH = message.data.indirectMoH;
					variables.hollow = message.data.hollow;
					variables.barbedarrow = message.data.barbedarrow;
					variables.splinter = message.data.splinter;
					variables.ruleofthree = message.data.ruleofthree;
					variables.battleMage = message.data.battleMage;
					variables.canLoot = message.data.canLoot;
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
					variables.unbreakableGuardian = message.data.unbreakableGuardian;
					variables.manaGuardian = message.data.manaGuardian;
					variables.lowLife = message.data.lowLife;
					variables.affinityForSuffering = message.data.affinityForSuffering;
					variables.intimidatingPresence = message.data.intimidatingPresence;
					variables.guardingPresence = message.data.guardingPresence;
					variables.juggernaut = message.data.juggernaut;
					variables.aegisGuardian = message.data.aegisGuardian;
					variables.ShieldRegenDelay = message.data.ShieldRegenDelay;
					variables.absoptionRegenStarted = message.data.absoptionRegenStarted;
					variables.tornadoShots = message.data.tornadoShots;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
