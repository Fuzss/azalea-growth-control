package fuzs.azaleagrowthcontrol.fabric.client;

import fuzs.azaleagrowthcontrol.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.client.AzaleaGrowthControlClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class AzaleaGrowthControlFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControlClient::new);
    }
}
