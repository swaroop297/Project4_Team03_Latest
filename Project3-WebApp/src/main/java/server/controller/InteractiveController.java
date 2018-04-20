package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import server.service.FaceServer;
import server.view.DetectionPanel;

/**
 * Controller for the interactive section of the server.
 * 
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class InteractiveController {

	JButton btnSend;
	JSpinner emoStateInterval;
	JCheckBox chckbxAuroReset;
	
	public InteractiveController(final JButton btnSend, final JSpinner emoStateInterval, final JCheckBox chckbxAutoReset,
			final DetectionPanel dpanel) {

		this.btnSend = btnSend;
		this.emoStateInterval = emoStateInterval;
		this.chckbxAuroReset = chckbxAutoReset;
		
		//Sends the selected values to the client.
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (e.getActionCommand().equals("Send")){
					if (chckbxAutoReset.isSelected()){
						btnSend.setText("Stop");
						emoStateInterval.setEnabled(false);
						chckbxAutoReset.setEnabled(false);
						Double interval = (Double)emoStateInterval.getValue();
						new ThreadController(interval,dpanel);
						ThreadController.start();
					}
					else {
						FaceServer.put(dpanel.getDetectionController().createFaceDataInstance());
					}
				}else {
					ThreadController.stop();
					emoStateInterval.setEnabled(true);
					chckbxAuroReset.setEnabled(true);
					btnSend.setText("Send");
				}

			}
		});
	}
}
