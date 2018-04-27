package client;

import java.awt.EventQueue;
import javax.swing.UIManager;
import client.controller.ClientController;

/**
 * Main class that is invoked when the project is run.
 */
public class ClientMain {	

	/**
	 * Launch the client controller.
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	            			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	          		} catch (Exception e) {
	            			System.err.println("Look and feel not set!");
	         		 }
				try {
					new ClientController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
