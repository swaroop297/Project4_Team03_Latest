package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import server.ServerMainHandler;

/**
 * Controller for the menu items
 * 
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class MenuController {

	public MenuController(JMenuItem about, JMenuItem exit ){
		
		//Gives information about the application
		about.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Emoticon Application. Version 1.0");
			}
		});
		
		//CLoses the application
		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ServerMainHandler.close();
			}
		});
	}
	
}
