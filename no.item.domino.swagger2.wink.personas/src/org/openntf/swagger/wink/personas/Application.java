package org.openntf.swagger.wink.personas;

import io.swagger.jaxrs.config.BeanConfig;

import java.util.Set;

import no.item.domino.swagger.wink.SwaggerApplication;

import org.openntf.swagger.wink.personas.resources.Company;
import org.openntf.swagger.wink.personas.resources.Person;

public class Application extends SwaggerApplication {
	
	public Application() {
		super( getSwaggerBeanConfiguration() );
	}
 
	@Override
	public Set<Class<?>> getClasses() {

		addResource(Company.class);
		addResource(Person.class);
		
		return getResources();
	}
	
	
	
	private static BeanConfig getSwaggerBeanConfiguration(){ 
		BeanConfig cnfg = new BeanConfig();
		cnfg.setVersion("");
		cnfg.setSchemes(new String[]{"http","https"});
		cnfg.setHost(""); 
		cnfg.setBasePath("/personas/api/v1"); 
		cnfg.setResourcePackage("org.openntf.swagger.wink.personas.resources"); 
		cnfg.setContact(""); 
		cnfg.setTitle(""); 
		cnfg.setDescription(""); 
		cnfg.setScan(true); 
		cnfg.setPrettyPrint(true); 
		
		return cnfg;
	}
 

} 