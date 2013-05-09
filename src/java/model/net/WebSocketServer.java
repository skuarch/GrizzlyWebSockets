package model.net;

import java.util.ArrayList;
import org.glassfish.grizzly.http.HttpRequestPacket;
import org.glassfish.grizzly.websockets.DataFrame;
import org.glassfish.grizzly.websockets.WebSocket;
import org.glassfish.grizzly.websockets.WebSocketApplication;

/**
 *
 * @author skuarch
 */
public class WebSocketServer extends WebSocketApplication {

    private ArrayList<WebSocket> webSockets = null;

    //==========================================================================
    public WebSocketServer() {
        webSockets = new ArrayList<WebSocket>();
    } // end WebSocketServer   

    //==========================================================================
    @Override
    public boolean isApplicationRequest(HttpRequestPacket hrp) {
        return true;
    } // end isApplicationRequest    

    //==========================================================================
    @Override
    public void onConnect(WebSocket socket) {
        webSockets.add(socket);
    } // end onConnect

    //==========================================================================
    @Override
    public void onClose(WebSocket socket, DataFrame frame) {
        webSockets.remove(socket);
    } // end onClose

    //==========================================================================
    @Override
    public void onMessage(WebSocket socket, String text) {
        for (WebSocket webSocket : webSockets) {
            webSocket.send(text);
        }
    } // end onMessage

    //==========================================================================
    public ArrayList<WebSocket> getSockets() {
        return this.webSockets;
    } // end getSockets    
    
} // end class