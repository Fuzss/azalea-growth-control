package fuzs.azealeagrowthcontrol.world.level.levelgen.blockpredicates;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fuzs.azealeagrowthcontrol.init.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicateType;

public class MatchingBiomeTagPredicate implements BlockPredicate {
    public static final MapCodec<MatchingBiomeTagPredicate> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                    TagKey.codec(Registries.BIOME)
                            .fieldOf("tag")
                            .forGetter((MatchingBiomeTagPredicate matchingBiomeTagPredicate) -> matchingBiomeTagPredicate.tag))
            .apply(instance, MatchingBiomeTagPredicate::new));
    final TagKey<Biome> tag;

    public MatchingBiomeTagPredicate(TagKey<Biome> tag) {
        this.tag = tag;
    }

    @Override
    public boolean test(WorldGenLevel worldGenLevel, BlockPos blockPos) {
        return worldGenLevel.getBiome(blockPos).is(this.tag);
    }

    @Override
    public BlockPredicateType<?> type() {
        return ModRegistry.MATCHING_BIOME_TAG_BLOCK_PREDICATE_TYPE.value();
    }
}
