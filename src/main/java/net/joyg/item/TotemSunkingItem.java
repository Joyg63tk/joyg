
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

public class TotemSunkingItem extends Item {
	public TotemSunkingItem() {
		super(new Item.Properties().durability(2031).rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Unique Totem"));
		list.add(Component.literal("While in Offhand: Gain 50 mana each time you take damage"));
		list.add(Component.literal("While you have Idolatry passive alocated: Totems you summon cast Firebolt instead"));
	}
}
