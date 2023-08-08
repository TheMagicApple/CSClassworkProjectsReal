import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) {
		Dog fido=new Dog("Fido");
		fido.printInfo();
		Bird tweety=new Bird("Tweety");
		tweety.printInfo();


		JFrame fr = new JFrame("animals");
		Screen sc = new Screen();
		
		fr.add(sc);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
	}

}
