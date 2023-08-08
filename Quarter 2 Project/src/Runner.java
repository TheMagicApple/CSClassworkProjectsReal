import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


public class Runner {
  
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {


		JFrame frame = new JFrame("javax.swing");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create panel and add it to the frame
		Screen sc = new Screen();
		
		frame.add(sc);
		frame.pack();
		frame.setVisible(true);
		
		sc.animate();
    }
}
