import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class Runner2 {

	public static void main(String[] args) throws IOException, FontFormatException {
		JFrame fr = new JFrame("how high is your stack?");
		Screen screen=new Screen();
		fr.add(screen);
		
		
	 
	   // fr.setSize(500,500);
	  fr.addKeyListener(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
		
		

	}

}
