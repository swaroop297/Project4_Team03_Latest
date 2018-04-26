package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenu;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import server.ServerMainHandler;

/**
 * Controller for the menu items
 * Gives information about the application
 * Closes the application
 */
public class MenuController {

	public MenuController(JMenuItem about, JMenuItem exit, JButton uploadBtn){
		
		//Gives information about the application
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
		
		uploadBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("upload csv button - click");
				try {
					ProcessJsonFile processJsonFile = new ProcessJsonFile();
					processJsonFile.fileUploadinit();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
}
