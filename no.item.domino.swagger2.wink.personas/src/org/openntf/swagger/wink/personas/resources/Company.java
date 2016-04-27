package org.openntf.swagger.wink.personas.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/company")
@Api(value="Company API")
public class Company { 

	@GET
	@ApiOperation(value = "Get a company by ID")   
	@Produces({"text/html"})  
	public String getCompany(@PathParam("company") String company ){
		return "Get company: " + company;
	}
	
	
	@POST
	@ApiOperation(value = "Create a new company")   
	@Produces({"text/html"})  
	public String createCompany(@PathParam("company") String company ){
		return "Create company by name: " + company;
	}
	 
}
