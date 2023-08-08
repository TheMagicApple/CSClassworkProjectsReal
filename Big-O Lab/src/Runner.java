import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class Runner {

	public static void main(String[] args) throws IOException {
		JFrame fr = new JFrame("massive O");
		Screen screen=new Screen();
		fr.add(screen);
		
		
	  
	   // fr.setSize(500,500);
	  
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
		

	}

}
