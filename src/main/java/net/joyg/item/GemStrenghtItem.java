
package net.joyg.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.joyg.procedures.GemStrenghtWhileBaubleIsEquippedTickProcedure;

import java.util.List;

public class GemStrenghtItem extends Item implements ICurioItem {
	public GemStrenghtItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Aura Gem"));
		list.add(Component.literal("While equpped grants your pets and all players within 16m Strenght 1"));
		list.add(Component.literal("Overloads 5 mana per second"));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		GemStrenghtWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ(), slotContext.entity());
	}
}
