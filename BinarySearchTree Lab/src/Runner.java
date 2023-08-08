import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		JFrame fr = new JFrame("wait whats a tree again");
		Screen screen=new Screen();
		fr.add(screen); 
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);

	}

}
