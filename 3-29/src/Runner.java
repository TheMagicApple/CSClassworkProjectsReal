import java.io.IOException;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) throws IOException, InterruptedException {
		JFrame fr = new JFrame("gogogogogo");
		ChattyScreen screen=new ChattyScreen();
		fr.add(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
		screen.animate();
	}

}
