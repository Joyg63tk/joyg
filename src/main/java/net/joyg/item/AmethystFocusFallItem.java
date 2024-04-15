
package net.joyg.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class AmethystFocusFallItem extends Item {
	public AmethystFocusFallItem() {
		super(new Item.Properties().durability(2031).rarity(Rarity.EPIC));
	}

	@Override
	public int getEnchantmentValue() {
		return 22;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("While in Offhand: Grants 70 increased Max Mana"));
		list.add(Component.literal("Your Arcane Familiar fires Eldritch Blast"));
	}
}
