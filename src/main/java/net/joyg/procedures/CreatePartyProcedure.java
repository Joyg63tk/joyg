package net.joyg.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.joyg.network.JoygModVariables;

import java.io.IOException;
import java.io.File;

public class CreatePartyProcedure {
	public static void execute() {
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
