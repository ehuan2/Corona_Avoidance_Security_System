import javax.swing.*;

public class UserInterface {

UserInterface () {
	
	JFrame cass = new JFrame();
	
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
	
	cass.setSize(1200,700);
	cass.setLayout(null);
	cass.setVisible(true);

}	
	public static void main (String []args ) {
		
		new UserInterface();
		
	}
	
}
