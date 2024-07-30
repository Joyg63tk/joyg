package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.joyg.entity.BHammerEntity;

import java.util.List;
import java.util.Comparator;

public class BHammerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 5, 3, 0, 3, 0.1);
			entity.getPersistentData().putDouble("dCD", (entity.getPersistentData().getDouble("dCD") + 0));
			if (entity.getPersistentData().getDouble("dCD") >= (entity instanceof BHammerEntity _datEntI ? _datEntI.getEntityData().get(BHammerEntity.DATA_damageCD) : 0)) {
				entity.getPersistentData().putDouble("dCD", 0);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 5, 1, 0, 1, 0.1);
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC), (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)),
								(float) (entity instanceof BHammerEntity _datEntI ? _datEntI.getEntityData().get(BHammerEntity.DATA_damage) : 0));
						if (world instanceof Level)
							((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("joyg:hammer_hit")), SoundSource.NEUTRAL, 1, 1);
					}
				}
			}
		}
		entity.getPersistentData().putDouble("age", (entity.getPersistentData().getDouble("age") + 0));
		if (entity.getPersistentData().getDouble("age") >= (entity instanceof BHammerEntity _datEntI ? _datEntI.getEntityData().get(BHammerEntity.DATA_age) : 0)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 6, 3, 3, 3, 0);
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
