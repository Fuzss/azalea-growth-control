package fuzs.azaleagrowthcontrol.neoforge;

import fuzs.azaleagrowthcontrol.common.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.common.data.ModBiomeTagsProvider;
import fuzs.azaleagrowthcontrol.common.data.ModDatapackRegistriesProvider;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
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
