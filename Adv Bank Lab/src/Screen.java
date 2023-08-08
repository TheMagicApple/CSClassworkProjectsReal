import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Screen extends JPanel implements ActionListener{
	private ArrayList<Account> bank=new ArrayList<>();
	private JTextField name;
	private JTextField pin;
	private JTextField money;
	private JButton submit;
	private JButton deposit;
	private JButton withdraw;
	private JButton logout;
	private Account in;
	private BufferedImage jennifer;
	private BufferedImage jose;
	private BufferedImage bob;
	private BufferedImage carl;
	private BufferedImage joe;
	public Screen() {
		try {
			jennifer=ImageIO.read(new File("jenniferreal.jpg"));
			jose=ImageIO.read(new File("jose.jpg"));
			bob=ImageIO.read(new File("bob.jpg"));
			carl=ImageIO.read(new File("carl.png"));
			joe=ImageIO.read(new File("joe.jpg"));
		}catch(IOException e) {
			System.out.println("no images?");
		}
		bank.add(new Account("Jennifer",999.99,1234,jennifer));
		bank.add(new Account("Jose",500.01,4321,jose));
		bank.add(new Account("Bob",1000000,1111,bob));
		bank.add(new Account("Carl",25,123,carl));
		bank.add(new Account("Joe",Integer.MAX_VALUE,65618327,joe));
		setLayout(null);
		name=new JTextField();
		pin=new JTextField();
		money=new JTextField();
		submit=new JButton("Submit");
		deposit=new JButton("Deposit");
		withdraw=new JButton("Withdraw");
		logout=new JButton("Log Out");
		name.setBounds(100,100,100,50);
		pin.setBounds(300,100,100,50);
		money.setBounds(200,300,100,50);
		submit.setBounds(200,200,100,50);
		deposit.setBounds(130,400,100,50);
		withdraw.setBounds(270,400,100,50);
		logout.setBounds(400,20,80,25);
		add(name);
		add(pin);
		add(submit);
		submit.addActionListener(this);
		deposit.addActionListener(this);
		withdraw.addActionListener(this);
		logout.addActionListener(this);
		setVisible(true);
	}
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(in!=null) {
			g.drawString("Name: "+in.getName(), 220,50);
			g.drawString("Balance: "+in.getBalance(), 220,80);
			g.drawString("Money", 230,285);
			g.drawImage(in.getImage(),200,100,null);
		}else {
			g.drawString("Name", 130,85);
			g.drawString("Pin", 335,85);
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			int p=Integer.parseInt(pin.getText());
			for(Account a:bank) {
				a.setAccess(p, name.getText());
				if(a.getAccess()) {
					in=a;
					remove(name);
					remove(pin);
					remove(submit);
					add(money);
					add(deposit);
					add(withdraw);
					add(logout);
				}
			}
		}
		if(e.getSource()==deposit) {
			in.deposit(Double.parseDouble(money.getText()));
		}
		if(e.getSource()==withdraw && in.getBalance()>Double.parseDouble(money.getText())) {
			in.withdraw(Double.parseDouble(money.getText()));
		}
		if(e.getSource()==logout) {
			remove(money);
			remove(deposit);
			remove(withdraw);
			remove(logout);
			in.logout();
			in=null;
			add(name);
			add(pin);
			add(submit);
			name.setText("");
			pin.setText("");
		}
		repaint();
	}
}