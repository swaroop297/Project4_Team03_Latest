package client.controller;

import client.view.AffectiveDisplayGraph;
import client.view.AffectiveView;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import utility.FaceAffectiveData;


/**
 * Controller for the Affective View
 * 
 * @SER516 Project3_Team03
 * @version 1.0
 */
public class AffectiveController {

	public AffectiveView affectiveView;
	JPanel leftPanel;
	private JPanel affectiveGraph;
	JPanel perfPanel;
	private AffectiveDisplayGraph g1;
	boolean flag=true;
	Thread t;
	double v[]= new double[6];

	public AffectiveController() {
		leftPanel = new JPanel();
		affectiveGraph = new JPanel();
		perfPanel = new JPanel();

		affectiveView = new AffectiveView(leftPanel, affectiveGraph, perfPanel);
		g1 = new AffectiveDisplayGraph();
		affectiveGraph.add(g1, BorderLayout.CENTER);
		
		t = new Thread(new Runnable() {
			public void run() {
				while (flag) {
					g1.addValues(v);
					affectiveGraph.repaint();
					try {
				 		Thread.sleep(1000);
				 	} catch (InterruptedException e) {
				 		e.printStackTrace();
				 	}
				}
			}
		
		 });

	}
	
	/**
	 * Updates Graph on the basis of received values
	 * @param fed Contains the latest affective values
	 */
	public void updateGraph(FaceAffectiveData fed) {
		flag = false;
		v = fed.fetchVectors();
		g1.addValues(v);
		flag = true;
		try{
			t.start();
		}catch(Exception e){
			
		}
	}

}
