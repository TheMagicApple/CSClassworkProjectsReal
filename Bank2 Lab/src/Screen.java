
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
public class Screen extends JPanel implements ActionListener{
	private JTextField pinInput;
	private JTextField money;
	private JTextField nameInput;
	private JButton loginButton;
	private JButton withdrawButton;
	private JButton depositButton;
	private JButton nameButton;
	private JButton signoutButton;
	private Bank john;
	private Bank jen;
	private Bank jerry;
	private String loggedIn;
	private BufferedImage image;
	public Screen() {
		setLayout(null);
		john=new Bank("John",100.99,1234);
		jen=new Bank("Jen",1000.01,4321);
		jerry=new Bank("Jerry",50.50,1111);
		pinInput=new JTextField();
		pinInput.setBounds(300,270,100,50);
		add(pinInput);
		money=new JTextField();
		money.setBounds(240,350,100,50);
		add(money);
		nameInput=new JTextField();
		nameInput.setBounds(360,350,100,50);
		add(nameInput);
		loginButton=new JButton("Login");
		loginButton.setBounds(300,320,100,30);
		add(loginButton);
		withdrawButton=new JButton("Withdraw");
		withdrawButton.setBounds(240,400,100,30);
		add(withdrawButton);
		depositButton=new JButton("Deposit");
		depositButton.setBounds(240,430,100,30);
		add(depositButton);
		nameButton=new JButton("Name");
		nameButton.setBounds(360,400,100,30);
		add(nameButton);
		signoutButton=new JButton("Sign out");
		signoutButton.setBounds(520,470,100,30);
		add(signoutButton);
		loginButton.addActionListener(this);
		withdrawButton.addActionListener(this);
		depositButton.addActionListener(this);
		nameButton.addActionListener(this);
		signoutButton.addActionListener(this);
		try {
			image=ImageIO.read(new File("bank.jpg"));
		}catch(IOException e) {
			
		}
		setFocusable(true);
		
	}
	

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(800,600);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image,-95,-215,this);
		//g.drawString("Pin", 20, 32);
		if(loggedIn=="John") {
			g.drawString("Name: "+john.getName(),350,100);
			g.drawString("Balance: "+john.getBalance(),350,120);
		}
		if(loggedIn=="Jen") {
			g.drawString("Name: "+jen.getName(),350,100);
			g.drawString("Balance: "+jen.getBalance(),350,120);
		}
		if(loggedIn=="Jerry") {
			g.drawString("Name: "+jerry.getName(),350,100);
			g.drawString("Balance: "+jerry.getBalance(),350,120);
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginButton) {
			//get the string from the textField
			String pinTxt=pinInput.getText();
			//convert a string to an int
			try {
				int pin=Integer.parseInt(pinTxt);
				
				//check pin
				if(john.checkPin(pin)) {
					loggedIn="John";
					//System.out.println("John is logged in");
				}
				//System.out.println("checking pin");
				if(jen.checkPin(pin)) {
					loggedIn="Jen";
					//System.out.println("Jen is logged in");
				}
				if(jerry.checkPin(pin)) {
					loggedIn="Jerry";
				}
			}catch(Exception bad) {
				
			}
			
			
			
			//update screen
			repaint();
		}
		if(e.getSource()==withdrawButton) {
			String pinTxt=pinInput.getText();
			if(loggedIn=="John") {
				if(john.getAccess()) {
					int pin=Integer.parseInt(pinTxt);
					
					//check pin
					john.checkPin(pin);
				}
				String moneyText=money.getText();
				if(john.getAccess()) {
					//System.out.println("withdraw");
					john.withDraw(Double.parseDouble(moneyText));
				}
			}
			if(loggedIn=="Jen") {
				if(jen.getAccess()) {
					int pin=Integer.parseInt(pinTxt);
					
					//check pin
					jen.checkPin(pin);
				}
				String moneyText=money.getText();
				if(jen.getAccess()) {
					//System.out.println("withdraw");
					jen.withDraw(Double.parseDouble(moneyText));
				}
			}
			if(loggedIn=="Jerry") {
				if(jerry.getAccess()) {
					int pin=Integer.parseInt(pinTxt);
					
					//check pin
					jerry.checkPin(pin);
				}
				String moneyText=money.getText();
				if(jerry.getAccess()) {
					//System.out.println("withdraw");
					jerry.withDraw(Double.parseDouble(moneyText));
				}
			}
			
			repaint();
		}
		if(e.getSource()==depositButton) {
			String pinTxt=pinInput.getText();
			if(loggedIn=="John") {
				if(john.getAccess()) {
					int pin=Integer.parseInt(pinTxt);
					
					//check pin
					john.checkPin(pin);
				}
				String moneyText=money.getText();
				if(john.getAccess()) {
					john.deposit(Double.parseDouble(moneyText));
				}
			}
			if(loggedIn=="Jen") {
				if(jen.getAccess()) {
					int pin=Integer.parseInt(pinTxt);
					
					//check pin
					jen.checkPin(pin);
				}
				String moneyText=money.getText();
				if(jen.getAccess()) {
					jen.deposit(Double.parseDouble(moneyText));
				}
			}
			if(loggedIn=="Jerry") {
				if(jerry.getAccess()) {
					int pin=Integer.parseInt(pinTxt);
					
					//check pin
					jerry.checkPin(pin);
				}
				String moneyText=money.getText();
				if(jerry.getAccess()) {
					jerry.deposit(Double.parseDouble(moneyText));
				}
			}
			repaint();
		}
		if(e.getSource()==nameButton) {
			//System.out.println("updating name");
			/*
			String pinTxt=pinInput.getText();
			
			if(john.getAccess()) {
				int pin=Integer.parseInt(pinTxt);
				
				//check pin
				john.checkPin(pin);
			}
			*/
			String nameText=nameInput.getText();
			if(john.getAccess()) {
				//System.out.println("Updating name");
				john.updateName(nameText);
			}
			if(jen.getAccess()) {
				jen.updateName(nameText);
			}
			if(jerry.getAccess()) {
				jerry.updateName(nameText);
			}
			repaint();
		}
		if(e.getSource()==signoutButton) {
			if(loggedIn=="John") {
				john.disableAccess();
				loggedIn="";
			}
			if(loggedIn=="Jen") {
				jen.disableAccess();
				loggedIn="";
			}
			if(loggedIn=="Jerry") {
				jerry.disableAccess();
				loggedIn="";
			}
			
			repaint();
		}
	}
	
	
}
