/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

import net.joyg.JoygMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JoygModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, JoygMod.MODID);
	public static final RegistryObject<Attribute> MANAONHITCHANCE = ATTRIBUTES.register("mana_on_hit_chance", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".mana_on_hit_chance", 0, 0, 100)).setSyncable(true));
	public static final RegistryObject<Attribute> MANAGAINEDONHIT = ATTRIBUTES.register("mana_gained_on_hit", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".mana_gained_on_hit", 1, 1, 256)).setSyncable(true));
	public static final RegistryObject<Attribute> ENVENOM = ATTRIBUTES.register("envenom", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".envenom", 0, 0, 100)).setSyncable(true));
	public static final RegistryObject<Attribute> MAIM = ATTRIBUTES.register("maim", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".maim", 0, 0, 100)).setSyncable(true));
	public static final RegistryObject<Attribute> CRITICALBLOCKCHANCE = ATTRIBUTES.register("critical_block_chance", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".critical_block_chance", 0, 0, 100)).setSyncable(true));
	public static final RegistryObject<Attribute> MANALEECH = ATTRIBUTES.register("mana_leech", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".mana_leech", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> MAXABSOPTION = ATTRIBUTES.register("max_absoption", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".max_absoption", 0, 0, 200)).setSyncable(true));
	public static final RegistryObject<Attribute> ABSOPTIONRECHARGERATE = ATTRIBUTES.register("absoption_recharge_rate", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".absoption_recharge_rate", 60, 5, 200)).setSyncable(true));
	public static final RegistryObject<Attribute> ABSOPTIONDELAY = ATTRIBUTES.register("absoption_delay", () -> (new RangedAttribute("attribute." + JoygMod.MODID + ".absoption_delay", 200, 5, 1000)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, MANAONHITCHANCE.get());
		event.add(EntityType.PLAYER, MANAONHITCHANCE.get());
		event.add(EntityType.PLAYER, MANAGAINEDONHIT.get());
		event.add(EntityType.PLAYER, MANAGAINEDONHIT.get());
		event.add(EntityType.PLAYER, ENVENOM.get());
		event.add(EntityType.PLAYER, ENVENOM.get());
		event.add(EntityType.PLAYER, MAIM.get());
		event.add(EntityType.PLAYER, MAIM.get());
		event.add(EntityType.PLAYER, CRITICALBLOCKCHANCE.get());
		event.add(EntityType.PLAYER, CRITICALBLOCKCHANCE.get());
		event.add(EntityType.PLAYER, MANALEECH.get());
		event.add(EntityType.PLAYER, MANALEECH.get());
		event.add(EntityType.PLAYER, MAXABSOPTION.get());
		event.add(EntityType.PLAYER, MAXABSOPTION.get());
		event.add(EntityType.PLAYER, ABSOPTIONRECHARGERATE.get());
		event.add(EntityType.PLAYER, ABSOPTIONRECHARGERATE.get());
		event.add(EntityType.PLAYER, ABSOPTIONDELAY.get());
		event.add(EntityType.PLAYER, ABSOPTIONDELAY.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(MANAONHITCHANCE.get()).setBaseValue(oldP.getAttribute(MANAONHITCHANCE.get()).getBaseValue());
			newP.getAttribute(MANAGAINEDONHIT.get()).setBaseValue(oldP.getAttribute(MANAGAINEDONHIT.get()).getBaseValue());
			newP.getAttribute(ENVENOM.get()).setBaseValue(oldP.getAttribute(ENVENOM.get()).getBaseValue());
			newP.getAttribute(MAIM.get()).setBaseValue(oldP.getAttribute(MAIM.get()).getBaseValue());
			newP.getAttribute(CRITICALBLOCKCHANCE.get()).setBaseValue(oldP.getAttribute(CRITICALBLOCKCHANCE.get()).getBaseValue());
			newP.getAttribute(MANALEECH.get()).setBaseValue(oldP.getAttribute(MANALEECH.get()).getBaseValue());
			newP.getAttribute(MAXABSOPTION.get()).setBaseValue(oldP.getAttribute(MAXABSOPTION.get()).getBaseValue());
			newP.getAttribute(ABSOPTIONRECHARGERATE.get()).setBaseValue(oldP.getAttribute(ABSOPTIONRECHARGERATE.get()).getBaseValue());
			newP.getAttribute(ABSOPTIONDELAY.get()).setBaseValue(oldP.getAttribute(ABSOPTIONDELAY.get()).getBaseValue());
		}
	}
}
