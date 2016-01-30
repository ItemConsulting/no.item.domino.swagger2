package no.item.domino.swagger.wink;

import io.swagger.jaxrs.config.BeanConfig;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
 
public class SwaggerApplication extends Application{

	private Set<Class<?>> resources = new HashSet<Class<?>>();
	private BeanConfig swaggerBeanConfiguration = null;
	
	public SwaggerApplication(BeanConfig swaggerBeanConfiguration) {
		this.swaggerBeanConfiguration  = swaggerBeanConfiguration;
	}
	
	@Override
	public Set<Object> getSingletons() {
		Set<Object> s = new HashSet<Object>();

		JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
		jaxbProvider.setMapper( getJacksonAndJaxbMapper() );     
		s.add( jaxbProvider );
		
		return s;
	}

	protected void addSwagger20Resources() {
		addResource(io.swagger.jaxrs.listing.ApiListingResource.class);
		addResource(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	}
	
	protected ObjectMapper getJaxbAndJacksonMapper()
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setAnnotationIntrospector(
				new AnnotationIntrospectorPair(
						new JaxbAnnotationIntrospector(mapper.getTypeFactory()), 
						new JacksonAnnotationIntrospector()));
		
		return mapper;
	}
	/**
	 * @return ObjectMapper med jackson som primær og jaxb som sekundær
	 */
	protected ObjectMapper getJacksonAndJaxbMapper()
	{
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector intr = new AnnotationIntrospectorPair(
				new JacksonAnnotationIntrospector(),
				new JaxbAnnotationIntrospector(mapper.getTypeFactory()) );
		mapper.setAnnotationIntrospector(intr);
		return mapper;
	}

	public void addResource(Class resource) {
		resources.add(resource);
	}
	
	public Set<Class<?>> getResources() {
		addSwagger20Resources();
		
		return resources;
	}

	public Set<Class<?>> getClasses() {
		return null;
	}
	
}
