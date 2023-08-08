import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Screen extends JPanel implements ActionListener{
	private JButton click;
	
	private int clicks=0;
	public Screen() {
		setLayout(null);
		click=new JButton("click");
		click.setBounds(150,150,500,500);
		add(click);
		click.addActionListener(this);
		
	}
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==click) {
			click();
			clicks+=1;
		}
		
	}
	public void click() {
		try {
			Thread.sleep(1);
		}catch(InterruptedException e) {
			System.out.println("thats not good...");
		}
		clicks++;
		click();
		
	}
	public void printClicks() {
		System.out.println("clicks: "+clicks);
		System.out.println("cps: "+clicks/5.0);
	}
}
