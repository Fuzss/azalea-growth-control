package fuzs.azaleagrowthcontrol.data;

import fuzs.azaleagrowthcontrol.init.ModRegistry;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.puzzleslib.api.init.v3.tags.TagFactory;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTagsProvider extends AbstractTagProvider<Biome> {
    public static final TagKey<Biome> IS_PLAINS = TagFactory.COMMON.registerBiomeTag("is_plains");
    public static final TagKey<Biome> IS_SNOWY_PLAINS = TagFactory.COMMON.registerBiomeTag("is_snowy_plains");
    public static final TagKey<Biome> IS_SWAMP = TagFactory.COMMON.registerBiomeTag("is_swamp");

    public ModBiomeTagsProvider(DataProviderContext context) {
        super(Registries.BIOME, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(ModRegistry.GROWS_AZALEA_TREES_BIOME_TAG)
                .addTag(BiomeTags.IS_MOUNTAIN, BiomeTags.IS_TAIGA, BiomeTags.IS_JUNGLE, BiomeTags.IS_FOREST)
                .addOptionalTag(IS_PLAINS, IS_SNOWY_PLAINS, IS_SWAMP);
    }
}
