package server.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import server.controller.InteractiveController;

/**
 * View for the Interactive Panel
 * @SER516 Project3_Team03
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class InteractivePanel extends JPanel {

	JSpinner spinnerEmoStateInterval;
	JCheckBox chckbxAutoReset;
	JButton btnSend;
	DetectionPanel dpanel;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InteractivePanel(DetectionPanel dpanel) {

		this.dpanel = dpanel;
		this.setLayout(null);
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(12, 26, 56, 16);
		this.add(lblPlayer);

		JComboBox comboBoxPlayer = new JComboBox();
		comboBoxPlayer.setBounds(60, 23, 96, 22);
		comboBoxPlayer.setModel(new DefaultComboBoxModel(new String[] { "0", "1" }));
		this.add(comboBoxPlayer);

		JLabel lblEmo = new JLabel("EmoStateInterval");
		lblEmo.setBounds(219, 20, 118, 28);
		this.add(lblEmo);

		spinnerEmoStateInterval = new JSpinner();
		spinnerEmoStateInterval
				.setModel(new SpinnerNumberModel(new Double(0.25), new Double(0.25), null, new Double(0.25)));
		spinnerEmoStateInterval.setBounds(349, 23, 75, 22);
		this.add(spinnerEmoStateInterval);

		JLabel lblSec = new JLabel("Sec");
		lblSec.setBounds(436, 26, 35, 16);
		this.add(lblSec);

		chckbxAutoReset = new JCheckBox("Auto Resend");
		chckbxAutoReset.setBounds(219, 58, 113, 25);
		this.add(chckbxAutoReset);

		btnSend = new JButton("Send");
		btnSend.setBounds(337, 58, 119, 25);
		this.add(btnSend);

		new InteractiveController(btnSend, spinnerEmoStateInterval, chckbxAutoReset, dpanel);
	}
}
