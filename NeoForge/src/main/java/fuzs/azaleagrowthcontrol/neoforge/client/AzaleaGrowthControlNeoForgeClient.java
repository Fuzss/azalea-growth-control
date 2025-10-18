package fuzs.azaleagrowthcontrol.neoforge.client;

import fuzs.azaleagrowthcontrol.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.client.AzaleaGrowthControlClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = AzaleaGrowthControl.MOD_ID, dist = Dist.CLIENT)
public class AzaleaGrowthControlNeoForgeClient {

    public AzaleaGrowthControlNeoForgeClient() {
        ClientModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControlClient::new);
    }
}
