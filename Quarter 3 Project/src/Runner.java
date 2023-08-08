import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
public class Runner
{
	public static void main(String args[])
	{
		Table game = new Table();
		JFrame frame = new JFrame("BlackJack");
		
		frame.add(game);
		frame.addMouseListener(game);
		frame.addMouseMotionListener(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
			    cursorImg, new Point(0, 0), "blank cursor");
		frame.getContentPane().setCursor(blankCursor);
		frame.pack();
		
		frame.setVisible(true);
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			System.out.println("something went wrong with thread.sleep");
		}
		game.animate();
	}
}
