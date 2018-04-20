package client;

import java.awt.EventQueue;

import client.controller.ClientController;

/**
 * Main class that is invoked when the project is run.
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class ClientMain {	

	/**
	 * Launch the client controller.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ClientController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
