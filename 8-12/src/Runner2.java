import javax.swing.JFrame;
public class Runner2 {
	public static void main(String[] args) {
		JFrame fr = new JFrame("classwork 8/12");
		Screen screen=new Screen();
		fr.add(screen);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
	}
}
