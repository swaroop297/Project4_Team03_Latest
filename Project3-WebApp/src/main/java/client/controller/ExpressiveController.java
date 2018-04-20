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
 * 
 * @SER516 Project3_Team03
 * @version 1.0
 */
public class ExpressiveController {
	public ExpressiveView expressiveView;
	JPanel facePanel;
	JPanel graphPanel;
	private JPanel blinkGraph;
	private JPanel rgtWinkGraph;
	private JPanel lftWinkGraph;
	private JPanel looklftGraph;
	private JPanel lookrgtGraph;
	private JPanel furrowGraph;
	private JPanel raiseGraph;
	private JPanel smileGraph;
	private JPanel lftSmirkGraph;
	private JPanel rgtSmirkGraph;
	private JPanel clenchGraph;
	private JPanel laughGraph;
	private FacePaint f;
	private DisplayGraph g;
	private DisplayGraph g1;
	private DisplayGraph g2;
	private DisplayGraph g3;
	private DisplayGraph g4;
	private DisplayGraph g5;
	private DisplayGraph g6;
	private DisplayGraph g7;
	private DisplayGraph g8;
	private DisplayGraph g9;
	private DisplayGraph g10;
	private DisplayGraph g11;
	Thread t;
	double v[]= new double[13];
	boolean flag=true;
	JLabel timeValue;

	public ExpressiveController() {
		facePanel = new JPanel();
		graphPanel = new JPanel();
		blinkGraph = new JPanel();
		rgtWinkGraph = new JPanel();
		lftWinkGraph = new JPanel();
		looklftGraph = new JPanel();
		lookrgtGraph = new JPanel();
		furrowGraph = new JPanel();
		raiseGraph = new JPanel();
		smileGraph = new JPanel();
		clenchGraph = new JPanel();
		lftSmirkGraph = new JPanel();
		smileGraph = new JPanel();
		rgtSmirkGraph = new JPanel();
		laughGraph = new JPanel();

		expressiveView = new ExpressiveView(facePanel, graphPanel, blinkGraph, rgtWinkGraph, lftWinkGraph, looklftGraph,
				lookrgtGraph, furrowGraph, raiseGraph, smileGraph, clenchGraph, lftSmirkGraph, rgtSmirkGraph,
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
		
		f = new FacePaint();
		g = new DisplayGraph();
		g1 = new DisplayGraph();
		g2 = new DisplayGraph();
		g3 = new DisplayGraph();
		g4 = new DisplayGraph();
		g5 = new DisplayGraph();
		g6 = new DisplayGraph();
		g7 = new DisplayGraph();
		g8 = new DisplayGraph();
		g9 = new DisplayGraph();
		g10 = new DisplayGraph();
		g11 = new DisplayGraph();
		
		facePanel.add(f, BorderLayout.CENTER);
		blinkGraph.add(g, BorderLayout.CENTER);
		rgtWinkGraph.add(g1, BorderLayout.CENTER);
		lftWinkGraph.add(g2, BorderLayout.CENTER);
		lookrgtGraph.add(g3, BorderLayout.CENTER);
		looklftGraph.add(g4, BorderLayout.CENTER);
		furrowGraph.add(g5, BorderLayout.CENTER);
		raiseGraph.add(g6, BorderLayout.CENTER);
		smileGraph.add(g7, BorderLayout.CENTER);
		clenchGraph.add(g8, BorderLayout.CENTER);
		lftSmirkGraph.add(g9, BorderLayout.CENTER);
		rgtSmirkGraph.add(g10, BorderLayout.CENTER);
		laughGraph.add(g11, BorderLayout.CENTER);
		
		//Thread to make sure that the graphs keeps plotting the points.
		t = new Thread(new Runnable() {
			public void run() {
				while (flag) {
					g.addValues(v[8]);
					g1.addValues(v[10]);
					g2.addValues(v[9]);
					g3.addValues(v[12]);
					g4.addValues(v[11]);
					g5.addValues(v[2]);
					g6.addValues(v[1]);
					g7.addValues(v[3]);
					g8.addValues(v[4]);
					g9.addValues(v[5]);
					g10.addValues(v[6]);
					g11.addValues(v[7]);
					facePanel.repaint();
					blinkGraph.repaint();
					rgtWinkGraph.repaint();
					lftWinkGraph.repaint();
					lookrgtGraph.repaint();
					looklftGraph.repaint();
					furrowGraph.repaint();
					raiseGraph.repaint();
					smileGraph.repaint();
					clenchGraph.repaint();
					lftSmirkGraph.repaint();
					rgtSmirkGraph.repaint();
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
		f.changeVector(v);
		g.addValues(v[8]);
		g1.addValues(v[10]);
		g2.addValues(v[9]);
		g3.addValues(v[12]);
		g4.addValues(v[11]);
		g5.addValues(v[2]);
		g6.addValues(v[1]);
		g7.addValues(v[3]);
		g8.addValues(v[4]);
		g9.addValues(v[5]);
		g10.addValues(v[6]);
		g11.addValues(v[7]);
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
