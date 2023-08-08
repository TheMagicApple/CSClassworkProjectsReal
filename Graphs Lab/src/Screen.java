import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Screen extends JPanel implements ActionListener{
	private int view=0;
	private JButton adminButton;
	private JButton userButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton connectButton;
	private JTextField addEmail;
	private JTextField addSchool;
	private JTextField addName;
	private JTextField addPassword;
	private JTextField connectID2;
	private JTextField connectID1;
	private JTextField removeID;
	private JTextField loginID;
	private JTextField loginPassword;
	private JTextArea textArea;
	private JButton loginButton;
	private JButton logoutButton;
	private JScrollPane scroll;
	private JButton searchButton;
	private JTextField searchField;
	private JButton connectFriendButton;
	private JButton removeFriendButton;
	private JTextField removeFriendID;

	
	private Friend currentUser;
	private Friend f1;
	private Friend f2;
	private Friend f3;
	private Friend f4;
	private Friend f5;
	Graph<Friend> graph=new Graph<>();
	public Dimension getPreferredSize() {
		return new Dimension(800,400);
	}
	public Screen() {
		graph.add(new Friend("Aidan","Mound View","aidan@gmail.com","pass123"));
		graph.add(new Friend("Bob","Mound View","bobby@gmail.com","pass123"));
		graph.add(new Friend("Carl","Mound View","karl@gmail.com","pass123"));
		graph.add(new Friend("Denny","Mound View","dennny@gmail.com","pass123"));
		graph.add(new Friend("Etan","Mound View","etan@gmail.com","pass123"));
		graph.add(new Friend("Will","University HS","william@gmail.com","pass123"));
		graph.add(new Friend("Xavier","University HS","xavier@gmail.com","pass123"));
		graph.add(new Friend("Yosef","University HS","yoosef@gmail.com","pass123"));
		graph.add(new Friend("Zach","University HS","zachary@gmail.com","pass123"));
		graph.addEdge(new Friend(0),new Friend(1));
		graph.addEdge(new Friend(0),new Friend(2));
		graph.addEdge(new Friend(1), new Friend(2));
		graph.addEdge(new Friend(1), new Friend(3));
		graph.addEdge(new Friend(2), new Friend(4));
		graph.addEdge(new Friend(3), new Friend(4));
		graph.addEdge(new Friend(5), new Friend(6));
		graph.addEdge(new Friend(6),new Friend(7));
		graph.addEdge(new Friend(6), new Friend(8));
		graph.addEdge(new Friend(7), new Friend(8));
		//System.out.println(graph);
		
		setLayout(null);
		textArea = new JTextArea();
		textArea.setSize(400,400);  
		textArea.setVisible(true);
		textArea.setEditable(false);
	    add(textArea);
	   scroll=new JScrollPane(textArea);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scroll.setBounds(270,10,280,250);
	    add(scroll);
		adminButton = new JButton();
		adminButton.setFont(new Font("Arial", Font.BOLD, 20));
		adminButton.setHorizontalAlignment(SwingConstants.CENTER);
		adminButton.setBounds(18, 16, 200, 30);
		adminButton.setText("Admin");
		this.add(adminButton);
		adminButton.addActionListener(this);

		userButton = new JButton();
		userButton.setFont(new Font("Arial", Font.BOLD, 20));
		userButton.setHorizontalAlignment(SwingConstants.CENTER);
		userButton.setBounds(583, 11, 200, 30);
		userButton.setText("User");
		this.add(userButton);
		userButton.addActionListener(this);

		addButton = new JButton();
		addButton.setFont(new Font("Arial", Font.BOLD, 20));
		addButton.setHorizontalAlignment(SwingConstants.CENTER);
		addButton.setBounds(12, 358, 200, 30);
		addButton.setText("Add");
		this.add(addButton);
		addButton.addActionListener(this);

		removeButton = new JButton();
		removeButton.setFont(new Font("Arial", Font.BOLD, 20));
		removeButton.setHorizontalAlignment(SwingConstants.CENTER);
		removeButton.setBounds(576, 358, 200, 30);
		removeButton.setText("Remove");
		this.add(removeButton);
		removeButton.addActionListener(this);

		connectButton = new JButton();
		connectButton.setFont(new Font("Arial", Font.BOLD, 20));
		connectButton.setHorizontalAlignment(SwingConstants.CENTER);
		connectButton.setBounds(290, 359, 200, 30);
		connectButton.setText("Connect");
		this.add(connectButton);
		connectButton.addActionListener(this);

		addEmail = new JTextField();
		addEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		addEmail.setHorizontalAlignment(SwingConstants.CENTER);
		addEmail.setBounds(13, 313, 200, 30);
		addEmail.setText("Email");
		this.add(addEmail);

		addSchool = new JTextField();
		addSchool.setFont(new Font("Arial", Font.PLAIN, 20));
		addSchool.setHorizontalAlignment(SwingConstants.CENTER);
		addSchool.setBounds(13, 271, 200, 30);
		addSchool.setText("School");
		this.add(addSchool);

		addName = new JTextField();
		addName.setFont(new Font("Arial", Font.PLAIN, 20));
		addName.setHorizontalAlignment(SwingConstants.CENTER);
		addName.setBounds(13, 229, 200, 30);
		addName.setText("Name");
		this.add(addName);
		
		addPassword = new JTextField();
		addPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		addPassword.setHorizontalAlignment(SwingConstants.CENTER);
		addPassword.setBounds(13, 189, 200, 30);
		addPassword.setText("Password");
		this.add(addPassword);

		connectID2 = new JTextField();
		connectID2.setFont(new Font("Arial", Font.PLAIN, 20));
		connectID2.setHorizontalAlignment(SwingConstants.CENTER);
		connectID2.setBounds(288, 318, 200, 30);
		connectID2.setText("ID 2");
		this.add(connectID2);

		connectID1 = new JTextField();
		connectID1.setFont(new Font("Arial", Font.PLAIN, 20));
		connectID1.setHorizontalAlignment(SwingConstants.CENTER);
		connectID1.setBounds(288, 275, 200, 30);
		connectID1.setText("ID 1");
		this.add(connectID1);

		removeID = new JTextField();
		removeID.setFont(new Font("Arial", Font.PLAIN, 20));
		removeID.setHorizontalAlignment(SwingConstants.CENTER);
		removeID.setBounds(575, 315, 200, 30);
		removeID.setText("ID");
		this.add(removeID);

		loginID = new JTextField();
		loginID.setFont(new Font("Arial", Font.PLAIN, 20));
		loginID.setHorizontalAlignment(SwingConstants.CENTER);
		loginID.setBounds(291, 143, 200, 30);
		loginID.setText("ID");
		
		loginPassword = new JTextField();
		loginPassword.setFont(new Font("Arial", Font.PLAIN, 20));
		loginPassword.setHorizontalAlignment(SwingConstants.CENTER);
		loginPassword.setBounds(291, 103, 200, 30);
		loginPassword.setText("Password");
		

		loginButton = new JButton();
		loginButton.setFont(new Font("Arial", Font.BOLD, 20));
		loginButton.setHorizontalAlignment(SwingConstants.CENTER);
		loginButton.setBounds(291, 183, 200, 30);
		loginButton.setText("Login");
		
		loginButton.addActionListener(this);

		logoutButton = new JButton();
		logoutButton.setFont(new Font("Arial", Font.BOLD, 20));
		logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
		logoutButton.setBounds(584, 58, 200, 30);
		logoutButton.setText("Logout");
		
		logoutButton.addActionListener(this);
		
		searchButton = new JButton();
		searchButton.setFont(new Font("Arial", Font.BOLD, 20));
		searchButton.setHorizontalAlignment(SwingConstants.CENTER);
		searchButton.setBounds(17, 358, 200, 30);
		searchButton.setText("Search");
		
		searchButton.addActionListener(this);

		searchField = new JTextField();
		searchField.setFont(new Font("Arial", Font.PLAIN, 20));
		searchField.setHorizontalAlignment(SwingConstants.CENTER);
		searchField.setBounds(18, 309, 200, 30);
		searchField.setText("Name");
		
		connectFriendButton = new JButton();
		connectFriendButton.setFont(new Font("Arial", Font.BOLD, 20));
		connectFriendButton.setHorizontalAlignment(SwingConstants.CENTER);
		connectFriendButton.setBounds(587, 310, 200, 30);
		connectFriendButton.setText("Connect");
		
		connectFriendButton.addActionListener(this);

		removeFriendButton = new JButton();
		removeFriendButton.setFont(new Font("Arial", Font.BOLD, 20));
		removeFriendButton.setHorizontalAlignment(SwingConstants.CENTER);
		removeFriendButton.setBounds(587, 356, 200, 30);
		removeFriendButton.setText("Remove");
		
		removeFriendButton.addActionListener(this);

		removeFriendID = new JTextField();
		removeFriendID.setFont(new Font("Arial", Font.PLAIN, 20));
		removeFriendID.setHorizontalAlignment(SwingConstants.CENTER);
		removeFriendID.setBounds(587, 266, 200, 30);
		removeFriendID.setText("ID");
		

		
		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(view==0) {
			textArea.setText(graph.toString());
		}
		if(view==1) {
			if(currentUser!=null) {
				int y=100;
				Iterator<Friend> friends=graph.graph.get(currentUser).toIterator();
				while(friends.hasNext()) {
					Friend friend=friends.next();
					if(friend!=null) {
						g.drawString(friend.getID()+": "+friend.getName()+" "+friend.getSchool()+" "+friend.getEmail(), 200,y);
						y+=50;
					}
				}
				if(f1!=null) {
					g.drawString(f1.getID()+": "+f1.getName()+" "+f1.getSchool()+" "+f1.getEmail(), 230,300);
				}
			}
		
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==adminButton) {
			view=0;
			remove(loginButton);
			remove(loginID);
			remove(loginPassword);
			remove(logoutButton);
			remove(searchButton);
			remove(searchField);
			remove(removeFriendID);
			remove(connectFriendButton);
			remove(removeFriendButton);
			add(addButton);
			add(removeButton);
			add(connectButton);
			add(addEmail);
			add(addSchool);
			add(addName);
			add(addPassword);
			add(connectID1);
			add(connectID2);
			add(removeID);
			add(scroll);
		}
		if(e.getSource()==userButton) {
			view=1;
			remove(addButton);
			remove(removeButton);
			remove(connectButton);
			remove(addEmail);
			remove(addSchool);
			remove(addName);
			remove(addPassword);
			remove(connectID1);
			remove(connectID2);
			remove(removeID);
			remove(scroll);
			add(loginButton);
			add(loginID);
			add(loginPassword);
		}
		if(e.getSource()==addButton) {
			graph.add(new Friend(addName.getText(),addSchool.getText(),addEmail.getText(),addPassword.getText()));
		}
		if(e.getSource()==connectButton) {
			graph.addEdge(new Friend(Integer.parseInt(connectID1.getText())), new Friend(Integer.parseInt(connectID2.getText())));
		}
		if(e.getSource()==removeButton) {
			graph.remove(new Friend(Integer.parseInt(removeID.getText())));
		}
		if(e.getSource()==loginButton) {
			Iterator<Friend> key=graph.graph.keySet().toIterator();
			while(key.hasNext()) {
				Friend friend=key.next();
				
				if(friend!=null && friend.hashCode()==Integer.parseInt(loginID.getText()) && friend.getPassword().equals(loginPassword.getText())) {
					currentUser=friend;
					remove(loginButton);
					remove(loginID);
					remove(loginPassword);
					add(logoutButton);
					add(searchButton);
					add(searchField);
					add(removeFriendID);
					add(removeFriendButton);
					add(connectFriendButton);
					break;
				}
			}
		}
		if(e.getSource()==logoutButton) {
			currentUser=null;
			add(loginButton);
			add(loginID);
			add(loginPassword);
			remove(logoutButton);
			remove(searchButton);
			remove(searchField);
			remove(removeFriendID);
			remove(connectFriendButton);
			remove(removeFriendButton);
		}
		if(e.getSource()==searchButton) {
			f1=null;
			f2=null;
			f3=null;
			f4=null;
			f5=null;
			Iterator<Friend> keySet=graph.iterator();
			while(keySet.hasNext()) {
				Friend f=keySet.next();
				if(f!=null && f.getName().equals(searchField.getText())) {
					if(f1==null) {
						f1=f;
					}else {
						if(f2==null) {
							f2=f;
						}else {
							if(f3==null) {
								f3=f;
							}else {
								if(f4==null) {
									f4=f;
								}else {
									if(f5==null) {
										f5=f;
									}else {
										System.out.println("no more friends :(");
									}
								}
							}
						}
					}
				}
			}
		}
		if(e.getSource()==connectFriendButton) {
			if(graph.dfs(currentUser, new Friend(Integer.parseInt(removeFriendID.getText())))) {
				graph.addEdge(currentUser, new Friend(Integer.parseInt(removeFriendID.getText())));
			}
		}
		if(e.getSource()==removeFriendButton) {
			graph.remove(new Friend(Integer.parseInt(removeFriendID.getText())));
		}
		
		repaint();
		
	}
	
}
