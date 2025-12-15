package fuzs.azaleagrowthcontrol.neoforge;

import fuzs.azaleagrowthcontrol.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.data.ModBiomeTagsProvider;
import fuzs.azaleagrowthcontrol.data.ModDatapackRegistriesProvider;
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
