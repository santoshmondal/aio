package com.rediff.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoWebsocket {
	private final String nickname = "GUEST";
	private Session session;

	@OnMessage
	public void echoTextMessage(Session session, String msg, boolean last) {
		try {
			if (session.isOpen()) {
				session.getBasicRemote().sendText(msg, last);
			}
		} catch (IOException e) {
			try {
				session.close();
			} catch (IOException e1) {
				// Ignore
			}
		}
	}

	@OnOpen
	public void start(Session session) {
		this.session = session;
		String message = String.format("* %s %s", nickname, "has joined.");
		System.out.println("OPEN :: " +  message);
	}

	@OnClose
	public void end() {
		String message = String.format("* %s %s", nickname, "has disconnected.");
		System.out.println("END :: " + message);
	}

	@OnError
    public void onError(Throwable t) throws Throwable {
        System.out.println("Chat Error: " + t.toString());
    }
	

}
