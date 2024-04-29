package net.joyg.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class AffixFileCreationProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File file = new File("");
		com.google.gson.JsonObject obj = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config"), File.separator + "joyg_affix.json");
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			obj.addProperty("armored_affix", true);
			obj.addProperty("blinding_affix", true);
			obj.addProperty("climber_affix", true);
			obj.addProperty("demolitionist_affix", true);
			obj.addProperty("duelist_affix", true);
			obj.addProperty("endergrip_affix", true);
			obj.addProperty("entomb_affix", true);
			obj.addProperty("flamecaster_affix", true);
			obj.addProperty("frostcaster_affix", true);
			obj.addProperty("healthy_affix", true);
			obj.addProperty("igniter_affix", true);
			obj.addProperty("inescapable_affix", true);
			obj.addProperty("inspiring_affix", true);
			obj.addProperty("manaburn_affix", true);
			obj.addProperty("proximityshield_affix", true);
			obj.addProperty("quaking_affix", true);
			obj.addProperty("respite_affix", true);
			obj.addProperty("soultaker_affix", true);
			obj.addProperty("strong_affix", true);
			obj.addProperty("suppressionfield_affix", true);
			obj.addProperty("teleporter_affix", true);
			obj.addProperty("thundercaller_affix", true);
			obj.addProperty("toxic_affix", true);
			obj.addProperty("unyielding_affix", true);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(obj));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
