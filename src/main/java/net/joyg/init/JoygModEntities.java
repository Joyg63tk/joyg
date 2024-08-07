
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.joyg.entity.WindbladeEntity;
import net.joyg.entity.TotemEntity;
import net.joyg.entity.PortalEntity;
import net.joyg.entity.LootbagEEntity;
import net.joyg.entity.GoreSpikeEntity;
import net.joyg.entity.EarthSpikeEntity;
import net.joyg.entity.BHammerEntity;
import net.joyg.entity.AutoBallistaEntity;
import net.joyg.entity.ArcaneFamiliarEntity;
import net.joyg.JoygMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JoygModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, JoygMod.MODID);
	public static final RegistryObject<EntityType<LootbagEEntity>> LOOTBAG_E = register("lootbag_e",
			EntityType.Builder.<LootbagEEntity>of(LootbagEEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LootbagEEntity::new).fireImmune().sized(0.5f, 1f));
	public static final RegistryObject<EntityType<PortalEntity>> PORTAL = register("portal",
			EntityType.Builder.<PortalEntity>of(PortalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PortalEntity::new).fireImmune().sized(0.6f, 2f));
	public static final RegistryObject<EntityType<ArcaneFamiliarEntity>> ARCANE_FAMILIAR = register("arcane_familiar",
			EntityType.Builder.<ArcaneFamiliarEntity>of(ArcaneFamiliarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArcaneFamiliarEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<TotemEntity>> TOTEM = register("totem",
			EntityType.Builder.<TotemEntity>of(TotemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TotemEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AutoBallistaEntity>> AUTO_BALLISTA = register("auto_ballista",
			EntityType.Builder.<AutoBallistaEntity>of(AutoBallistaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AutoBallistaEntity::new)

					.sized(0.8f, 0.4f));
	public static final RegistryObject<EntityType<EarthSpikeEntity>> EARTH_SPIKE = register("earth_spike",
			EntityType.Builder.<EarthSpikeEntity>of(EarthSpikeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EarthSpikeEntity::new)

					.sized(0.3f, 1.8f));
	public static final RegistryObject<EntityType<WindbladeEntity>> WINDBLADE = register("windblade",
			EntityType.Builder.<WindbladeEntity>of(WindbladeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WindbladeEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<BHammerEntity>> B_HAMMER = register("b_hammer",
			EntityType.Builder.<BHammerEntity>of(BHammerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BHammerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GoreSpikeEntity>> GORE_SPIKE = register("gore_spike",
			EntityType.Builder.<GoreSpikeEntity>of(GoreSpikeEntity::new, MobCategory.MISC).setCustomClientFactory(GoreSpikeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			LootbagEEntity.init();
			PortalEntity.init();
			ArcaneFamiliarEntity.init();
			TotemEntity.init();
			AutoBallistaEntity.init();
			EarthSpikeEntity.init();
			WindbladeEntity.init();
			BHammerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LOOTBAG_E.get(), LootbagEEntity.createAttributes().build());
		event.put(PORTAL.get(), PortalEntity.createAttributes().build());
		event.put(ARCANE_FAMILIAR.get(), ArcaneFamiliarEntity.createAttributes().build());
		event.put(TOTEM.get(), TotemEntity.createAttributes().build());
		event.put(AUTO_BALLISTA.get(), AutoBallistaEntity.createAttributes().build());
		event.put(EARTH_SPIKE.get(), EarthSpikeEntity.createAttributes().build());
		event.put(WINDBLADE.get(), WindbladeEntity.createAttributes().build());
		event.put(B_HAMMER.get(), BHammerEntity.createAttributes().build());
	}
}
