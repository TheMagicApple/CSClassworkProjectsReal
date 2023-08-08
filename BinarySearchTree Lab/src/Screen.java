import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Screen extends JPanel implements ActionListener{
	private JButton adminButton;
	private JButton userButton;
	private JButton addButton;
	private JTextField balanceInput;
	private JTextField pinloginInput;
	private JTextField lastnameInput;
	private JTextField firstnameInput;
	private JButton searchButton;
	private JTextField lastnamesearchInput;
	private JTextField firstnamesearchInput;
	private JButton deleteButton;
	private JButton loginButton;
	private JTextField pinInput;
	private JTextField lastnameloginInput;
	private JTextField firstnameloginInput;
	private JTextField amountInput;
	private JButton withdrawButton;
	private JButton depositButton;
	private JButton logoutButton;
	private JTextArea accounts;
	private JScrollPane scroll;
	private BinarySearchTree<Account> bank=new BinarySearchTree<>();
	
	private Account viewing;
	private Account searching;
	
	private int passes=-1;
	public Screen() throws FileNotFoundException {
		Scanner s=new Scanner(new File("names.txt"));
		while(s.hasNextLine()) {
			String name=s.nextLine();
			String[] parts=name.split(",");
			bank.add(new Account(parts[1],parts[0],(int)(Math.random()*10000),(int)(Math.random()*100000)));
			
		}
		bank.add(new Account("Joe","Mama",123,0.0f));
		
		setLayout(null);
		
		adminButton = new JButton();
		adminButton.setFont(new Font("Arial", Font.BOLD, 20));
		adminButton.setHorizontalAlignment(SwingConstants.CENTER);
		adminButton.setBounds(5, 5, 200, 30);
		adminButton.setText("Admin");
		this.add(adminButton);
		adminButton.addActionListener(this);

		userButton = new JButton();
		userButton.setFont(new Font("Arial", Font.BOLD, 20));
		userButton.setHorizontalAlignment(SwingConstants.CENTER);
		userButton.setBounds(593, 5, 200, 30);
		userButton.setText("User");
		this.add(userButton);
		userButton.addActionListener(this);
		
		accounts = new JTextArea();
		accounts.setSize(200,400);  
		accounts.setVisible(true);
		accounts.setEditable(false);
	    add(accounts);
	    scroll=new JScrollPane(accounts);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(250,10,280,250);
	    add(scroll);

		addButton = new JButton();
		addButton.setFont(new Font("Arial", Font.BOLD, 20));
		addButton.setHorizontalAlignment(SwingConstants.CENTER);
		addButton.setBounds(586, 355, 200, 30);
		addButton.setText("Add");
		this.add(addButton);
		addButton.addActionListener(this);

		balanceInput = new JTextField();
		balanceInput.setFont(new Font("Arial", Font.PLAIN, 20));
		balanceInput.setHorizontalAlignment(SwingConstants.CENTER);
		balanceInput.setBounds(586, 310, 200, 30);
		balanceInput.setText("Balance");
		this.add(balanceInput);

		pinInput = new JTextField();
		pinInput.setFont(new Font("Arial", Font.PLAIN, 20));
		pinInput.setHorizontalAlignment(SwingConstants.CENTER);
		pinInput.setBounds(585, 267, 200, 30);
		pinInput.setText("Pin");
		this.add(pinInput);

		lastnameInput = new JTextField();
		lastnameInput.setFont(new Font("Arial", Font.PLAIN, 20));
		lastnameInput.setHorizontalAlignment(SwingConstants.CENTER);
		lastnameInput.setBounds(585, 226, 200, 30);
		lastnameInput.setText("Last Name");
		this.add(lastnameInput);

		firstnameInput = new JTextField();
		firstnameInput.setFont(new Font("Arial", Font.PLAIN, 20));
		firstnameInput.setHorizontalAlignment(SwingConstants.CENTER);
		firstnameInput.setBounds(585, 186, 200, 30);
		firstnameInput.setText("First Name");
		this.add(firstnameInput);

		searchButton = new JButton();
		searchButton.setFont(new Font("Arial", Font.BOLD, 20));
		searchButton.setHorizontalAlignment(SwingConstants.CENTER);
		searchButton.setBounds(10, 359, 200, 30);
		searchButton.setText("Search");
		this.add(searchButton);
		searchButton.addActionListener(this);

		lastnamesearchInput = new JTextField();
		lastnamesearchInput.setFont(new Font("Arial", Font.PLAIN, 20));
		lastnamesearchInput.setHorizontalAlignment(SwingConstants.CENTER);
		lastnamesearchInput.setBounds(11, 311, 200, 30);
		lastnamesearchInput.setText("Last Name");
		this.add(lastnamesearchInput);

		firstnamesearchInput = new JTextField();
		firstnamesearchInput.setFont(new Font("Arial", Font.PLAIN, 20));
		firstnamesearchInput.setHorizontalAlignment(SwingConstants.CENTER);
		firstnamesearchInput.setBounds(10, 271, 200, 30);
		firstnamesearchInput.setText("First Name");
		this.add(firstnamesearchInput);

		deleteButton = new JButton();
		deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
		deleteButton.setHorizontalAlignment(SwingConstants.CENTER);
		deleteButton.setBounds(298, 343, 200, 30);
		deleteButton.setText("Delete");
		//this.add(deleteButton);
		deleteButton.addActionListener(this);
		
		loginButton = new JButton();
		loginButton.setFont(new Font("Arial", Font.BOLD, 20));
		loginButton.setHorizontalAlignment(SwingConstants.CENTER);
		loginButton.setBounds(19, 338, 200, 30);
		loginButton.setText("Login");
		
		loginButton.addActionListener(this);

		pinloginInput = new JTextField();
		pinloginInput.setFont(new Font("Arial", Font.PLAIN, 20));
		pinloginInput.setHorizontalAlignment(SwingConstants.CENTER);
		pinloginInput.setBounds(18, 293, 200, 30);
		pinloginInput.setText("Pin");
		

		lastnameloginInput = new JTextField();
		lastnameloginInput.setFont(new Font("Arial", Font.PLAIN, 20));
		lastnameloginInput.setHorizontalAlignment(SwingConstants.CENTER);
		lastnameloginInput.setBounds(17, 253, 200, 30);
		lastnameloginInput.setText("Last Name");
		

		firstnameloginInput = new JTextField();
		firstnameloginInput.setFont(new Font("Arial", Font.PLAIN, 20));
		firstnameloginInput.setHorizontalAlignment(SwingConstants.CENTER);
		firstnameloginInput.setBounds(16, 213, 200, 30);
		firstnameloginInput.setText("First Name");
		

		amountInput = new JTextField();
		amountInput.setFont(new Font("Arial", Font.PLAIN, 20));
		amountInput.setHorizontalAlignment(SwingConstants.CENTER);
		amountInput.setBounds(586, 276, 200, 30);
		amountInput.setText("Amount");
	

		withdrawButton = new JButton();
		withdrawButton.setFont(new Font("Arial", Font.BOLD, 20));
		withdrawButton.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawButton.setBounds(585, 319, 200, 30);
		withdrawButton.setText("Withdraw");
		
		withdrawButton.addActionListener(this);

		depositButton = new JButton();
		depositButton.setFont(new Font("Arial", Font.BOLD, 20));
		depositButton.setHorizontalAlignment(SwingConstants.CENTER);
		depositButton.setBounds(586, 358, 200, 30);
		depositButton.setText("Deposit");
		
		depositButton.addActionListener(this);

		logoutButton = new JButton();
		logoutButton.setFont(new Font("Arial", Font.BOLD, 20));
		logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
		logoutButton.setBounds(314, 120, 200, 30);
		logoutButton.setText("Log Out");
		
		logoutButton.addActionListener(this);

	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,400);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		accounts.setText(bank.toString());
		if(viewing!=null) {
			g.drawString("Name: "+viewing.firstName+" "+viewing.lastName,300,250);
			g.drawString("Balance: "+viewing.balance, 300, 300);
		}
		if(searching!=null) {
			g.drawString("Name: "+searching.firstName+" "+searching.lastName,300,280);
			g.drawString("Balance: "+searching.balance, 300, 300);
			g.drawString("Pin: "+searching.pin,300,320);
		}
		if(passes!=-1) {
			g.setFont(new Font("Arial",Font.PLAIN,30));
			g.drawString("PASSES: "+passes, 600,100);
			//System.out.println(passes);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==userButton) {
			add(loginButton);
			add(pinloginInput);
			add(firstnameloginInput);
			add(lastnameloginInput);
			remove(addButton);
			remove(balanceInput);
			remove(pinInput);
			remove(firstnameInput);
			remove(lastnameInput);
			remove(firstnamesearchInput);
			remove(lastnamesearchInput);
			remove(searchButton);
			remove(deleteButton);
			remove(scroll);
			searching=null;
			passes=-1;
		}
		if(e.getSource()==adminButton) {
			remove(loginButton);
			remove(pinloginInput);
			remove(firstnameloginInput);
			remove(lastnameloginInput);
			remove(withdrawButton);
			remove(depositButton);
			remove(amountInput);
			add(addButton);
			add(balanceInput);
			add(pinInput);
			add(firstnameInput);
			add(lastnameInput);
			add(firstnamesearchInput);
			add(lastnamesearchInput);
			add(searchButton);
			
			add(scroll);
			passes=-1;
		}
		if(e.getSource()==loginButton) {
			if(bank.contains(new Account(firstnameloginInput.getText(),lastnameloginInput.getText(),Integer.parseInt(pinloginInput.getText()),0)).data.pin==Integer.parseInt(pinloginInput.getText())) {
				viewing=bank.contains(new Account(firstnameloginInput.getText(),lastnameloginInput.getText(),Integer.parseInt(pinloginInput.getText()),0)).data;
				add(withdrawButton);
				add(depositButton);
				add(amountInput);
				add(logoutButton);
				passes=bank.getPasses();
			}
		}
		if(e.getSource()==withdrawButton) {
			viewing.balance-=Float.parseFloat(amountInput.getText());
			if(viewing.balance<0) {
				viewing.balance=0;
			}
		}
		if(e.getSource()==depositButton) {
			viewing.balance+=Float.parseFloat(amountInput.getText());
		}
		if(e.getSource()==logoutButton) {
			viewing=null;
			remove(withdrawButton);
			remove(depositButton);
			remove(amountInput);
			remove(logoutButton);
			pinloginInput.setText(null);
		}
		if(e.getSource()==searchButton) {
			if(bank.contains(new Account(firstnamesearchInput.getText(),lastnamesearchInput.getText(),0,0))!=null) {
				searching=bank.contains(new Account(firstnamesearchInput.getText(),lastnamesearchInput.getText(),0,0)).data;
				add(deleteButton);
				passes=bank.getPasses();
			}
		}
		if(e.getSource()==deleteButton) {
			bank.remove(searching);
			searching=null;
			remove(deleteButton);
		}
		if(e.getSource()==addButton) {
			passes=bank.add(new Account(firstnameInput.getText(),lastnameInput.getText(),Integer.parseInt(pinInput.getText()),Float.parseFloat(balanceInput.getText())));
			
		}
		repaint();
	}
}