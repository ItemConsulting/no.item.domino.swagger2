package no.item.swagger.wink.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.openntf.swagger.wink.application.DataBase;
import org.openntf.swagger.wink.util.JsonJavaUtil;

import com.ibm.commons.util.io.json.JsonJavaObject;


@Path("/person")
@Api(value="Person API")
public class WhoAmI { 

	JsonJavaUtil jsonJavaUtil = null;
	
	public WhoAmI() {
		jsonJavaUtil = new JsonJavaUtil();
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
