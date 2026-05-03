package fuzs.azaleagrowthcontrol.fabric.client;

import fuzs.azaleagrowthcontrol.common.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.common.client.AzaleaGrowthControlClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class AzaleaGrowthControlFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControlClient::new);
    }
}
