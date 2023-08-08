import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
public class Screen extends JPanel implements ActionListener{
	private GGame game;
	private JButton spin;
	public Screen() {
		setLayout(null);
		spin=new JButton("Spin!");
		spin.setBounds(300,150,200,100);
		add(spin);
		spin.addActionListener(this);
		game=new GGame();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==spin) {
			game.spin();
		}
		repaint();
	}
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String message=game.getMessage();
		g.drawString(message, 400, 350);
		int myBalance = game.getBalance();   
		g.drawString( "" + myBalance+" tokens", 400,400);
		int slot1=game.getSlot1();
		int slot2=game.getSlot2();
		int slot3=game.getSlot3();
		g.drawString(""+slot1, 400, 300);
		g.drawString(""+slot2, 410, 300);
		g.drawString(""+slot3, 420, 300);
	}
	

}
