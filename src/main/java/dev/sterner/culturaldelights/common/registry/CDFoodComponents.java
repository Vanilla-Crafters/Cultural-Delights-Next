package dev.sterner.culturaldelights.common.registry;

import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.registry.entry.RegistryEntry;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class CDFoodComponents {
    //INGREDIENTS
    public static final FoodComponent AVOCADO = (new FoodComponent.Builder()).nutrition(4).saturationModifier(0.6F).build();
    public static final FoodComponent CUCUMBER = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.5F).build();
    public static final FoodComponent PICKLE = (new FoodComponent.Builder()).nutrition(4).saturationModifier(0.7F).build();
    public static final FoodComponent EGGPLANT = (new FoodComponent.Builder()).nutrition(3).saturationModifier(0.2F).build();
    public static final FoodComponent SMOKED_EGGPLANT = (new FoodComponent.Builder()).nutrition(8).saturationModifier(0.6F).build();
    public static final FoodComponent SMOKED_TOMATO = (new FoodComponent.Builder()).nutrition(4).saturationModifier(0.6F).build();
    public static final FoodComponent SMOKED_CORN = (new FoodComponent.Builder()).nutrition(5).saturationModifier(0.7F).build();
    public static final FoodComponent SMOKED_WHITE_EGGPLANT = (new FoodComponent.Builder()).nutrition(3).saturationModifier(0.5F).build();
    public static final FoodComponent WHITE_EGGPLANT = (new FoodComponent.Builder()).nutrition(1).saturationModifier(0.1F).build();
    public static final FoodComponent CORN_COB = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.4F).build();
    public static final FoodComponent SQUID = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.2F).build();
    public static final FoodComponent COOKED_SQUID = (new FoodComponent.Builder()).nutrition(6).saturationModifier(0.8F).build();
    public static final FoodComponent GLOW_SQUID = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 40, 1), 1.0F).snack().build();
    public static final FoodComponent RAW_CALAMARI = (new FoodComponent.Builder()).nutrition(1).saturationModifier(0.2F).build();
    public static final FoodComponent COOKED_CALAMARI = (new FoodComponent.Builder()).nutrition(3).saturationModifier(0.5F).build();

    public static final FoodComponent CUT_AVOCADO = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.3F).snack().build();
    public static final FoodComponent CUT_CUCUMBER = (new FoodComponent.Builder()).nutrition(1).saturationModifier(0.3F).snack().build();
    public static final FoodComponent CUT_PICKLE = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.5F).snack().build();
    public static final FoodComponent CUT_EGGPLANT = (new FoodComponent.Builder()).nutrition(1).saturationModifier(0.1F).snack().build();
    public static final FoodComponent SMOKED_CUT_EGGPLANT = (new FoodComponent.Builder()).nutrition(4).saturationModifier(0.4F).snack().build();

    //SUSHI
    public static final FoodComponent MIDORI_ROLL = (new FoodComponent.Builder()).nutrition(14).saturationModifier(0.7F).build();
    public static final FoodComponent MIDORI_ROLL_SLICE = (new FoodComponent.Builder()).nutrition(7).saturationModifier(0.4F).snack().build();
    public static final FoodComponent EGG_ROLL = (new FoodComponent.Builder()).nutrition(5).saturationModifier(0.5F).snack().build();
    public static final FoodComponent CHICKEN_ROLL = (new FoodComponent.Builder()).nutrition(16).saturationModifier(0.8F).build();
    public static final FoodComponent CHICKEN_ROLL_SLICE = (new FoodComponent.Builder()).nutrition(8).saturationModifier(0.6F).snack().build();
    public static final FoodComponent PUFFERFISH_ROLL = (new FoodComponent.Builder()).nutrition(7).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 1), 1.0F).snack().build();
    public static final FoodComponent TROPICAL_ROLL = (new FoodComponent.Builder()).nutrition(7).saturationModifier(0.6F).snack().build();
    public static final FoodComponent RICE_BALL = (new FoodComponent.Builder()).nutrition(3).saturationModifier(0.5F).snack().build();
    public static final FoodComponent CALAMARI_ROLL = (new FoodComponent.Builder()).nutrition(7).saturationModifier(0.6F).snack().build();

    //MEALS
    public static final FoodComponent CORN_DOUGH = (new FoodComponent.Builder()).nutrition(1).saturationModifier(0.1F).build();
    public static final FoodComponent TORTILLA = (new FoodComponent.Builder()).nutrition(4).saturationModifier(0.6F).build();
    public static final FoodComponent POPCORN = (new FoodComponent.Builder()).nutrition(1).saturationModifier(0.2F).snack().build();
    public static final FoodComponent TORTILLA_CHIPS = (new FoodComponent.Builder()).nutrition(2).saturationModifier(0.3F).snack().build();
    public static final FoodComponent ELOTE = (new FoodComponent.Builder()).nutrition(6).saturationModifier(0.8F).build();
    public static final FoodComponent BEEF_BURRITO = (new FoodComponent.Builder()).nutrition(14).saturationModifier(0.7F).build();
    public static final FoodComponent MUTTON_SANDWICH = (new FoodComponent.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final FoodComponent AVOCADO_TOAST = (new FoodComponent.Builder()).nutrition(4).saturationModifier(0.5F).build();
    public static final FoodComponent CREAMED_CORN = (new FoodComponent.Builder()).nutrition(6).saturationModifier(0.8F).build();
    public static final FoodComponent CHICKEN_TACO = (new FoodComponent.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final FoodComponent PORK_WRAP = (new FoodComponent.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final FoodComponent FISH_TACO = (new FoodComponent.Builder()).nutrition(10).saturationModifier(0.8F).build();
    public static final FoodComponent HEARTY_SALAD = (new FoodComponent.Builder()).nutrition(7).saturationModifier(0.7F)
            .statusEffect(new StatusEffectInstance(RegistryEntry.of(ModEffects.NOURISHMENT.value()), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodComponent FRIED_EGGPLANT_PASTA = (new FoodComponent.Builder()).nutrition(12).saturationModifier(0.9F)
            .statusEffect(new StatusEffectInstance(RegistryEntry.of(ModEffects.NOURISHMENT.value()), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodComponent EGGPLANT_BURGER = (new FoodComponent.Builder()).nutrition(12).saturationModifier(0.7F).build();
    public static final FoodComponent SPICY_CURRY = (new FoodComponent.Builder()).nutrition(12).saturationModifier(1.3F)
            .statusEffect(new StatusEffectInstance(RegistryEntry.of(ModEffects.NOURISHMENT.value()), FoodValues.LONG_DURATION, 0), 1.0F).build();
}
