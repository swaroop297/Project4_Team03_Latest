package client.controller;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import client.view.DisplayGraph;
import client.view.ExpressiveView;
import client.view.FacePaint;
import utility.FaceData;
import utility.FaceExpressionData;

/**
 * Controller for the Expressions View
 */
public class ExpressiveController {
	public ExpressiveView expressiveView;
	JPanel facePanel;
	JPanel graphPanel;
	private JPanel blinkGraph;
	private JPanel rightWinkGraph;
	private JPanel leftWinkGraph;
	private JPanel lookLeftGraph;
	private JPanel lookRightGraph;
	private JPanel furrowGraph;
	private JPanel raiseGraph;
	private JPanel smileGraph;
	private JPanel leftSmirkGraph;
	private JPanel rightSmirkGraph;
	private JPanel clenchGraph;
	private JPanel laughGraph;
	private FacePaint face;
	private DisplayGraph graph;
	private DisplayGraph graph1;
	private DisplayGraph graph2;
	private DisplayGraph graph3;
	private DisplayGraph graph4;
	private DisplayGraph graph5;
	private DisplayGraph graph6;
	private DisplayGraph graph7;
	private DisplayGraph graph8;
	private DisplayGraph graph9;
	private DisplayGraph graph10;
	private DisplayGraph graph11;
	Thread t;
	double v[]= new double[13];
	boolean flag=true;
	JLabel timeValue;

	public ExpressiveController() {
		facePanel = new JPanel();
		graphPanel = new JPanel();
		blinkGraph = new JPanel();
		rightWinkGraph = new JPanel();
		leftWinkGraph = new JPanel();
		lookLeftGraph = new JPanel();
		lookRightGraph = new JPanel();
		furrowGraph = new JPanel();
		raiseGraph = new JPanel();
		smileGraph = new JPanel();
		clenchGraph = new JPanel();
		leftSmirkGraph = new JPanel();
		smileGraph = new JPanel();
		rightSmirkGraph = new JPanel();
		laughGraph = new JPanel();

		expressiveView = new ExpressiveView(facePanel, graphPanel, blinkGraph, rightWinkGraph, leftWinkGraph, lookLeftGraph,
				lookRightGraph, furrowGraph, raiseGraph, smileGraph, clenchGraph, leftSmirkGraph, rightSmirkGraph,
				laughGraph);

		final JLabel faceLabel = new JLabel("    Face Expression");
		faceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		faceLabel.setBounds(0, 3, 336, 26);
		expressiveView.add(faceLabel);

		final JLabel timeLabel = new JLabel("    Time:");
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		timeLabel.setBounds(0, 310, 100, 20);
		expressiveView.add(timeLabel);
		
		timeValue = new JLabel("0.0");
		timeValue.setFont(new Font("Tahoma", Font.BOLD, 12));
		timeValue.setBounds(120, 310, 30, 20);
		expressiveView.add(timeValue);
		
		final JLabel graphLabel = new JLabel("    Graph Charts");
		graphLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		graphLabel.setBounds(336, 0, 357, 29);
		expressiveView.add(graphLabel);
		
		face = new FacePaint();
		graph = new DisplayGraph();
		graph1 = new DisplayGraph();
		graph2 = new DisplayGraph();
		graph3 = new DisplayGraph();
		graph4 = new DisplayGraph();
		graph5 = new DisplayGraph();
		graph6 = new DisplayGraph();
		graph7 = new DisplayGraph();
		graph8 = new DisplayGraph();
		graph9 = new DisplayGraph();
		graph10 = new DisplayGraph();
		graph11 = new DisplayGraph();
		
		facePanel.add(face, BorderLayout.CENTER);
		blinkGraph.add(graph, BorderLayout.CENTER);
		rightWinkGraph.add(graph1, BorderLayout.CENTER);
		leftWinkGraph.add(graph2, BorderLayout.CENTER);
		lookRightGraph.add(graph3, BorderLayout.CENTER);
		lookLeftGraph.add(graph4, BorderLayout.CENTER);
		furrowGraph.add(graph5, BorderLayout.CENTER);
		raiseGraph.add(graph6, BorderLayout.CENTER);
		smileGraph.add(graph7, BorderLayout.CENTER);
		clenchGraph.add(graph8, BorderLayout.CENTER);
		leftSmirkGraph.add(graph9, BorderLayout.CENTER);
		rightSmirkGraph.add(graph10, BorderLayout.CENTER);
		laughGraph.add(graph11, BorderLayout.CENTER);
		
		//Thread to make sure that the graphs keeps plotting the points.
		t = new Thread(new Runnable() {
			public void run() {
				while (flag) {
					graph.addValues(v[8]);
					graph1.addValues(v[10]);
					graph2.addValues(v[9]);
					graph3.addValues(v[12]);
					graph4.addValues(v[11]);
					graph5.addValues(v[2]);
					graph6.addValues(v[1]);
					graph7.addValues(v[3]);
					graph8.addValues(v[4]);
					graph9.addValues(v[5]);
					graph10.addValues(v[6]);
					graph11.addValues(v[7]);
					facePanel.repaint();
					blinkGraph.repaint();
					rightWinkGraph.repaint();
					leftWinkGraph.repaint();
					lookRightGraph.repaint();
					lookLeftGraph.repaint();
					furrowGraph.repaint();
					raiseGraph.repaint();
					smileGraph.repaint();
					clenchGraph.repaint();
					leftSmirkGraph.repaint();
					rightSmirkGraph.repaint();
					laughGraph.repaint();
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
	 * Updates the Face and the Graph on the basis of received values
	 * @param fed Contains the latest expression values
	 */
	public void updateGraph(FaceExpressionData fed) {
		flag = false;
		v = fed.fetchVectors();
		face.changeVector(v);
		graph.addValues(v[8]);
		graph1.addValues(v[10]);
		graph2.addValues(v[9]);
		graph3.addValues(v[12]);
		graph4.addValues(v[11]);
		graph5.addValues(v[2]);
		graph6.addValues(v[1]);
		graph7.addValues(v[3]);
		graph8.addValues(v[4]);
		graph9.addValues(v[5]);
		graph10.addValues(v[6]);
		graph11.addValues(v[7]);
		flag = true;
		try{
			t.start();
		}catch(Exception e){
			
		}				
	}
	
	/**
	 * Updates the time value based on the received data.
	 * @param data Contains all the data values.
	 */
	public void updateTime(FaceData data){
		timeValue.setText(data.getTimeElapsed().toString());
	}
}
