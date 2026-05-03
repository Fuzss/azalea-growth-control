package fuzs.azaleagrowthcontrol.neoforge.client;

import fuzs.azaleagrowthcontrol.common.AzaleaGrowthControl;
import fuzs.azaleagrowthcontrol.common.client.AzaleaGrowthControlClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = AzaleaGrowthControl.MOD_ID, dist = Dist.CLIENT)
public class AzaleaGrowthControlNeoForgeClient {

    public AzaleaGrowthControlNeoForgeClient() {
        ClientModConstructor.construct(AzaleaGrowthControl.MOD_ID, AzaleaGrowthControlClient::new);
    }
}
