package org.openntf.swagger.wink.personas.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.openntf.swagger.wink.personas.PersonasDataBase;
import org.openntf.swagger.wink.personas.PersonasFacade;
import org.openntf.swagger.wink.personas.util.JsonJavaUtil;

import com.ibm.commons.util.io.json.JsonJavaObject;


@Path("/person")
@Api(value="Person API")
public class Person { 

	PersonasFacade personasFactory = null;
	JsonJavaUtil jsonJavaUtil = null;
	
	public Person() {
		personasFactory = new PersonasFacade();
		jsonJavaUtil = new JsonJavaUtil();
	} 

	@GET
	@Path("/all")
	@ApiOperation(value = "Get All persons in directory")   
	@Produces({"application/json"})  
	public JsonJavaObject getAll(){	
		return personasFactory.getAll();
	}

	
	@GET
	@ApiOperation(value = "Get a person by UNID")
	@Path("/{unidOrEmail}")
	@Produces({"application/json"})  
	public JsonJavaObject getPersonByUnidOrEmail(
			@ApiParam(value = "Unid Or Email to get a person", required = true)  @PathParam("unidOrEmail")  String unidOrEmail){
		if(unidOrEmail != null){
			if( unidOrEmail.contains("@") )
				return personasFactory.getPersonByEmail(unidOrEmail);
			else
				return personasFactory.getPersonByUNID(unidOrEmail);
		}else
			return new JsonJavaObject();
	}

	

	
	@POST
	@ApiOperation(value = "Create a new person ")   
	@Produces({"application/json"})  
	public JsonJavaObject savePerson(
			@ApiParam(value = "Firstname", required = true)  @FormParam("firstname") @NotNull String firstName, 
			@ApiParam(value = "Lastname", required = true)  @FormParam("lastname") @NotNull String lastName,
			@ApiParam(value = "Emailaddress", required = true)  @FormParam("emailaddress") @NotNull String emailAddress, 
			@ApiParam(value = "Companyname", required = true)  @FormParam("companyname") @NotNull String companyName,
			@ApiParam(value = "Unid of person to update. If new person keep blank", required = false)  @FormParam("unid") @NotNull String unid
			){
		
		return personasFactory.savePerson(firstName, lastName, emailAddress, companyName, unid ,"");
	}


	@DELETE
	@ApiOperation(value = "Delete a person ")   
	@Produces({"application/json"})  
	public void deletePerson(
			@ApiParam(value = "UNID of person to delete", required = true)  @FormParam("unid") String unid){
		boolean deleted = personasFactory.deletePerson(unid);
		if(deleted)
			Response.status(HttpStatus.SC_OK).build();
		else
			Response.status(HttpStatus.SC_BAD_REQUEST).build();
	}


	@GET
	@ApiOperation(value = "Who Am I")
	@Path("/whoami")
	@Produces({"application/json"})   
	public JsonJavaObject getWhoAmI(){
		try {
			PersonasDataBase personasDataBase = new PersonasDataBase();
			
			personasDataBase.openConnection();
					 	
			JsonJavaObject jsonJavaObject = new JsonJavaObject();
			jsonJavaObject.put("userName", personasDataBase.getEffectiveUserName());
			jsonJavaObject.put("dataBase", personasDataBase.getDataBase().getFileName());
			
			personasDataBase.closeConnection();
			
			return jsonJavaObject;
		} catch (Exception e) {
			return new JsonJavaObject();
		}
	}
	
	@GET
	@ApiOperation(value = "Get a person by UNID")
	@Path("/test")
	@Produces({"application/json"})  
	public JsonJavaObject getPersonTestl(
			@ApiParam(value = "Unid Or Email to get a person", required = true)  @PathParam("unidOrEmail")  String unidOrEmail){
		if(unidOrEmail != null){
			if( unidOrEmail.contains("@") )
				return personasFactory.getPersonByEmail(unidOrEmail);
			else
				return personasFactory.getPersonByUNID(unidOrEmail);
		}else
			return new JsonJavaObject();
	}
	 
}
