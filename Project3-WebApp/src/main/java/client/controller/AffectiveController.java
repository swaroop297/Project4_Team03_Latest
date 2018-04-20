package client.controller;

import client.view.AffectiveDisplayGraph;
import client.view.AffectiveView;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import utility.FaceAffectiveData;

/**
 * Controller for the Affective View
 */
public class AffectiveController {
	public AffectiveView affectiveView;
	JPanel leftPanel;
	private JPanel affectiveGraph;
	JPanel performancePanel;
	private AffectiveDisplayGraph graph1;
	boolean flag=true;
	Thread t;
	double v[]= new double[6];

	public AffectiveController() {
		leftPanel = new JPanel();
		affectiveGraph = new JPanel();
		performancePanel = new JPanel();

		affectiveView = new AffectiveView(leftPanel, affectiveGraph, performancePanel);
		graph1 = new AffectiveDisplayGraph();
		affectiveGraph.add(graph1, BorderLayout.CENTER);
		
		t = new Thread(new Runnable() {
			public void run() {
				while (flag) {
					graph1.addValues(v);
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
	 * @param fed contains the latest affective values
	 */
	public void updateGraph(FaceAffectiveData fed) {
		flag = false;
		v = fed.fetchVectors();
		graph1.addValues(v);
		flag = true;
		try{
			t.start();
		}catch(Exception e){
			
		}
	}
}
