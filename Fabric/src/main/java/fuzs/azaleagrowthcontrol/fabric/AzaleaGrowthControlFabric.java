package fuzs.azaleagrowthcontrol.fabric;

import fuzs.azaleagrowthcontrol.common.AzaleaGrowthControl;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class AzaleaGrowthControlFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControl::new);
    }
}
