package dev.sterner.culturaldelights;

import com.mojang.serialization.MapCodec;
import dev.sterner.culturaldelights.common.registry.CDObjects;
import dev.sterner.culturaldelights.common.registry.CDConfiguredFeatures;
import dev.sterner.culturaldelights.common.registry.CDWorldGenerators;
import dev.sterner.culturaldelights.common.utils.Constants;
import dev.sterner.culturaldelights.common.world.AvocadoBundleTreeDecorator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class CulturalDelights implements ModInitializer {
	public static final String MOD_ID = "culturaldelights";
	private static final Identifier SQUID_LOOT_TABLE_ID = EntityType.SQUID.getLootTableId().getValue();
	private static final Identifier GLOW_SQUID_LOOT_TABLE_ID = EntityType.GLOW_SQUID.getLootTableId().getValue();


	// Registering the Avocado Bundle Tree Decorator Type
	public static final TreeDecoratorType<AvocadoBundleTreeDecorator> AVOCADO_BUNDLE_TREE_DECORATOR_TYPE = register(Constants.id("avocado_bundle"), AvocadoBundleTreeDecorator.MAP_CODEC);

	// Registration method using MapCodec
	private static <P extends TreeDecorator> TreeDecoratorType<P> register(Identifier id, MapCodec<P> codec) {
		return Registry.register(Registries.TREE_DECORATOR_TYPE, id, new TreeDecoratorType<>(codec));
	}

	@Override
	public void onInitialize() {
		CDObjects.init();
		CDConfiguredFeatures.registerAll();
		CDWorldGenerators.init();

		// Biome modifications
		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
				GenerationStep.Feature.VEGETAL_DECORATION,
				CDConfiguredFeatures.PATCH_WILD_CORN.key()
		);

		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
				GenerationStep.Feature.VEGETAL_DECORATION,
				CDConfiguredFeatures.PATCH_WILD_EGGPLANTS.key()
		);

		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
				GenerationStep.Feature.VEGETAL_DECORATION,
				CDConfiguredFeatures.PATCH_WILD_CUCUMBERS.key()
		);

		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
				GenerationStep.Feature.VEGETAL_DECORATION,
				CDConfiguredFeatures.PATCH_WILD_EGGPLANTS.key()
		);

		// Villager trade offers
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.CUCUMBER), 1, 10, 2, 0.2F));
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.EGGPLANT), 1, 10, 2, 0.2F));
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.CORN_COB), 1, 10, 2, 0.2F));
			factories.add(new EmeraldToItemOffer(new ItemStack(CDObjects.AVOCADO), 1, 10, 2, 0.2F));
		});

		// Loot table modifications
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (source.isBuiltin() && SQUID_LOOT_TABLE_ID.equals(key)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(CDObjects.SQUID));
				tableBuilder.pool(poolBuilder.build());
			}

			if (source.isBuiltin() && GLOW_SQUID_LOOT_TABLE_ID.equals(key)) {
				LootPool.Builder poolBuilder = LootPool.builder()
						.with(ItemEntry.builder(CDObjects.GLOW_SQUID));
				tableBuilder.pool(poolBuilder.build());
			}
		});


	}

	public static class EmeraldToItemOffer implements TradeOffers.Factory {
		private final ItemStack sell;
		private final int price;
		private final int maxUses;
		private final int experience;
		private final float multiplier;

		public EmeraldToItemOffer(ItemStack stack, int price, int maxUses, int experience, float multiplier) {
			this.sell = stack;
			this.price = price;
			this.maxUses = maxUses;
			this.experience = experience;
			this.multiplier = multiplier;
		}

		public TradeOffer create(Entity entity, net.minecraft.util.math.random.Random random) {
			return new TradeOffer(new TradedItem(Items.EMERALD, this.price + random.nextInt(3)),
					this.sell,
					this.maxUses,
					this.experience,
					this.multiplier);
		}
	}
}
