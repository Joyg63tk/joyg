package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.joyg.init.JoygModEntities;
import net.joyg.entity.BHammerEntity;

public class BlessedHammerCastProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level)
			((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("joyg:hammer_spawn")), SoundSource.PLAYERS, 1, 1);
		if (world instanceof ServerLevel _level) {
			System.out.println(entity.getStringUUID());
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as " + entity.getStringUUID() + " run particlesetrel light_expansion 1");
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entityinstance = JoygModEntities.B_HAMMER.get().create(_serverLevel, null, null, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED, false, false);
			if (entityinstance != null) {
				entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
				if (entityinstance instanceof BHammerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BHammerEntity.DATA_damageCD, (int) (20 / ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getValue()));
				if (entityinstance instanceof BHammerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BHammerEntity.DATA_damage,
							(int) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue()
									* ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("irons_spellbooks:holy_spell_power"))).getValue()
									+ ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("additional_attributes:spell_school_holy"))).getValue()));
				if (entityinstance instanceof BHammerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BHammerEntity.DATA_age, (int) (100 / ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).getValue()));
				if (entityinstance instanceof TamableAnimal _toTame && entity instanceof Player _owner)
					_toTame.tame(_owner);
				_serverLevel.addFreshEntity(entityinstance);
			}
		}
	}
}
