package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.joyg.init.JoygModEntities;
import net.joyg.entity.AutoBallistaEntity;

public class BallistaCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverLevel) {
			Entity entityinstance = JoygModEntities.AUTO_BALLISTA.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
			if (entityinstance != null) {
				entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
				if (entityinstance instanceof AutoBallistaEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AutoBallistaEntity.DATA_arrows, (int) (10 + ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("additional_attributes:spell_school_evocation"))).getValue()
							+ ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("irons_spellbooks:evocation_spell_power"))).getValue()));
				if (world instanceof Level)
					((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("joyg:mech1")), SoundSource.AMBIENT, 1, 1);
				_serverLevel.addFreshEntity(entityinstance);
			}
		}
	}
}
