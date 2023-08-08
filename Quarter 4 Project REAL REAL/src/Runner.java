import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileWriter f=new FileWriter("test.java");
		BufferedWriter b=new BufferedWriter(f);
		b.write("public class test{\npublic static void main(String args[]){\nSystem.out.println('a');\n}\n}");
		b.close();
		Thread.sleep(1000);
		test.main(args);
		JFrame fr = new JFrame("Mocha IDE");
		IDE ide = new IDE();
		
		fr.add(ide);
		fr.addMouseListener(ide);
		fr.addKeyListener(ide);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
			    cursorImg, new Point(0, 0), "blank cursor");
		fr.getContentPane().setCursor(blankCursor);
		*/
		fr.pack();
		fr.setVisible(true);

	}

}
