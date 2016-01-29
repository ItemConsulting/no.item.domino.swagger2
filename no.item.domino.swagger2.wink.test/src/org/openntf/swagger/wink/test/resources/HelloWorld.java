package org.openntf.swagger.wink.test.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/helloworld")
@Api(value="Hello World")
public class HelloWorld {

	@GET
	@ApiOperation(value = "Greetings from Hello World")   
	@Produces({"text/html"})  
	public String helloWorld(){
		return "Hello World";
	}
	
}
