package org.openntf.swagger.oda;

import java.util.Arrays;
import java.util.List;

public class ODAHandlerFactory extends org.apache.wink.server.handlers.HandlersFactory {
    public ODAHandlerFactory() {
        /* This constructor must exist because it is the only one called.*/
    }

    public List<? extends org.apache.wink.server.handlers.RequestHandler> getRequestHandlers() {
        return Arrays.asList( new MyRequestHandler() );
    }
}