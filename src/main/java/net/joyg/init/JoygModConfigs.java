package net.joyg.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.joyg.configuration.JoygCfgConfiguration;
import net.joyg.JoygMod;

@Mod.EventBusSubscriber(modid = JoygMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JoygModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, JoygCfgConfiguration.SPEC, "joyg_cfg.toml");
		});
	}
}
