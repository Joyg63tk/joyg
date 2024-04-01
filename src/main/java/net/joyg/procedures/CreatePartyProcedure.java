package net.joyg.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.api.distmarker.Dist;

import net.joyg.network.JoygModVariables;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.File;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CreatePartyProcedure {
	@SubscribeEvent
	public static void init(FMLClientSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File partylist = new File("");
		com.google.gson.JsonObject party = new com.google.gson.JsonObject();
		JoygModVariables.partylist = new File((FMLPaths.GAMEDIR.get().toString() + "/config/party"), File.separator + "partylist.json");
		if (!partylist.exists()) {
			try {
				partylist.getParentFile().mkdirs();
				partylist.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
