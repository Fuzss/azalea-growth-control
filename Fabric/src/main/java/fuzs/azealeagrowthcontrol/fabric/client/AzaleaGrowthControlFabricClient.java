package fuzs.azealeagrowthcontrol.fabric.client;

import fuzs.azealeagrowthcontrol.AzaleaGrowthControl;
import fuzs.azealeagrowthcontrol.client.AzaleaGrowthControlClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class AzaleaGrowthControlFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControlClient::new);
    }
}
