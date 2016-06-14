package no.item.starter.application;

import io.swagger.jaxrs.config.BeanConfig;

import java.util.Set;

import no.item.domino.swagger.wink.SwaggerApplication;
import no.item.starter.resources.WhoAmI;

public class Application extends SwaggerApplication {
	
	public Application() {
		super( getSwaggerBeanConfiguration() );
	}
 
	@Override
	public Set<Class<?>> getClasses() {

		addResource(WhoAmI.class);
		
		return getResources();
	}
	
	
	
	private static BeanConfig getSwaggerBeanConfiguration(){ 
		BeanConfig cnfg = new BeanConfig();
		cnfg.setVersion("");
		cnfg.setSchemes(new String[]{"http","https"});
		cnfg.setHost(""); 
		cnfg.setBasePath("/starter/api/v1"); 
		cnfg.setResourcePackage("no.item.starter.resources"); 
		cnfg.setContact(""); 
		cnfg.setTitle(""); 
		cnfg.setDescription(""); 
		cnfg.setScan(true); 
		cnfg.setPrettyPrint(true); 
		
		return cnfg;
	}
 

} 