package org.openntf.swagger.wink.personas;

import org.openntf.domino.Database;
import org.openntf.domino.Session;
import org.openntf.domino.utils.Factory;
import org.openntf.domino.utils.Factory.SessionType;
import org.openntf.swagger.oda.OpenDominoApiConnection;


public  class PersonasDataBase extends OpenDominoApiConnection{
	
	public Database getDataBase(){
		if( !isConnectionOpen )
			openConnection();
		
		Session session = Factory.getSession(SessionType.CURRENT);
		
		return  session.getDatabase("personas/personas.nsf");
	}
	
	public String getEffectiveUserName(){
		if( !isConnectionOpen )
			openConnection();
		
		Session session = Factory.getSession(SessionType.CURRENT);

		return session.getEffectiveUserName();
	}
	
	

	

}
