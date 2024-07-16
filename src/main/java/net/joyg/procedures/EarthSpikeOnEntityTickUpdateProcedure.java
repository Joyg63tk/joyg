package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.joyg.entity.EarthSpikeEntity;

public class EarthSpikeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof EarthSpikeEntity _datEntSetI)
			_datEntSetI.getEntityData().set(EarthSpikeEntity.DATA_age, (int) ((entity instanceof EarthSpikeEntity _datEntI ? _datEntI.getEntityData().get(EarthSpikeEntity.DATA_age) : 0) + 1));
		if ((entity instanceof EarthSpikeEntity _datEntI ? _datEntI.getEntityData().get(EarthSpikeEntity.DATA_age) : 0) > 1) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ancient_debris.break")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.ancient_debris.break")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
