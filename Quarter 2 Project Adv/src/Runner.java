import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Runner {
	static Cursor blankCursor;
	static JFrame fr;
	public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
	    fr = new JFrame("portal");
		Screen screen=new Screen();
		fr.add(screen);
		fr.addKeyListener(screen);
		fr.addMouseListener(screen);
		fr.addMouseMotionListener(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		
		fr.pack();
		fr.setVisible(true);
		screen.animate();
	}
	public static void hideCursor() {
		fr.getContentPane().setCursor(blankCursor);	
	}
}