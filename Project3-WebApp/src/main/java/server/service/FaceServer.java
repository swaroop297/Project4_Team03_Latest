package server.service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.glassfish.tyrus.server.Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import server.ServerConsole;
import utility.FaceData;

/**
 * Class to establish web-socket connection with client and send the data to the client.
 * 
 * @SER516 Project3_Team03
 * @version 1.0
 */
@ServerEndpoint(value = "/faceData")
public class FaceServer {

	private static Gson gson = null;
	private static Session session = null;
	private static Server server = null;
	static ServerConsole sc = ServerConsole.getInstance();
	
	/**
	 * Establishes a connection with the client.
	 * @param port contains the port number for the connection.
	 */
	public static void start(int port) {
		if (FaceServer.gson == null) {
			FaceServer.gson = new GsonBuilder().create();
		}
		FaceServer.server = new Server("localhost", port, "/", null, FaceServer.class);
		try {
			System.out.println("Server Started");
			FaceServer.server.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Stops the connection.
	 */
	public static void stop() {
		try {
			FaceServer.server.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends the data to the client.
	 * @param faceData contains the data values
	 */
	public static void put(FaceData faceData) {
		if (FaceServer.session == null) {
			sc.print("No session present.");
			return;
		}
		try {
			String message = FaceServer.gson.toJson(faceData, FaceData.class);
			FaceServer.session.getBasicRemote().sendText(message);
			sc.print(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks if a session is already in play
	 * @param session Contains the session value.
	 */
	@OnOpen
	public void onOpen(Session session) {
		if (FaceServer.session != null) {
			sc.print(session.getId() + " has opened a connection, but a connection is already open.");
			try {
				session.getBasicRemote().sendText("Only one client is allowed at a time");
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		FaceServer.session = session;
		sc.print(session.getId() + " has opened a connection");
	}
	
	/**
	 * Executes when a message is sent
	 * @param message Contains the message that is sent
	 * @param session Contains the session value
	 * @throws Exception handles exceptions
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		sc.print(message);
	}
	
	/**
	 * Executes when the connection is closed.
	 * @param session Contains the session value.
	 */
	@OnClose
	public void onClose(Session session) {
		System.out.println("Session " + session.getId() + " has ended");
		if (session == FaceServer.session) {
			FaceServer.session = null;
		}
	}
}