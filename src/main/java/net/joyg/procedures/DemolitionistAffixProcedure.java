package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.joyg.JoygMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DemolitionistAffixProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("demolitionist_affix") == true) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
				entity.getPersistentData().putDouble("demo", (entity.getPersistentData().getDouble("demo") + 1));
				if (entity.getPersistentData().getDouble("demo") == 300) {
					entity.getPersistentData().putDouble("demo", 0);
					entity.getPersistentData().putDouble("dx", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
					entity.getPersistentData().putDouble("dy", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()));
					entity.getPersistentData().putDouble("dz", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
					if (world instanceof ServerLevel _level) {
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute positioned ~ ~ ~ run particlecircle large_ritual_circle 3");
					}
					if (world instanceof ServerLevel _level) {
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getPersistentData().getDouble("dx")), (entity.getPersistentData().getDouble("dy")), (entity.getPersistentData().getDouble("dz"))),
										Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "execute positioned ~ ~ ~ run particlecircle small_ritual_circle 3");
					}
					JoygMod.queueServerWork(60, () -> {
						if (world instanceof ServerLevel _level) {
							System.out.println(entity.getStringUUID());
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"execute as " + entity.getStringUUID() + " run particlesetrel flame_spiral 1");
						}
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, (entity.getPersistentData().getDouble("dx")), (entity.getPersistentData().getDouble("dy")), (entity.getPersistentData().getDouble("dz")), (float) entity.getPersistentData().getDouble("rank"),
									Level.ExplosionInteraction.MOB);
					});
				}
			}
		}
	}
}
