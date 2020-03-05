import java.awt.Image;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class UserInterface {

	int x;
	int y;

UserInterface () {
	
	JFrame cass = new JFrame();
	cass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//report button 
	JButton report = new JButton("Report");
	report.setBounds(25, 560, 300, 90);
	cass.add(report);

	//location button
	JButton location = new JButton ("Select location");
	location.setBounds(350, 560, 300, 90);
	cass.add(location);
	
	//destination button
	JButton destination = new JButton ("Select destination");
	destination .setBounds(675, 560, 300, 90);
	cass.add(destination);
	
	cass.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			x = Math.round(e.getX()/25)*25; 
			y = Math.round(e.getY()/25)*25; 
			
			System.out.println("(" + x + ", " + y + ")" );

		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			//System.out.println("Pressed");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			//System.out.println("Released");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			//System.out.println("Entered");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			//System.out.println("Exited");
			
		}
		
	});
	
	cass.setSize(1200,700);
	cass.setLayout(null);
	cass.setVisible(true);

}	
	public static void main (String []args ) {
		
		new UserInterface();
		
	}

}
