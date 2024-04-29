package net.joyg.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class TestProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject obj = new com.google.gson.JsonObject();
		String affix_1 = "";
		String affix_2 = "";
		String affix_3 = "";
		double timeout = 0;
		if (!world.isClientSide() && sourceentity instanceof Player) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config"), File.separator + "joyg_affix.json");
			if (file.exists()) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						obj = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						affix_1 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
						affix_2 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
						affix_3 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
						while (obj.get(affix_1).getAsBoolean() == false || !affix_1.contains("affix")) {
							affix_1 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
							timeout = timeout + 1;
							if (timeout > 10000) {
								timeout = 0;
								break;
							}
						}
						while (affix_2.contains(affix_1) || obj.get(affix_2).getAsBoolean() == false || !affix_2.contains("affix")) {
							affix_2 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
							if (timeout > 10000) {
								timeout = 0;
								break;
							}
						}
						while (affix_3.contains(affix_1) || affix_3.contains(affix_2) || obj.get(affix_3).getAsBoolean() == false || !affix_3.contains("affix")) {
							affix_2 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
							if (timeout > 10000) {
								timeout = 0;
								break;
							}
						}
						{
							String[] _array = (affix_1 + "," + affix_2 + "," + affix_3).split(",");
							if (_array.length != 0) {
								for (String stringiterator : _array) {
									if (sourceentity instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal(stringiterator), false);
								}
							} else {
								String stringiterator = (affix_1 + "," + affix_2 + "," + affix_3);
								if (sourceentity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal(stringiterator), false);
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
