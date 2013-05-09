package servlets.websockets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import model.net.WebSocketServer;
import org.glassfish.grizzly.websockets.WebSocketEngine;

/**
 *
 * @author skuarch
 */
public class webSocket extends HttpServlet {

    private WebSocketServer webSocketServer = new WebSocketServer();

    //==========================================================================
    @Override
    public void init(ServletConfig config) throws ServletException {
        WebSocketEngine.getEngine().register(webSocketServer);
    } // end init    

    //==========================================================================
    @Override
    public void init() throws ServletException {
        WebSocketEngine.getEngine().register(webSocketServer);
    } // end init
    
    //==========================================================================
    @Override
    public void destroy() {
        WebSocketEngine.getEngine().unregister(webSocketServer);
    }
    
} // end class
