import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
public class Runner {

	public static void main(String[] args) throws IOException, FontFormatException {
		JFrame fr = new JFrame("how high is your stack?");
		Screen screen=new Screen();
		fr.add(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.addMouseListener(screen);
		fr.pack();
		fr.setVisible(true);
		
		

	}

}
