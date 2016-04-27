package org.openntf.swagger.wink.personas.util;

import com.ibm.commons.util.io.json.JsonJavaObject;

public class JsonJavaUtil {
	
	public JsonJavaObject getJson(String action, boolean status,String message) {
		JsonJavaObject returnJSON = new JsonJavaObject();
		returnJSON.put("action", action );		
		returnJSON.put("status", Boolean.toString(status) );		
		returnJSON.put("message", message );
		
		return returnJSON;
	}
	
	public JsonJavaObject getJson(String action, boolean status,String message,String unid) {
		JsonJavaObject returnJSON = new JsonJavaObject();
		returnJSON.put("action", action );		
		returnJSON.put("status", Boolean.toString(status) );		
		returnJSON.put("message", message );
		returnJSON.put("unid", unid );
		
		return returnJSON;
	}

}
