package no.item.domino.wink.sample.plugin;
import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.wink.common.internal.runtime.RuntimeDelegateImpl;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import no.item.domino.swagger.wink.util.Util;

public class Activator extends Plugin {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	public Activator() { 
	}

	@Override
	public void start(BundleContext context) throws Exception {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		ClassLoader newcl = RuntimeDelegate.class.getClassLoader();
		
		Thread.currentThread().setContextClassLoader(newcl);
		try {
			RuntimeDelegate.setInstance(new RuntimeDelegateImpl());
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			Thread.currentThread().setContextClassLoader(oldcl);
		}
		
		super.start(context);
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Util.debug("Stopping Swagger Sample Plugin...", getClass().getName() ,"stop(BundleContext context)" );
		Activator.context = null;
	}
	
}
