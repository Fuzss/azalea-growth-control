package fuzs.azaleagrowthcontrol.common.init;

import fuzs.azaleagrowthcontrol.common.AzaleaGrowthControl;
import fuzs.puzzleslib.common.api.init.v3.tags.TagFactory;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.blockpredicates.MatchingBiomesPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RootSystemFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModRegistry {
    static final TagFactory TAGS = TagFactory.make(AzaleaGrowthControl.MOD_ID);
    public static final TagKey<Biome> GROWS_AZALEA_TREES_BIOME_TAG = TAGS.registerBiomeTag("grows_azalea_trees");

    public static void bootstrap() {
        // NO-OP
    }

    /**
     * @see CaveFeatures#bootstrap(BootstrapContext)
     */
    public static void bootstrapFeatures(BootstrapContext<Feature> context) {
        context.register(CaveFeatures.ROOTED_AZALEA_TREE,
                new RootSystemFeature(PlacementUtils.inlinePlaced(context.lookup(Registries.FEATURE)
                        .getOrThrow(TreeFeatures.AZALEA_TREE)),
                        3,
                        0,
                        0,
                        3,
                        context.lookup(Registries.BLOCK).getOrThrow(BlockTags.AZALEA_ROOT_REPLACEABLE),
                        BlockStateProvider.holderOf(Blocks.ROOTED_DIRT),
                        20,
                        100,
                        3,
                        2,
                        BlockStateProvider.holderOf(Blocks.HANGING_ROOTS),
                        20,
                        2,
                        BlockPredicate.allOf(BlockPredicate.anyOf(BlockPredicate.matchesBlocks(Blocks.AIR,
                                        Blocks.CAVE_AIR,
                                        Blocks.VOID_AIR), BlockPredicate.matchesTag(BlockTags.REPLACEABLE_BY_TREES)),
                                BlockPredicate.matchesTag(Direction.DOWN.getUnitVec3i(), BlockTags.AZALEA_GROWS_ON),
                                new MatchingBiomesPredicate(context.lookup(Registries.BIOME)
                                        .getOrThrow(GROWS_AZALEA_TREES_BIOME_TAG)))));
    }
}
