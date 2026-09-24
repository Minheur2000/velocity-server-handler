package net.velocityHelper.potoflux;

import net.minheur.potoflux.loader.mod.events.RegisterTabsEvent;
import net.minheur.potoflux.registry.RegistryList;
import net.minheur.potoflux.screen.tabs.Tab;
import net.minheur.potoflux.utils.SmartSupplier;
import net.minheur.potoflux.utils.ressourcelocation.ResourceLocation;
import net.velocityHelper.VelocityHelper;

public class Tabs {
    private static final RegistryList<net.minheur.potoflux.screen.tabs.Tab> LIST = new RegistryList<>();

    public static final SmartSupplier<net.minheur.potoflux.screen.tabs.Tab> TAB = LIST.add(() -> new Tab(new ResourceLocation(VelocityHelper.MOD_ID, "velocity"), VelocityTab.class));

    public static void register(RegisterTabsEvent event) {
        LIST.register(event.reg);
    }
}
