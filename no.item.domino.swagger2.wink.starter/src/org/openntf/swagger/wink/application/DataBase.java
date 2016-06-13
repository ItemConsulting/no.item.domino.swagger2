package org.openntf.swagger.wink.application;

import org.openntf.domino.Database;
import org.openntf.domino.Session;
import org.openntf.domino.utils.Factory;
import org.openntf.domino.utils.Factory.SessionType;
import org.openntf.swagger.oda.OpenDominoApiConnection;


public  class DataBase extends OpenDominoApiConnection{
	
	public Database getDataBase(String dataBaseName){
		if( !isConnectionOpen )
			openConnection();
		
		Session session = Factory.getSession(SessionType.CURRENT);
		
		return  session.getDatabase( dataBaseName );
	}
	
	public String getEffectiveUserName(){
		if( !isConnectionOpen )
			openConnection();
		
		Session session = Factory.getSession(SessionType.CURRENT);

		return session.getEffectiveUserName();
	}
	
	

	

}
