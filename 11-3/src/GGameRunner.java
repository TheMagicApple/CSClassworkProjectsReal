import javax.swing.JFrame;

public class GGameRunner {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Spin");
		Screen sc = new Screen();
		
		frame.add(sc);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
