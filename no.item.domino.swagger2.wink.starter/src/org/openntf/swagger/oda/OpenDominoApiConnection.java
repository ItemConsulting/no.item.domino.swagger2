package org.openntf.swagger.oda;

import org.openntf.domino.AutoMime;
import org.openntf.domino.ext.Session.Fixes;
import org.openntf.domino.utils.Factory;
import org.openntf.domino.utils.Factory.SessionType;
import org.openntf.domino.utils.Factory.ThreadConfig;
import org.openntf.domino.xsp.session.DasCurrentSessionFactory;

public class OpenDominoApiConnection {
	
	public boolean isConnectionOpen = false;
	
	public void openConnection(){
		 Factory.initThread(getDataServiceConfig());
		 Factory.setSessionFactory(new DasCurrentSessionFactory(), SessionType.CURRENT); 
		 
		 isConnectionOpen = true;
	}
	
	public void closeConnection(){
		if(isConnectionOpen)
		  Factory.termThread();
	}
	
	protected ThreadConfig getDataServiceConfig() {
	    final Fixes[] fixes = Fixes.values();
	    final AutoMime autoMime = AutoMime.WRAP_32K;
	    final boolean bubbleExceptions = false;

	    return new ThreadConfig(fixes, autoMime, bubbleExceptions);
	 }
		 
	  
}
