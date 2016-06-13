package no.item.swagger.wink.plugin;
import javax.ws.rs.ext.RuntimeDelegate;

import no.item.domino.swagger.wink.util.Util;

import org.apache.wink.common.internal.runtime.RuntimeDelegateImpl;
import org.eclipse.core.runtime.Plugin;
import org.openntf.domino.xsp.ODAPlatform;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	public Activator() { 
	}

	@Override
	public void start(BundleContext context) throws Exception {
		// Ensure that the service loader uses the right class
		// See: http://www.mail-archive.com/discuss@restlet.tigris.org/msg07539.html
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
		
		
		ODAPlatform.start();

		
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
		Util.debug("Stopping Plugin...", getClass().getName() ,"stop(BundleContext context)" );
		Activator.context = null;
		
		ODAPlatform.stop();
	}
	
	
	
}
