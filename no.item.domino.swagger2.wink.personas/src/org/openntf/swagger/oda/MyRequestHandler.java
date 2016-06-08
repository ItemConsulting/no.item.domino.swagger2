package org.openntf.swagger.oda;

import javax.ws.rs.core.UriInfo;

import org.apache.wink.server.handlers.HandlersChain;

public class MyRequestHandler implements org.apache.wink.server.handlers.RequestHandler {
    public void init(java.util.Properties props) {
         /* This class is initialized with runtime properties. */
    }

	@Override
	public void handleRequest(
			org.apache.wink.server.handlers.MessageContext context,
			HandlersChain chain) throws Throwable {
		 UriInfo info = context.getUriInfo();
	        System.out.println("The path relative to the base URI is : " + info.getPath());
	        chain.doChain(context);
	}

}