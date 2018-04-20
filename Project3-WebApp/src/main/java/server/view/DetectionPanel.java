package server.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpringLayout;

import server.ServerConsole;
import server.controller.DetectionController;
import utility.FaceAffectiveData;
import utility.FaceExpressionData;

/**
 * View for the Detection Panel.
 * @SER516 Project3_Team03
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class DetectionPanel extends JPanel {

	public JTextField timeElapsedTextbox;
	public JSpinner spinnerEmoStateInterval, spinnerUpperFace, spinnerLowerFace, spinnerAffective;
	public JCheckBox chckbxEyeAutoReset;
	public JTextArea txtAreaEmoLogs;
	public JScrollPane scroll;
	public JButton btnSend, btnClearLogs;
	@SuppressWarnings("rawtypes")
	public JComboBox comboUpperFace, comboLowerFace, comboEye, comboAffective;
	public JRadioButton rdbtnActive;
	public FaceExpressionData faceExpressionData;
	public FaceAffectiveData faceAffectiveData;
	public JLabel lblEmoState,lblTime,lblSeconds,lblUpperFace,lblEye,lblLowerface,lblAffective,lblEmoengineLogs;
	public SpringLayout springpanel;
	public ServerConsole sc;
	public DetectionController detectionController;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DetectionPanel() {
		
		springpanel = new SpringLayout();
		this.setLayout(springpanel);

		faceAffectiveData = new FaceAffectiveData();
		faceExpressionData = new FaceExpressionData();
		lblEmoState = new JLabel("EMO STATE");
		lblTime = new JLabel("TIME: ");
		lblSeconds = new JLabel("Seconds");
		lblUpperFace = new JLabel("Upperface:");
		lblLowerface = new JLabel("Lowerface:");
		comboLowerFace = new JComboBox();
		rdbtnActive = new JRadioButton("Active");
		chckbxEyeAutoReset = new JCheckBox("Auto Reset");
		lblEmoengineLogs = new JLabel("EmoEngine Logs");
		btnClearLogs = new JButton("Clear Logs");
		lblAffective = new JLabel("Affective:");
		lblEye = new JLabel("Eye:");
		
		
		timeElapsedTextbox = new JTextField();
		timeElapsedTextbox.setEditable(false);
		timeElapsedTextbox.setText("0.0");
		timeElapsedTextbox.setColumns(10);
		
		comboUpperFace = new JComboBox();
		comboUpperFace.setModel(new DefaultComboBoxModel(new String[] { "Raise Brow", "Furrow Brow" }));
		
		spinnerUpperFace = new JSpinner();
		spinnerUpperFace.setModel(new SpinnerListModel(
				new String[] { "0", "0.10", "0.20", "0.30", "0.40", "0.50", "0.60", "0.70", "0.80", "0.90", "1" }));
		
		comboLowerFace.setModel(
				new DefaultComboBoxModel(new String[] { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" }));
		
		spinnerLowerFace = new JSpinner();
		spinnerLowerFace.setModel(new SpinnerListModel(
				new String[] { "0", "0.10", "0.20", "0.30", "0.40", "0.50", "0.60", "0.70", "0.80", "0.90", "1" }));
		
		comboEye = new JComboBox();
		comboEye.setModel(new DefaultComboBoxModel(
				new String[] { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" }));
		
		txtAreaEmoLogs = new JTextArea();
		txtAreaEmoLogs.setEditable(true);
		txtAreaEmoLogs.setRows(5);
		
		comboAffective = new JComboBox();
		comboAffective.setModel(new DefaultComboBoxModel(new String[] { "Meditation", "Engagement Boredom",
				"Excitement ShortTerm", "Frustration", "Excitement LongTerm" }));
		
		spinnerAffective = new JSpinner();
		spinnerAffective.setModel(new SpinnerListModel(
				new String[] { "0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" }));
		
		sc = ServerConsole.getInstance();
		sc.setJtextArea(txtAreaEmoLogs);
				
		scroll = new JScrollPane(txtAreaEmoLogs);
		sc.setJScrollPane(scroll);
		
		setComponentLayout();
		addComponent();
		
		
		this.detectionController = new DetectionController(spinnerUpperFace, spinnerLowerFace, spinnerAffective,
				comboUpperFace, comboLowerFace, comboAffective, comboEye, chckbxEyeAutoReset, rdbtnActive,txtAreaEmoLogs,btnClearLogs,
				faceAffectiveData, faceExpressionData);
	}
	
	public void setComponentLayout(){
		springpanel.putConstraint(SpringLayout.NORTH, comboLowerFace, 144, SpringLayout.NORTH, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, lblEmoState, 13, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, lblEmoState, 12, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblEmoState, 88, SpringLayout.WEST, this);

		springpanel.putConstraint(SpringLayout.NORTH, lblTime, 47, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, lblTime, 22, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblTime, 70, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, timeElapsedTextbox, 44, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, timeElapsedTextbox, 74, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, lblSeconds, 47, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, lblSeconds, 202, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblSeconds, 258, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.WEST, lblUpperFace, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, lblUpperFace, 88, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.SOUTH, lblUpperFace, -6, SpringLayout.NORTH, comboUpperFace);
		springpanel.putConstraint(SpringLayout.NORTH, comboUpperFace, 144, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, comboUpperFace, 12, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, comboUpperFace, 111, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, spinnerUpperFace, 144, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, spinnerUpperFace, 125, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, spinnerUpperFace, 190, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, lblLowerface, 0, SpringLayout.NORTH, lblUpperFace);
		springpanel.putConstraint(SpringLayout.WEST, lblLowerface, 276, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblLowerface, -126, SpringLayout.EAST, this);
	
		springpanel.putConstraint(SpringLayout.EAST, comboLowerFace, -10, SpringLayout.WEST, spinnerLowerFace);
		springpanel.putConstraint(SpringLayout.NORTH, spinnerLowerFace, 144, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, spinnerLowerFace, 402, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, spinnerLowerFace, 458, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.WEST, lblEye, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, lblEye, -2, SpringLayout.EAST, lblTime);
		
		springpanel.putConstraint(SpringLayout.SOUTH, lblEye, -6, SpringLayout.NORTH, comboEye);
		springpanel.putConstraint(SpringLayout.NORTH, comboEye, 238, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, comboEye, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, comboEye, 0, SpringLayout.EAST, comboUpperFace);
		
		springpanel.putConstraint(SpringLayout.NORTH, rdbtnActive, -1, SpringLayout.NORTH, comboEye);
		springpanel.putConstraint(SpringLayout.WEST, rdbtnActive, 120, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, rdbtnActive, 0, SpringLayout.EAST, timeElapsedTextbox);
		
		springpanel.putConstraint(SpringLayout.NORTH, chckbxEyeAutoReset, 6, SpringLayout.SOUTH, comboEye);
		springpanel.putConstraint(SpringLayout.WEST, chckbxEyeAutoReset, 0, SpringLayout.WEST, lblEmoState);
		springpanel.putConstraint(SpringLayout.EAST, chckbxEyeAutoReset, -359, SpringLayout.EAST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, lblEmoengineLogs, 316, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, lblEmoengineLogs, 25, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, lblEmoengineLogs, 124, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, scroll, 345, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, scroll, 22, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.SOUTH, scroll, 474, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.EAST, scroll, 458, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, btnClearLogs, 487, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, btnClearLogs, 185, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, btnClearLogs, 282, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, lblAffective, 0, SpringLayout.NORTH, lblEye);
		springpanel.putConstraint(SpringLayout.WEST, lblAffective, 0, SpringLayout.WEST, lblLowerface);
		
		springpanel.putConstraint(SpringLayout.WEST, comboLowerFace, 0, SpringLayout.WEST, comboAffective);
		springpanel.putConstraint(SpringLayout.WEST, comboAffective, 47, SpringLayout.EAST, rdbtnActive);
		springpanel.putConstraint(SpringLayout.NORTH, comboAffective, 238, SpringLayout.NORTH, this);
		
		springpanel.putConstraint(SpringLayout.EAST, comboAffective, -10, SpringLayout.WEST, spinnerAffective);
		springpanel.putConstraint(SpringLayout.NORTH, spinnerAffective, 0, SpringLayout.NORTH, rdbtnActive);
		springpanel.putConstraint(SpringLayout.WEST, spinnerAffective, 0, SpringLayout.WEST, spinnerLowerFace);
		springpanel.putConstraint(SpringLayout.EAST, spinnerAffective, 0, SpringLayout.EAST, spinnerLowerFace);
		
	}

	public void addComponent() {
		
		add(lblEmoState);
		add(spinnerAffective);
		add(comboAffective);
		add(lblAffective);
		add(btnClearLogs);
		add(scroll);
		add(lblEmoengineLogs);
		add(chckbxEyeAutoReset);
		add(rdbtnActive);
		add(comboEye);
		add(lblEye);
		add(spinnerLowerFace);
		add(comboLowerFace);
		add(lblLowerface);
		add(spinnerUpperFace);
		add(comboUpperFace);
		add(lblUpperFace);
		add(lblSeconds);
		add(timeElapsedTextbox);
		add(lblTime);
	}

	public DetectionController getDetectionController() {
		return this.detectionController;
	}

}
