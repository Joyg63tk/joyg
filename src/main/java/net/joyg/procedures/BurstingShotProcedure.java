package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.joyg.network.JoygModVariables;

import java.util.List;
import java.util.Comparator;

public class BurstingShotProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).burstingShot) {
			if ((sourceentity != null ? entity.distanceTo(sourceentity) : -1) < 4 && damagesource.isIndirect()) {
				if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).burstingShotCD < 1) {
					{
						double _setval = 200;
						sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.burstingShotCD = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 1, 2);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.HOSTILE, 1, 2, false);
						}
					}
					entity.setDeltaMovement(new Vec3((5 * sourceentity.getLookAngle().x), 0.5, (5 * sourceentity.getLookAngle().z)));
					Vec3 motion = entity.getDeltaMovement().scale(1);
					entity.setDeltaMovement(motion);
					if ((sourceentity.getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).disengage) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == sourceentity)) {
									entityiterator.setDeltaMovement(new Vec3((5 * sourceentity.getLookAngle().x), 0.5, (5 * sourceentity.getLookAngle().z)));
								}
							}
						}
					}
				}
			}
		}
	}
}
