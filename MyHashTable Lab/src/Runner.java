import java.io.IOException;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		JFrame fr = new JFrame("MyHashTable Lab");
		Screen screen=new Screen();
		fr.add(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);

	}

}
