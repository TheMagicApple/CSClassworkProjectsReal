import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Program extends JPanel implements ActionListener{
	private ArrayList<MVHS> database=new ArrayList<>();
	private ArrayList<MVHS> visData=new ArrayList<>();
	private JButton onlyTeachers;
	private JButton onlyStudents;
	private JButton onlyAdmins;
	private JButton all;
	private JTextField search;
	private JButton searchButton;
	private JButton deleteButton;
	private Font mont=new Font("Montserrat-Regular.ttf",Font.PLAIN,23);
	public Program() {
		setLayout(null);
		database.add(new Teacher("Mr.Nguyen"));
		database.add(new Teacher("Mr.Henry"));
		database.add(new Student("Carl"));
		database.add(new Student("Joe"));
		database.add(new Admin("Aydmin"));
		database.add(new Admin("Robot"));
		visData=(ArrayList<MVHS>) database.clone();
		onlyTeachers=new JButton("Only Teachers");
		onlyStudents=new JButton("Only Students");
		onlyAdmins=new JButton("Only Admins");
		all=new JButton("All");
		search=new JTextField();
		searchButton=new JButton("Search");
		deleteButton=new JButton("Delete");
		onlyTeachers.setFont(mont);
		onlyStudents.setFont(mont);
		onlyAdmins.setFont(mont);
		all.setFont(mont);
		searchButton.setFont(mont);
		deleteButton.setFont(mont);
		onlyTeachers.setBackground(new Color(255, 161, 161));
		onlyStudents.setBackground(new Color(148, 219, 255));
		onlyAdmins.setBackground(new Color(158, 255, 174));
		all.setBackground(new Color(247, 179, 255));
		searchButton.setBackground(new Color(255, 236, 179));
		deleteButton.setBackground(new Color(221, 179, 255));
		onlyTeachers.setForeground(new Color(153, 0, 0));
		onlyStudents.setForeground(new Color(0, 85, 128));
		onlyAdmins.setForeground(new Color(0, 135, 22));
		all.setForeground(new Color(107, 0, 120));
		searchButton.setForeground(new Color(150, 113, 0));
		deleteButton.setForeground(new Color(83, 0, 150));
		onlyTeachers.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 0)));
		onlyStudents.setBorder(BorderFactory.createLineBorder(new Color(0, 85, 128)));
		onlyAdmins.setBorder(BorderFactory.createLineBorder(new Color(0, 135, 22)));
		all.setBorder(BorderFactory.createLineBorder(new Color(107, 0, 120)));
		searchButton.setBorder(BorderFactory.createLineBorder(new Color(150, 113, 0)));
		deleteButton.setBorder(BorderFactory.createLineBorder(new Color(83, 0, 150)));
		onlyTeachers.setBounds(70,300,180,50);
		onlyStudents.setBounds(270,300,180,50);
		onlyAdmins.setBounds(70,370,180,50);
		all.setBounds(270,370,180,50);
		search.setBounds(100,20,200,50);
		searchButton.setBounds(350,20,110,50);
		deleteButton.setBounds(40,90,100,50);
		add(onlyTeachers);
		add(onlyStudents);
		add(onlyAdmins);
		add(all);
		add(search);
		add(searchButton);
		onlyTeachers.addActionListener(this);
		onlyStudents.addActionListener(this);
		onlyAdmins.addActionListener(this);
		all.addActionListener(this);
		searchButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y=115;
		g.setFont(mont);
		for(MVHS m:visData) {
			g.drawString(m.toString(), 170,y);
			y+=30;
		}
		if(visData.size()==0) {
			g.drawString("no results", 200,100);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==onlyTeachers) {
			visData.clear();
			for(MVHS m:database) {
				if(m.getRole().equals("teacher")) {
					visData.add(m);
				}
			}
			remove(deleteButton);
		}
		if(e.getSource()==onlyStudents) {
			visData.clear();
			for(MVHS m:database) {
				if(m.getRole().equals("student")) {
					visData.add(m);
				}
			}
			remove(deleteButton);
		}
		if(e.getSource()==onlyAdmins) {
			visData.clear();
			for(MVHS m:database) {
				if(m.getRole().equals("admin")) {
					visData.add(m);
				}
			}
			remove(deleteButton);
		}
		if(e.getSource()==all) {
			visData.clear();
			visData=(ArrayList<MVHS>)database.clone();
			remove(deleteButton);
		}
		if(e.getSource()==searchButton) {
			visData.clear();
			String name=search.getText();
			for(MVHS m:database) {
				if(m.getName().equals(name)) {
					visData.add(m);
					add(deleteButton);
				}
			}
		}
		if(e.getSource()==deleteButton) {
			database.remove(visData.get(0));
			visData=(ArrayList<MVHS>)database.clone();
			remove(deleteButton);
		}
		repaint();
	}
}