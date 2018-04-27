package server.view;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import server.controller.MenuController;
import server.service.FaceServer;

/**
 * View for the Server.
 */
@SuppressWarnings("serial")
public class EmoticonComposer extends JFrame implements WindowListener {

	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmAbout;
	private JMenu mnUpload;
	JMenuItem mntmQuit;
	Thread inputThread;
	boolean running = false;
	double emoIntervalSelected = 1;
	Double timeElapsed = 0.0;
	InteractivePanel ipanel;
	public DetectionPanel dpanel;

	public EmoticonComposer() {

		try {
	            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	          } catch (Exception e) {
	            System.err.println("Look and feel not set.");
	          }
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 531, 887);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		try {
			JLabel imagePanel = new JLabel(new ImageIcon(ImageIO.read(new File("bg.jpg"))));
			imagePanel.setEnabled(true);
			this.setContentPane(imagePanel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 30, 489, 175);
		this.getContentPane().add(tabbedPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(12, 243, 489, 552);
		this.getContentPane().add(tabbedPane_1);

		
		dpanel = new DetectionPanel();
		dpanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.BLACK));
		tabbedPane_1.addTab("DETECTION", null, dpanel, null);

		ipanel = new InteractivePanel(dpanel);
		ipanel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.BLACK));
		tabbedPane.addTab("INTERACTIVE", null, ipanel, null);
		ipanel.setLayout(null);

		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		mntmAbout = new JMenuItem("About");
		mnNewMenu.add(mntmAbout);

		mntmQuit = new JMenuItem("Quit");
		mnNewMenu.add(mntmQuit);

		JButton btnSend;
		btnSend = new JButton("Upload CSV File");
		btnSend.setBounds(337, 58, 119, 25);
		menuBar.add(btnSend);
		
		System.out.println("adding upload button");
		new MenuController(mntmAbout, mntmQuit, btnSend);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
	}

	@Override
	public void windowOpened(WindowEvent e) {		
	}

	@Override
	public void windowClosing(WindowEvent e) {		
	}
	
	/**
	 * Closes the socket when window closes.
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		FaceServer.stop();
	}

	@Override
	public void windowIconified(WindowEvent e) {		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {		
	}

	@Override
	public void windowActivated(WindowEvent e) {		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {		
	}
}
