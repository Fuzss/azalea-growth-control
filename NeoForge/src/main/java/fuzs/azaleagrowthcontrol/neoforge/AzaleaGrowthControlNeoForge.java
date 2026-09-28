package fuzs.azaleagrowthcontrol.neoforge;

import fuzs.azaleagrowthcontrol.common.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.common.data.tags.ModBiomeTagsProvider;
import fuzs.azaleagrowthcontrol.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.fml.common.Mod;

@Mod(AzaleaGrowthControl.MOD_ID)
public class AzaleaGrowthControlNeoForge {

    public AzaleaGrowthControlNeoForge() {
        ModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControl::new);
        DataProviderBuilder.of(AzaleaGrowthControl.MOD_ID)
                .addWorldBootstrap(Registries.FEATURE, ModRegistry::bootstrapFeatures)
                .addProvider(ModBiomeTagsProvider::new);
    }
}
