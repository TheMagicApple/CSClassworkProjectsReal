import javax.swing.JFrame;
public class Runner {

	public static void main(String[] args) {
		JFrame fr = new JFrame("generic");
		Screen screen=new Screen();
		fr.add(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);

	}

}
