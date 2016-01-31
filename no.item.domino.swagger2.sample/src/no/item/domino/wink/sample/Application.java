package no.item.domino.wink.sample;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.sample.resource.PetResource;
import io.swagger.sample.resource.PetStoreResource;
import io.swagger.sample.resource.UserResource;

import java.util.Set;

import no.item.domino.swagger.wink.SwaggerApplication;

public class Application extends SwaggerApplication {
	
	public Application() {
		super( getSwaggerBeanConfiguration() );
	}
 
	@Override
	public Set<Class<?>> getClasses() {

		addResource(PetResource.class);
		addResource(PetStoreResource.class);
		addResource(UserResource.class);
		
		return getResources();
	}
	
	
	
	private static BeanConfig getSwaggerBeanConfiguration(){ 
		
		BeanConfig cnfg = new BeanConfig();
	
		cnfg.setVersion("");
		cnfg.setSchemes(new String[]{"http","https"});
		cnfg.setHost(""); 
		cnfg.setBasePath("/sample/api/v2"); 
		cnfg.setResourcePackage("io.swagger.sample.resource"); 
		cnfg.setContact(""); 
		cnfg.setTitle(""); 
		cnfg.setDescription(""); 
		cnfg.setScan(true); 
		cnfg.setPrettyPrint(true); 
		return cnfg;
	}
 

} 

