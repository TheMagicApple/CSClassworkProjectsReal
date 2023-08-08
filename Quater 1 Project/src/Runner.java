import javax.swing.*;
import java.util.Scanner;
public class Runner{
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Day, night, or sunset? (1 or 2 or 3)");
		int selection1=scanner.nextInt();
		System.out.println("Winter or spring? (1 or 2)");
		int selection2=scanner.nextInt();
		System.out.println("Lake or river? (1 or 2)");
		int selection3=scanner.nextInt();
		JFrame frame=new JFrame("Nature is fun");
		Scenery scenery=new Scenery(selection1,selection2,selection3);
		frame.add(scenery);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		while(true) {
			frame.repaint();
			Thread.sleep(10);
		}
	}
}