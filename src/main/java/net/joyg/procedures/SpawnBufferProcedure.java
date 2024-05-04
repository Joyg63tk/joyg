package net.joyg.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.joyg.network.JoygModVariables;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class SpawnBufferProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		double karma = 0;
		double timeout = 0;
		com.google.gson.JsonObject obj = new com.google.gson.JsonObject();
		String affix_2 = "";
		String affix_1 = "";
		String affix_3 = "";
		String affix_4 = "";
		String affix_5 = "";
		if (!world.isClientSide()) {
			if (entity instanceof Monster) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							karma = karma + (entityiterator.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).karma;
						}
					}
				}
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getValue()
						+ ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getValue() * 0.05 * karma));
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue()
						+ ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getValue() * 0.1 * karma));
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue()
						+ ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 0.1 * karma));
				if (karma + 5 > Mth.nextInt(RandomSource.create(), 0, 100)) {
					entity.getPersistentData().putDouble("rank", karma);
					entity.getPersistentData().putBoolean("Elite", true);
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
								if (karma < 5) {
									affix_1 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_2 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_3 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									while (obj.get(affix_1).getAsBoolean() || !affix_1.contains("affix")) {
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
										affix_3 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
										if (timeout > 10000) {
											timeout = 0;
											break;
										}
									}
									{
										String[] _array = (affix_1 + "," + affix_2 + "," + affix_3).split(",");
										if (_array.length != 0) {
											for (String stringiterator : _array) {
												entity.getPersistentData().putBoolean(stringiterator, true);
											}
										} else {
											String stringiterator = (affix_1 + "," + affix_2 + "," + affix_3);
											entity.getPersistentData().putBoolean(stringiterator, true);
										}
									}
									entity.setCustomName(Component.literal((("Elite " + entity.getDisplayName().getString() + " - " + affix_1 + affix_2 + affix_3 + "-").replace("_affix", " "))));
								}
								if (karma >= 5 && karma < 10) {
									affix_1 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_2 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_3 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_4 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									while (obj.get(affix_1).getAsBoolean() || !affix_1.contains("affix")) {
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
										affix_3 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
										if (timeout > 10000) {
											timeout = 0;
											break;
										}
									}
									while (affix_4.contains(affix_3) || affix_4.contains(affix_1) || affix_4.contains(affix_2) || obj.get(affix_4).getAsBoolean() == false || !affix_4.contains("affix")) {
										affix_4 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
										if (timeout > 10000) {
											timeout = 0;
											break;
										}
									}
									{
										String[] _array = (affix_1 + "," + affix_2 + "," + affix_3 + "," + affix_4).split(",");
										if (_array.length != 0) {
											for (String stringiterator : _array) {
												entity.getPersistentData().putBoolean(stringiterator, true);
											}
										} else {
											String stringiterator = (affix_1 + "," + affix_2 + "," + affix_3 + "," + affix_4);
											entity.getPersistentData().putBoolean(stringiterator, true);
										}
									}
									entity.setCustomName(Component.literal((("Elite " + entity.getDisplayName().getString() + " - " + affix_1 + affix_2 + affix_3 + affix_4 + "-").replace("_affix", " "))));
								}
								if (karma >= 10) {
									affix_1 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_2 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_3 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_4 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									affix_5 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
									while (obj.get(affix_1).getAsBoolean() || !affix_1.contains("affix")) {
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
										affix_3 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
										if (timeout > 10000) {
											timeout = 0;
											break;
										}
									}
									while (affix_4.contains(affix_3) || affix_4.contains(affix_1) || affix_4.contains(affix_2) || obj.get(affix_4).getAsBoolean() == false || !affix_4.contains("affix")) {
										affix_4 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
										if (timeout > 10000) {
											timeout = 0;
											break;
										}
									}
									while (affix_5.contains(affix_1) || affix_5.contains(affix_2) || affix_5.contains(affix_3) || affix_5.contains(affix_4) || obj.get(affix_5).getAsBoolean() == false || !affix_5.contains("affix")) {
										affix_5 = obj.keySet().stream().toList().get((Mth.nextInt(RandomSource.create(), 0, 23)));
										if (timeout > 10000) {
											timeout = 0;
											break;
										}
									}
									{
										String[] _array = (affix_1 + "," + affix_2 + "," + affix_3 + "," + affix_4 + "," + affix_5).split(",");
										if (_array.length != 0) {
											for (String stringiterator : _array) {
												entity.getPersistentData().putBoolean(stringiterator, true);
											}
										} else {
											String stringiterator = (affix_1 + "," + affix_2 + "," + affix_3 + "," + affix_4 + "," + affix_5);
											entity.getPersistentData().putBoolean(stringiterator, true);
										}
									}
									entity.setCustomName(Component.literal((("Elite " + entity.getDisplayName().getString() + " - " + affix_1 + affix_2 + affix_3 + affix_4 + affix_5 + "-").replace("_affix", " "))));
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
