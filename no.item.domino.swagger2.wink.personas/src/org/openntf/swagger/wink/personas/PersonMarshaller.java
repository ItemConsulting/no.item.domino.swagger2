package org.openntf.swagger.wink.personas;

import org.openntf.domino.Document;

import com.ibm.commons.util.io.json.JsonJavaObject;

public class PersonMarshaller {

	public JsonJavaObject unMarshallToJson(Document document) {
		JsonJavaObject personJson = new JsonJavaObject();
		
		personJson.put("firstName", document.getItemValueString("firstname") );
		personJson.put("lastName", document.getItemValueString("lastname") );
		personJson.put("emailAddress", document.getItemValueString("emailaddress") );
		personJson.put("companyName", document.getItemValueString("companyname") );
		personJson.put("unid", document.getUniversalID() );
		
		return personJson;
	}
	
}
