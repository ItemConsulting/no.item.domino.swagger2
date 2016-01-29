package org.openntf.swagger.wink.test;

import io.swagger.jaxrs.config.BeanConfig;

import java.util.Set;

import no.item.domino.swagger.wink.SwaggerApplication;

import org.openntf.swagger.wink.test.resources.HelloNorway;
import org.openntf.swagger.wink.test.resources.HelloWorld;
import org.openntf.swagger.wink.test.resources.HelloYou;

public class Application extends SwaggerApplication {
	
	public Application() {
		super( getSwaggerBeanConfiguration() );
	}
 
	@Override
	public Set<Class<?>> getClasses() {

		addResource(HelloWorld.class);
		addResource(HelloNorway.class);
		addResource(HelloYou.class);
		
		return getResources();
	}
	
	
	
	private static BeanConfig getSwaggerBeanConfiguration(){ 
		BeanConfig cnfg = new BeanConfig();
		cnfg.setVersion("");
		cnfg.setSchemes(new String[]{"http","https"});
		cnfg.setHost(""); 
		cnfg.setBasePath("/swaggerTest/api/v1"); 
		cnfg.setResourcePackage("org.openntf.swagger.wink.test.resources"); 
		cnfg.setContact(""); 
		cnfg.setTitle(""); 
		cnfg.setDescription(""); 
		cnfg.setScan(true); 
		cnfg.setPrettyPrint(true); 
		return cnfg;
	}
 

} 