package org.openntf.swagger.wink.test.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/hello")
@Api(value="Hello")
public class HelloYou {

	@POST
	@ApiOperation(value = "Say hello")   
	@Produces({"text/html"})  
	public String helloNorway(@FormParam("name") String name ){
		return "Hello ss " + name;
	}
	
}
