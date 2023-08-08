import java.io.IOException;

import javax.swing.JFrame;

public class ServerRunner {
	public static void main(String[] args) throws IOException, InterruptedException {
		JFrame fr = new JFrame("gogogogogo");
		ServerScreen screen=new ServerScreen();
		fr.add(screen);
		fr.addMouseListener(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
		screen.animate();
	}
}