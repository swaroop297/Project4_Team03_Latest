package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.service.FaceClient;
import server.ServerMainHandler;

/**
 * Controller for the menu items
 * 
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class MenuItemController {

	public MenuItemController(JMenuItem serverConnect, JMenuItem serverConsole, JMenuItem exit) {
		
		//Connects to the server.
		serverConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField host = new JTextField();
				host.setText("localhost");
				JTextField port = new JTextField();
				port.setText("8000");

				Object[] fields = { "Host Name", host, "Port", port };
				int input = JOptionPane.showConfirmDialog(null, fields, "Connect To Server",
						JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					try {
						FaceClient.connect(host.getText(), port.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, FaceClient.isConnected() ? "Connected to " + host.getText()
							: "Not connected to " + host.getText());
				}
			}
		});
		
		//Closes the application.
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientController.close();
			}
		});
		
		//Starts the server.
		serverConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ServerMainHandler();
			}
		});
	}

}
