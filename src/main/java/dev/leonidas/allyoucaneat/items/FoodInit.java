package dev.leonidas.allyoucaneat.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;


public class FoodInit {

    public static final FoodComponent CHICKEN_BUCKET = new FoodComponent.Builder()
            .alwaysEdible()
            .meat()
            .hunger(20)
            .saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 2), 1f)
            .build();

    public static final FoodComponent BACON_SANDWICH = new FoodComponent.Builder()
            .meat()
            .hunger(12)
            .saturationModifier(0.8f)
            .build();


    // CROPS

    public static final FoodComponent TOMATO = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.5f)
            .build();

    public static final FoodComponent ONION = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.5f)
            .build();


}
