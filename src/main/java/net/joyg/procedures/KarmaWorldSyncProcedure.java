package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.joyg.network.JoygModVariables;
import net.joyg.configuration.JoygCfgConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KarmaWorldSyncProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.minecraftforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		JoygModVariables.MapVariables.get(world).karmaDmg = (double) JoygCfgConfiguration.KARMADMG.get();
		JoygModVariables.MapVariables.get(world).syncData(world);
		JoygModVariables.MapVariables.get(world).karmaEffChance = (double) JoygCfgConfiguration.KARMAEFF.get();
		JoygModVariables.MapVariables.get(world).syncData(world);
		JoygModVariables.MapVariables.get(world).karmaSlowness = (double) JoygCfgConfiguration.SLOWNESS.get();
		JoygModVariables.MapVariables.get(world).syncData(world);
		JoygModVariables.MapVariables.get(world).karmaWeakness = (double) JoygCfgConfiguration.WEAKNESS.get();
		JoygModVariables.MapVariables.get(world).syncData(world);
		JoygModVariables.MapVariables.get(world).karmaPoison = (double) JoygCfgConfiguration.POISON.get();
		JoygModVariables.MapVariables.get(world).syncData(world);
		JoygModVariables.MapVariables.get(world).karmaBleed = (double) JoygCfgConfiguration.BLEED.get();
		JoygModVariables.MapVariables.get(world).syncData(world);
		JoygModVariables.MapVariables.get(world).karmaEffDuration = (double) JoygCfgConfiguration.EFFDURATION.get();
		JoygModVariables.MapVariables.get(world).syncData(world);
	}
}
