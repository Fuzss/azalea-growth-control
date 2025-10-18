package fuzs.azaleagrowthcontrol.fabric;

import fuzs.azaleagrowthcontrol.AzaleaGrowthControl;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class AzaleaGrowthControlFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControl::new);
    }
}
