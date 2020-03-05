

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.*;

public class UserInterface extends JPanel {

	private static final long serialVersionUID = 1L;
	static JFrame frame = new JFrame("Prototype");
	static JPanel panel = new JPanel();
	static int circles[][] = new int[3][1];
	private static LinkedList<pointLocation> points = new LinkedList<pointLocation>();
	static UserInterface cass = new UserInterface();
	
	static int x;
	static int y;
	
	static int xloca;
	static int yloca;
	static int xdestin;
	static int ydestin;
	
	static int select;
	static int index;
	
public static void main(String args[]){
	setGui();
}
	
	
public static void setGui(){
	
	frame.setLocation(400, 0);				//Size, Location and Resizable status.
	frame.setResizable(false);
	cass.setSize(750, 900);
	frame.setSize(cass.getSize());
	cass.setLayout(null);

	//report button 
	JButton report = new JButton("Report");
	report.setBounds(25, 760, 200, 40);
	report.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent a) {
			points = GraphPathFinding.findPath(xloca, yloca, xdestin, ydestin, circles[0], circles[1], circles[2]);

			if (points == null) JOptionPane.showMessageDialog(frame, "No path found, you died lmao!");
			cass.revalidate();
			cass.repaint();
		}
		
	});
	cass.add(report);

	//location button
	JButton location = new JButton ("Select location");
	location.setBounds(250, 760, 200, 40);
	location.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent a) {
			xloca = x;
			yloca = y;
			cass.revalidate();
			cass.repaint();
		}
		
	});
	cass.add(location);
	
	//destination button
	JButton destination = new JButton ("Select destination");
	destination.setBounds(475, 760, 200, 40);
	destination.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent a) {
			xdestin = x;
			ydestin = y;
			cass.revalidate();
			cass.repaint();
		}
		
	});
	cass.add(destination);	
	
	JButton zone = new JButton("Add zone");
	zone.setBounds(250, 810, 200, 40);
	zone.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent a){
			int radius = 0;								//Zone creation code.
			for (;;){
				try {
					radius = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the radius (integer value > 0)"));
				} catch (Exception e){
					JOptionPane.showMessageDialog(frame, "Not a valid integer (greater than 0)");
				}
				if (radius > 0) break;
			}

			
			for (int i = 0; i < 3; i++){
				circles[i] = Arrays.copyOf(circles[i], circles[i].length + 1);
			}
			
			circles[0][index] = x;
			circles[1][index] = y;
			circles[2][index] = radius;
			
			index++;
			
			cass.revalidate();
			cass.repaint();
		}
	});
	cass.add(zone);
	
	JButton reset = new JButton("Reset zones");
	reset.setBounds(475, 810, 200, 40);
	reset.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent a){
			circles = new int[3][1];						//Zone resetti code.
			index = 0;
			
			cass.revalidate();
			cass.repaint();
		}
	});
	cass.add(reset);
	
	
	cass.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent m) {
			x = m.getX() > 750 ? 750 : Math.round(m.getX()/25f) * 25;
			y = m.getY() > 750 ? 750 : Math.round(m.getY()/25f) * 25;
			
			System.out.println("(" + x + ", " + y + ")");
			
			cass.revalidate();
			cass.repaint();
		}

		@Override
		public void mouseEntered(MouseEvent m) {
			
		}

		@Override
		public void mouseExited(MouseEvent m) {
			
		}

		@Override
		public void mousePressed(MouseEvent m) {
			
		}

		@Override
		public void mouseReleased(MouseEvent m) {
			
		}
		
	});
	
	
	frame.add(cass);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
	


public void paintComponent(Graphics g){
	super.paintComponent(g);
	this.setBackground(Color.WHITE);
	
	
	g.drawLine(0, 750, 750, 750);
	

	g.setColor(Color.BLUE);
	g.fillOval(x - 5, y - 5, 10, 10);
	
	
	g.setColor(Color.RED);	
	for (int j = 0; j < index; j++){
		g.fillOval(circles[0][j] - circles[2][j]/2, circles[1][j] - circles[2][j]/2, circles[2][j], circles[2][j]);
	}
	

	if (points != null){
		
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < points.size()-1; i++){
			g.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y);
		}
	}
	

	g.setColor(Color.PINK);
	g.fillOval(xloca - 5, yloca - 5, 10, 10);
	
	g.setColor(Color.GREEN);
	g.fillOval(xdestin - 5, ydestin - 5, 10, 10);
	
	
}

}
