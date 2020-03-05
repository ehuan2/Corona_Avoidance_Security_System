import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;



public class DrawTest extends JPanel {

	private static final long serialVersionUID = 1L;
	static JFrame frame = new JFrame("Prototype");
	final int circles[][] = {{100, 100, 150}, {90, 60, 50}, {30, 140, 75}};
	
public static void main(String args[]){
	setGui();
}
	
	
public static void setGui(){
	DrawTest dt = new DrawTest();
	
	frame.setSize(500, 500);
	frame.setLocation(300, 200);
	frame.setResizable(false);

	dt.setLayout(null);
	frame.add(dt);
	
	frame.addKeyListener(new KeyListener() {
		
		@Override
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode() == KeyEvent.VK_SPACE){
				frame.repaint();
			}
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
		public void keyTyped(KeyEvent e){
			
		}
	});
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
	

public void paintComponent(Graphics g){
	super.paintComponent(g);
	this.setBackground(Color.WHITE);
	
	Random r = new Random();
	int n = r.nextInt(circles.length);
	
	
	
	g.drawOval(circles[n][0], circles[n][1], circles[n][2], circles[n][2]);
}

}
