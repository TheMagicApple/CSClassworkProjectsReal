import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
public class GameRunner
{
	public static void main(String args[])
	{
		Screen game = new Screen();
		JFrame frame = new JFrame("tic tac toe");
		
		frame.add(game);
		frame.addMouseListener(game);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);
		
	}
}

