import javax.swing.JFrame;

import Bank.*;

public class Runner {

	public static void main(String[] args) {
		//AccountManager a=new AccountManager();
		//a.printInfo();
		JFrame frame = new JFrame("bank");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create panel and add it to the frame
		Screen sc = new Screen();
		
		frame.add(sc);
		frame.pack();
		frame.setVisible(true);

	}

}
