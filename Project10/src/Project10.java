// James Dizikes
// CS 1324 Fall 2019
// Maintained by D. Trytten 4/12/2020
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Project10 extends JPanel
{
	// Change these constants to adjust the size and title of the window.
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final String WINDOW_TITLE = "My Image Title!";
	
	// Do not change the main method.
	public static void main(String[] args)
	{
		JPanel panel = new Project10();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		JFrame frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		frame.pack();
	}
	
	// Add your drawing code to this method.
	public void paintComponent(Graphics g)
	{
		// Do not change these two lines.
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Replace the example below with your code.
		
		g2d.setColor(Color.GREEN);
		
		Polygon polygon = new Polygon();
		polygon.addPoint(200, 50);
		polygon.addPoint(250,  150);
		polygon.addPoint(150,  150);
		g2d.fill(polygon);
		
		g2d.setColor(Color.BLUE);
		
		RoundRectangle2D.Double roundRect = new RoundRectangle2D.Double(300, 200, 100, 50, 20, 20);
		g2d.setColor(Color.BLUE);
		g2d.fill(roundRect);
		
		Arc2D.Double arc = new Arc2D.Double(100, 300, 100, 100, 45, 180, Arc2D.OPEN);
		g2d.setColor(Color.CYAN);
		g2d.fill(arc);
		
		g2d.setColor(Color.BLACK);g2d.drawString("Geometric Art", 250, 400);
		
		g2d.translate(400,  100);
		g2d.scale(1.5, 1.5);
		
		g2d.setColor(Color.PINK);
		g2d.fill(polygon);
		
		g2d.setColor(Color.RED);
		g2d.fill(roundRect);
	}
}