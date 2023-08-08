import javax.swing.JFrame;
import javax.swing.JFrame;
public class Runner {
	private static Screen sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fr = new JFrame("Bank");
		sc = new Screen();
		
		fr.add( sc );
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			
		}
		System.out.println("ready...");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		System.out.println("go!");
		measure();
	}

	public static void measure() {
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			
		}
		sc.printClicks();
	}

}
