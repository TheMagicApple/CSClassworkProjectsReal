public class Runner {
	public static void main(String[] args) {
		javax.swing.JFrame fr = new javax.swing.JFrame("bank");
		Screen screen=new Screen();
		fr.add(screen);
		fr.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		fr.pack();
		fr.setVisible(true);
	}
}