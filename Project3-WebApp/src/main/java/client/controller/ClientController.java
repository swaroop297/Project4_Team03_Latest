package client.controller;

import java.awt.event.WindowEvent;

import client.view.ClientUi;

/**
 * Main Controller that invokes the client UI including running & closing
 */
public class ClientController {
	static ClientUi clientUI;
	ExpressiveController expressiveController;
	AffectiveController affectiveController;

	public ClientController() {
		expressiveController = new ExpressiveController();
		affectiveController = new AffectiveController();
		clientUI = new ClientUi(expressiveController, affectiveController);
		clientUI.setVisible(true);
	}

	public static void close() {
		clientUI.dispatchEvent(new WindowEvent(clientUI, WindowEvent.WINDOW_CLOSING));
	}
}
