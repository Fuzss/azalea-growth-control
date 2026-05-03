package fuzs.azaleagrowthcontrol.common.data;

import fuzs.azaleagrowthcontrol.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v2.AbstractDatapackRegistriesProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.core.registries.Registries;

public class ModDatapackRegistriesProvider extends AbstractDatapackRegistriesProvider {

    public ModDatapackRegistriesProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addBootstrap(RegistryBoostrapConsumer consumer) {
        consumer.add(Registries.CONFIGURED_FEATURE, ModRegistry::bootstrapConfiguredFeatures);
    }
}
