import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args){
		
		JFrame fr = new JFrame("Insulae");
		Game game = new Game();
		
		fr.add(game);
		fr.addKeyListener(game);
		fr.addMouseListener(game);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
			    cursorImg, new Point(0, 0), "blank cursor");
		fr.getContentPane().setCursor(blankCursor);
		*/
		fr.pack();
		fr.setVisible(true);
		game.animate();
	}

}

