import javax.swing.JFrame;


public class Runner {
  
	public static void main(String[] args) {

		JFrame frame = new JFrame("luxury hotel");
		Scenery sc = new Scenery();
		
		frame.add(sc);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		sc.animate();
    }
}
