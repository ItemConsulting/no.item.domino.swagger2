package no.item.starter.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import no.item.starter.application.DataBase;

import com.ibm.commons.util.io.json.JsonJavaObject;

@Path("/person")
@Api(value="Person API")
public class WhoAmI { 
	
	public WhoAmI() {
	} 

	@GET
	@ApiOperation(value = "Who Am I")
	@Path("/whoami")
	@Produces({"application/json"})   
	public JsonJavaObject getWhoAmI(){
		try {
			DataBase db = new DataBase();
			
			db.openConnection();
					 	
			JsonJavaObject jsonJavaObject = new JsonJavaObject();
			jsonJavaObject.put("userName", db.getEffectiveUserName());
			
			db.closeConnection();
			
			return jsonJavaObject;
		} catch (Exception e) {
			return new JsonJavaObject();
		}
	}
	
 
}
