package org.openntf.swagger.wink.test.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/hellonorway")
@Api(value="Hello Norway")
public class HelloNorway { 

	@GET
	@ApiOperation(value = "Greetings fro Hello Norway")   
	@Produces({"text/html"})  
	public String helloNorway(){
		return "Hello sadsda Norway";
	}
	
}
