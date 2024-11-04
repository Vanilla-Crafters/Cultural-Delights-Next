package dev.sterner.culturaldelights.common.world;

import dev.sterner.culturaldelights.common.registry.CDWorldGenerators;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class AvocadoPitGenerator {

    @Nullable
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return CDWorldGenerators.AVOCADO_PIT;
    }
}
