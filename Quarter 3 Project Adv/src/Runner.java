import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) {
		JFrame fr = new JFrame("gogogogogo");
		Screen screen=new Screen();
		fr.add(screen);
	  fr.addKeyListener(screen);
	  fr.addMouseListener(screen);
	  fr.addMouseMotionListener(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
		try {
			screen.animate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
