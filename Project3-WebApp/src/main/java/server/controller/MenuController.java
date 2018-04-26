package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import server.ServerMainHandler;

/**
 * Controller for the menu items
 * Gives information about the application
 * Closes the application
 */
public class MenuController {
	public MenuController(JMenuItem about, JMenuItem exit ){
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Emoticon Application. Version 1.0");
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerMainHandler.close();
			}
		});
	}
}
