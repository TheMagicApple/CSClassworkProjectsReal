import javax.swing.JFrame;

public class RunnerD {

	public static void main(String[] args) {
		JFrame frame = new JFrame("???");
		Screen sc = new Screen();
		
		frame.add(sc);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
