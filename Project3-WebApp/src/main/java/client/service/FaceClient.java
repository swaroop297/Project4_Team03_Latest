package client.service;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import client.view.ClientUi;
import utility.FaceData;

/**
 * Class to establish web-socket connection with server and retrieve the data from the server
 * 
 * @SER516 Project3_Team03
 * @version 1.0
 */
@ClientEndpoint
public class FaceClient {

	private static Gson gson = null;
	private static ClientUi observer = null;
	private static boolean isConnected = false;

	/**
	 * Establishes connection to the server
	 * @param host Accepts the host-name to connect to
	 * @param port Accepts the port number
	 * @throws Exception Handles exceptions
	 */
	public static void connect(String host, String port) throws Exception {
		ClientManager client = ClientManager.createClient();
		client.connectToServer(FaceClient.class, new URI("ws://" + host + ":" + port + "/faceData"));
	}
	
	/**
	 * Creates a gson object
	 * @param observer Contains the observer object of the clientUI
	 */
	public static void create(ClientUi observer) {
		FaceClient.gson = new GsonBuilder().create();
		FaceClient.observer = observer;
	}
	
	/**
	 * Displays that the connection has been established
	 * @param session Contains the latest session value
	 * @throws Exception Handles exception
	 */
	@OnOpen
	public void onOpen(Session session) throws Exception {
		System.out.println("Connected ... " + session.getId());
		isConnected = true;
	}
	
	/**
	 * Handles the received values from the server.
	 * @param message contains the json object sent by the server
	 * @param session contains the latest session value
	 * @throws Exception handles exceptions
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		FaceData faceData = gson.fromJson(message, FaceData.class);
		observer.setFaceData(faceData);
	}
	
	/**
	 * Displays that the session has been closed
	 * @param session contains the latest session value
	 * @param closeReason contains how the session was closed
	 */
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println(String.format("Session %s close because of %s", session.getId(), closeReason));
		isConnected = false;
	}
	
	/**
	 * checks if the connection is running or not
	 * @return returns if connected or not
	 */
	public static boolean isConnected() {
		return isConnected;
	}
}