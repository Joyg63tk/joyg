package net.joyg.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.joyg.network.JoygModVariables;
import net.joyg.init.JoygModEnchantments;
import net.joyg.entity.TotemEntity;

public class TotemOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if (!(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("joyg:totems"))))) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
			if (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(JoygModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JoygModVariables.PlayerVariables())).idolatry == false) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
			entity.getPersistentData().putDouble("cast", (entity.getPersistentData().getDouble("cast") + 1));
			if (entity.getPersistentData().getDouble("cast") >= 40) {
				entity.getPersistentData().putDouble("cast", 0);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("teleport @s ~ ~ ~ facing " + ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()) + " "
										+ ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + entity.getEyeHeight()) + " " + ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("cast @s " + (entity instanceof TotemEntity _datEntS ? _datEntS.getEntityData().get(TotemEntity.DATA_spell) : "") + " "
										+ (1 + ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)
												.getEnchantmentLevel(JoygModEnchantments.EMPOWER.get()))));
					}
				}
			}
		}
	}
}
