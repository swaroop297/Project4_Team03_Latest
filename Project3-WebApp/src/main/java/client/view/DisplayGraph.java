package client.view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Class to display the expressions graphs
 * 
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class DisplayGraph extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 255;
    private static final int HEIGHT = 20;
    private static final int BORDER_GAP = 0;
    private static final Stroke GRAPH_STROKE = new BasicStroke(1f);
    private static final int GRAPH_POINT_WIDTH = 1;
    private static final int MAX_LIST_SIZE = 30;
    private List<Double> list1 = new ArrayList<Double>();
    private List<Point> graphPoints1;
    private Stroke oldStroke1;

    /**
     * Adds the received values to an arraylist.
     * @param rvalues contains values received from server after a certain time interval.
     */
    public void addValues(double rvalues){
        list1.add(rvalues);
    }
    
    /**
     * Uses Graphics to create and plot the graphs.
     */
    @Override
    protected void paintComponent(Graphics g) {
       graphPoints1 = new ArrayList<Point>();
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D)g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       //creates x and y axes scales.
       double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (list1.size() + MAX_LIST_SIZE - 1);
       double yScale = (double) getHeight() - 2;
       
       //calls to functions to create coordinate values from the provided lists.
       createPoints(graphPoints1, list1, xScale, yScale);
       
       //creates x and y axes.
       g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
       g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

       //calls to functions to plots the lines.
       oldStroke1 = plotLines(g2, oldStroke1, graphPoints1, Color.BLUE);

       //calls to functions to plots the points.
       plotPoints(g2, oldStroke1, graphPoints1, Color.BLUE);
       
    }

    /**
     * Gets the dimension of the outer panel.
     */
    @Override
    public Dimension getPreferredSize() {
       return new Dimension(WIDTH, HEIGHT - 10);
    }
    
    /**
     * Generates points to be plotted on the graph
     * @param p contains list of generated points
     * @param l contains list of values received from server
     * @param xScale contains the horizontal dimension of the graph
     * @param yScale contains the vertical dimension of the graph
     */
    public void createPoints(List<Point> p, List<Double> l, double xScale, double yScale){
      for (int i = 0; i < l.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((1- l.get(i)) * yScale  + BORDER_GAP);
            p.add(new Point(x1, y1));
         }
    }
    
    /**
     * Generates and plots the lines on the graph
     * @param ga contains the graphic component
     * @param s contains the stroke component that is used to plot lines
     * @param p contains the list of points
     * @param gc contains the color values for the respective lines
     * @return contains the stroke component that has been generated
     */
    public Stroke plotLines(Graphics2D ga, Stroke s, List<Point> p, Color gc){
      s = ga.getStroke();
      ga.setColor(gc);
        ga.setStroke(GRAPH_STROKE);
        for (int i = 1; i < p.size(); i++) {
           int x1 = p.get(i-1).x;
           int y1 = p.get(i-1).y;
           int x2 = p.get(i).x;
           int y2 = p.get(i).y;
           ga.drawLine(x1, y1, x2, y2);         
        }
        return s;
    }
    
    /**
     * Plots the points on the graph
     * @param ga contains the graphic component
     * @param s contains the generated stroke component 
     * @param p contains the list of points
     * @param gc contains the color values for the respective points
     */
    public void plotPoints(Graphics2D ga, Stroke s, List<Point> p, Color gc){
        ga.setStroke(s);      
        ga.setColor(gc);
        for (int i = 0; i < p.size(); i++) {
           int x = p.get(i).x - GRAPH_POINT_WIDTH / 2;
           int y = p.get(i).y - GRAPH_POINT_WIDTH / 2;;
           int ovalW = GRAPH_POINT_WIDTH;
           int ovalH = GRAPH_POINT_WIDTH;
           ga.fillOval(x, y, ovalW, ovalH);
        }
    }
}
