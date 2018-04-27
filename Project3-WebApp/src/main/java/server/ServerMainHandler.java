package server;

import java.awt.event.WindowEvent;
import server.service.FaceServer;
import server.view.EmoticonComposer;

/**
 * Main class that is invoked when the server has to be started.
 */
public class ServerMainHandler {
	static EmoticonComposer emoticon;
	
	/**
	 * Runs the Sever UI.
	 */
	public ServerMainHandler() {
		FaceServer.start(8000);
		emoticon = new EmoticonComposer();
		emoticon.setVisible(true);
		emoticon.setResizable(false);
		ServerConsole sc = ServerConsole.getInstance();
		sc.print("Server Started");
	}
	
	/**
	 * Closes the serverUI.
	 */
	public static void close(){
		emoticon.dispatchEvent(new WindowEvent(emoticon, WindowEvent.WINDOW_CLOSING));
	}
}
