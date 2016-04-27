package org.openntf.swagger.wink.personas;

import org.openntf.domino.Document;
import org.openntf.domino.DocumentCollection;
import org.openntf.swagger.wink.personas.util.JsonJavaUtil;

import com.ibm.commons.util.io.json.JsonJavaArray;
import com.ibm.commons.util.io.json.JsonJavaObject;

public class PersonasFacade extends PersonasDataBase{

	private JsonJavaUtil jsonJavaUtil = null;
	private PersonMarshaller personMarshaller = null;
	
	public PersonasFacade() {
		jsonJavaUtil = new JsonJavaUtil();
		personMarshaller = new PersonMarshaller();
	}
	
	
	public JsonJavaObject getPersonByUNID (String unid)  { 
		openConnection();
		
		JsonJavaObject returnJSON = new JsonJavaObject();
		
		Document document = null;
		if(unid != null && !"".equals(unid))
			document = getDataBase().getDocumentByUNID(unid);
		
		returnJSON = personMarshaller.unMarshallToJson( document );
			
		closeConnection();

		return returnJSON;
	}
	
	public JsonJavaObject savePerson (String pFirstName, String pLastName, String pEmail, String pCompanyName, String unid, String action) { 
		openConnection();
		
		JsonJavaObject returnJSON = new JsonJavaObject();
		
		try {
			Document document = null;
			if(unid != null && !"".equals(unid))
				document = getDataBase().getDocumentByUNID(unid);
			else
				document = getDataBase().createDocument();
			
			document.replaceItemValue("Form",  "person") ;
			document.replaceItemValue("firstname",  pFirstName) ;
			document.replaceItemValue("lastname",  pLastName) ;
			document.replaceItemValue("emailaddress",  pEmail) ;
			document.replaceItemValue("companyname",  pCompanyName) ;
			
			returnJSON = personMarshaller.unMarshallToJson( document );
				
			document.save(true);
			
			unid = document.getUniversalID();
			
			returnJSON = jsonJavaUtil.getJson("created",true,"Person created", unid);		
		} catch (Exception e1) {
			returnJSON = jsonJavaUtil.getJson("created",false,e1.getMessage());			
			}		

		closeConnection();
		
		return returnJSON;
	}
	

	
	public boolean deletePerson (String unid)  { 
		openConnection();
		
		try {
				Document document = null;
				if(unid != null && !"".equals(unid))
					document =  getDataBase().getDocumentByUNID(unid);
			
				document.remove(true);
			
				return true;
			} catch (Exception e1) {
				return false;
			}finally{
				closeConnection();
			}
	}

	
	public JsonJavaObject getAll()  {
		return getByQuery("Form=\"person\"");
	}

	public JsonJavaObject getPersonByEmail(String email)  {
		return getByQuery(String.format( "Form=\"person\" & emailaddress=\"%s\"",  email)  );
	}

	
	private JsonJavaObject getByQuery(String query)  {
		openConnection();
		
		JsonJavaObject jsonJavaObjectResponse = new JsonJavaObject();
		try{
			DocumentCollection documentCollection = getDataBase().search( query );
			if(documentCollection.getCount() != 0){
				JsonJavaArray jsonJavaArray = new JsonJavaArray(); 	
				for(Document document : documentCollection  ){
					jsonJavaArray.add( personMarshaller.unMarshallToJson( document ) );
				}
			
				
				jsonJavaObjectResponse.put("persons", jsonJavaArray);
			}
			
			documentCollection = null;
		} catch (Exception e1) {
			e1.printStackTrace();
			}	
		
		closeConnection();
		
		return jsonJavaObjectResponse; 
	}


}
