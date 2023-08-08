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
	private Contact[] contacts;
	
	private JTextField search;
	private JTextField firstNameInput;
	private JTextField lastNameInput;
	private JTextField emailInput;
	
	private JButton firstName;
	private JButton lastName;
	private JButton username;
	private JButton domainName;
	private JButton domainExtension;
	
	private JButton addUser;
	
	private boolean searched=false;
	private int[] show=new int[10];
	public Screen() {
		for(int i=0;i<show.length;i++) {
			show[i]=-1;
		}
		setLayout(null);
		contacts=new Contact[10];
		contacts[0]=new Contact("Rick","Astley","ricka@roll.com");
		contacts[1]=new Contact("Susan","Wong","sus@gmail.com");
		contacts[2]=new Contact("Burger","King","bk@burgerking.edu");
		contacts[3]=new Contact("Runner","Main","runner@java.net");
		contacts[4]=new Contact("Notia","Susanie","notsus@gmail.net");
		contacts[5]=null;
		contacts[6]=null;
		contacts[7]=null;
		contacts[8]=null;
		contacts[9]=null;
		
		search=new JTextField();
		firstNameInput=new JTextField();
		lastNameInput=new JTextField();
		emailInput=new JTextField();
		search.setBounds(250,400,300,50);
		firstNameInput.setBounds(25,50,75,50);
		lastNameInput.setBounds(125,50,75,50);
		emailInput.setBounds(25,125,175,50);
		add(search);
		add(lastNameInput);
		add(firstNameInput);
		add(emailInput);
		
		firstName=new JButton("First Name");
		lastName=new JButton("Last Name");
		username=new JButton("Username");
		domainName=new JButton("Domain Name");
		domainExtension=new JButton("Domain Extension");
		firstName.setBounds(25,500,100,40);
		lastName.setBounds(175,500,100,40);
		username.setBounds(325,500,100,40);
		domainName.setBounds(450,500,150,40);
		domainExtension.setBounds(625,500,150,40);
		add(firstName);
		add(lastName);
		add(username);
		add(domainName);
		add(domainExtension);
		firstName.addActionListener(this);
		lastName.addActionListener(this);
		username.addActionListener(this);
		domainName.addActionListener(this);
		domainExtension.addActionListener(this);
		
		addUser=new JButton("Add contact");
		addUser.setBounds(50,200,130,40);
		add(addUser);
		addUser.addActionListener(this);
		
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Search", 370,470);
		g.drawString("Contact list:", 575,20);
		for(int i=0;i<contacts.length;i++) {
			if(contacts[i]!=null) {
				g.drawString(contacts[i].toString(), 550, 40+(i*20));
			}
		}
		g.drawString("Search results:", 300, 180);
		for(int i=0;i<show.length;i++) {
			if(show[i]!=-1) {
				g.drawString(contacts[show[i]].toString(), 300, 200+(i*25));
			}else if(i==0 && searched==true) {
				g.drawString("no results?????????", 300,200);
			}
		}
		g.drawString("First name:", 25,35);
		g.drawString("Last name:", 125,35);
		g.drawString("Email:", 85,115);
	}
	public void actionPerformed(ActionEvent e) {
		searched=true;
		for(int i=0;i<show.length;i++) {
			show[i]=-1;
		}
		if(e.getSource()==firstName) {
			for(int i=0;i<contacts.length;i++) {
				if(contacts[i]!=null){
					if(contacts[i].getFirstName().toLowerCase().equals(search.getText().toLowerCase())) {
						for(int k=0;k<show.length;k++) {
							if(show[k]==-1) {
								show[k]=i;
								break;
							}
						}	
					}
				}
					
			}
			repaint();
		}
		if(e.getSource()==lastName) {
			for(int i=0;i<contacts.length;i++) {
				if(contacts[i]!=null) {
					if(contacts[i].getLastName().toLowerCase().equals(search.getText().toLowerCase())) {
						for(int k=0;k<show.length;k++) {
							if(show[k]==-1) {
								show[k]=i;
								break;
							}
						}	
					}
				}
				
			}
			repaint();
		}
		if(e.getSource()==username) {
			for(int i=0;i<contacts.length;i++) {
				if(contacts[i]!=null) {
					if(contacts[i].getUsername().toLowerCase().equals(search.getText().toLowerCase())) {
						for(int k=0;k<show.length;k++) {
							if(show[k]==-1) {
								show[k]=i;
								break;
							}
						}	
					}
				}
				
			}
			repaint();
		}
		if(e.getSource()==domainName) {
			for(int i=0;i<contacts.length;i++) {
				if(contacts[i]!=null) {
					if(contacts[i].getDomainName().toLowerCase().equals(search.getText().toLowerCase())) {
						for(int k=0;k<show.length;k++) {
							if(show[k]==-1) {
								show[k]=i;
								break;
							}
						}	
					}
				}
				
			}
			repaint();
		}
		if(e.getSource()==domainExtension) {
			for(int i=0;i<contacts.length;i++) {
				if(contacts[i]!=null) {
					if(contacts[i].getDomainExtension().toLowerCase().equals(search.getText().toLowerCase())) {
						for(int k=0;k<show.length;k++) {
							if(show[k]==-1) {
								show[k]=i;
								break;
							}
						}	
					}
				}
				
			}
			repaint();
		}
		if(e.getSource()==addUser) {
			searched=false;
			for(int i=5;i<contacts.length;i++) {
				if(contacts[i]==null) {
					contacts[i]=new Contact(firstNameInput.getText(),lastNameInput.getText(),emailInput.getText());
					break;
				}
			}
			repaint();
			
		}
	}
}
