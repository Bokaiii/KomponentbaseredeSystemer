package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {

        AsteroidPlugin ap = new AsteroidPlugin();
        context.registerService(IGamePluginService.class, ap, null);
        
        AsteroidProcessor processor = new AsteroidProcessor();
        context.registerService(IEntityProcessingService.class, processor, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }
}
