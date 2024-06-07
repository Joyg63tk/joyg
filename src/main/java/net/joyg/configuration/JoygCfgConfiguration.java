package net.joyg.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class JoygCfgConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LOOT;
	public static final ForgeConfigSpec.ConfigValue<Double> LOOT_TIME;
	static {
		BUILDER.push("Loot");
		ENABLE_LOOT = BUILDER.comment("If True: loot bags containing the dropped items will spawn when a player kills the mob").define("enable_loot", false);
		LOOT_TIME = BUILDER.comment("number of ticks loot bags persist before despawning and dropping all contents").define("loot_time", (double) 100);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
