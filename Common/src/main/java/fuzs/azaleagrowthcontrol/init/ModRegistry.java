package fuzs.azaleagrowthcontrol.init;

import fuzs.azaleagrowthcontrol.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.world.level.levelgen.blockpredicates.MatchingBiomeTagPredicate;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.puzzleslib.api.init.v3.tags.TagFactory;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicateType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RootSystemConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModRegistry {
    public static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE,
            ModRegistry::bootstrapConfiguredFeatures);
    static final RegistryManager REGISTRIES = RegistryManager.from(AzaleaGrowthControl.MOD_ID);
    public static final Holder.Reference<BlockPredicateType<MatchingBiomeTagPredicate>> MATCHING_BIOME_TAG_BLOCK_PREDICATE_TYPE = REGISTRIES.register(
            Registries.BLOCK_PREDICATE_TYPE,
            "matching_biome_tag",
            () -> () -> MatchingBiomeTagPredicate.CODEC);

    static final TagFactory TAGS = TagFactory.make(AzaleaGrowthControl.MOD_ID);
    public static final TagKey<Biome> GROWS_AZALEA_TREES_BIOME_TAG = TAGS.registerBiomeTag("grows_azalea_trees");

    public static void bootstrap() {
        // NO-OP
    }

    public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context,
                CaveFeatures.ROOTED_AZALEA_TREE,
                Feature.ROOT_SYSTEM,
                new RootSystemConfiguration(PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(TreeFeatures.AZALEA_TREE)),
                        3,
                        3,
                        BlockTags.AZALEA_ROOT_REPLACEABLE,
                        BlockStateProvider.simple(Blocks.ROOTED_DIRT),
                        20,
                        100,
                        3,
                        2,
                        BlockStateProvider.simple(Blocks.HANGING_ROOTS),
                        20,
                        2,
                        BlockPredicate.allOf(BlockPredicate.anyOf(BlockPredicate.matchesBlocks(List.of(Blocks.AIR,
                                        Blocks.CAVE_AIR,
                                        Blocks.VOID_AIR)), BlockPredicate.matchesTag(BlockTags.REPLACEABLE_BY_TREES)),
                                BlockPredicate.matchesTag(Direction.DOWN.getUnitVec3i(), BlockTags.AZALEA_GROWS_ON),
                                new MatchingBiomeTagPredicate(GROWS_AZALEA_TREES_BIOME_TAG))));
    }
}
