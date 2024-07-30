package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.joyg.init.JoygModMobEffects;

import java.util.List;
import java.util.Comparator;

public class BloodMeldCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double mobs = 0;
		entity.invulnerableTime = 20;
		if (world instanceof Level)
			((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("joyg:blood_meld")), SoundSource.PLAYERS, 1, 1);
		if (world instanceof ServerLevel _level) {
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute positioned ~ ~ ~ run particlecircle large_ritual_circle 2");
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(JoygModMobEffects.HEMORRHAGE.get())) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.removeEffect(JoygModMobEffects.HEMORRHAGE.get());
					mobs = mobs + 1;
				}
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.forceAddEffect(new MobEffectInstance(JoygModMobEffects.BLOOD_MELD.get(), 120, (int) mobs, false, false), entity);
	}
}
