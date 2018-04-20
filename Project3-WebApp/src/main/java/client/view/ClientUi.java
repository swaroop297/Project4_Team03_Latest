package client.view;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import client.controller.AffectiveController;
import client.controller.ExpressiveController;
import client.controller.MenuItemController;
import client.service.FaceClient;
import utility.FaceData;

/**
 * @SER516 Project3_Team03
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class ClientUi extends JFrame {

	JPanel facePanel;
	private ExpressiveController expressiveController;
	private AffectiveController affectiveController;

	/**
	 * Creates the application
	 * @param expressiveController Contains the expression controller object
	 */
	public ClientUi(ExpressiveController expressiveController, AffectiveController affectiveController) {
		this.expressiveController = expressiveController;
		this.affectiveController = affectiveController;
		initialize(expressiveController.expressiveView, affectiveController.affectiveView);
		this.setBounds(new Rectangle(0, 0, 710, 432));
		this.getContentPane().setLayout(null);
		FaceClient.create(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JPanel expressiveView, JPanel affectiveView) {

		final JPanel panel = new JPanel();
		panel.setBounds(0, 0, 698, 402);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 22, 698, 380);
		panel.add(tabbedPane);

		tabbedPane.addTab("Expressive", null, expressiveView, null);

		tabbedPane.addTab("Affective", null, affectiveView, null);

		final JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 698, 22);
		panel.add(menuBar);

		final JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		final JMenu mntmApplication = new JMenu("Application");
		mnFile.add(mntmApplication);

		final JMenu mntmConnection = new JMenu("Connection");
		mnFile.add(mntmConnection);

		final JMenuItem serverConsole = new JMenuItem("Open Server");
		mntmApplication.add(serverConsole);

		JMenuItem serverConnect = new JMenuItem("Connect to Server");
		mntmConnection.add(serverConnect);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		mnFile.add(exitMenuItem);

		new MenuItemController(serverConnect, serverConsole, exitMenuItem);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Sets the different data values.
	 * @param faceData contains the received expression data
	 */
	public void setFaceData(FaceData faceData) {
		this.expressiveController.updateTime(faceData);
		this.expressiveController.updateGraph(faceData.getFaceExpressionData());
	    this.affectiveController.updateGraph(faceData.getFaceAffectiveData());
	}
}
