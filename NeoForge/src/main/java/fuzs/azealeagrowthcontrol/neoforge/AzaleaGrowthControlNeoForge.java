package fuzs.azealeagrowthcontrol.neoforge;

import fuzs.azealeagrowthcontrol.AzaleaGrowthControl;
import fuzs.azealeagrowthcontrol.data.ModBiomeTagsProvider;
import fuzs.azealeagrowthcontrol.data.ModDatapackRegistriesProvider;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.neoforged.fml.common.Mod;

@Mod(AzaleaGrowthControl.MOD_ID)
public class AzaleaGrowthControlNeoForge {

    public AzaleaGrowthControlNeoForge() {
        ModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControl::new);
        DataProviderHelper.registerDataProviders(AzaleaGrowthControl.MOD_ID,
                ModDatapackRegistriesProvider::new,
                ModBiomeTagsProvider::new);
    }
}
