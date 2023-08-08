import java.awt.Dimension;
import java.awt.Font;
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
	private ArrayList<Pair<Student,Schedule>> students;
	//private boolean allNames=true;
	private Pair<Student,Schedule> selectedStudent=null;
	private JButton select1;
	private JButton select2;
	private JButton select3;
	private JTextField search;
	private JButton submit;
	private Font raleway;
	private JTextField period;
	private JTextField name;
	private JButton addClass;
	private JButton back;
	private BufferedImage bob;
	private BufferedImage joe;
	private BufferedImage carl;
	public Screen() {
		try {
			bob=ImageIO.read(new File("bob.jpg"));
			joe=ImageIO.read(new File("joe.jpg"));
			carl=ImageIO.read(new File("carl.png"));
		}catch(IOException e) {
			System.out.println("image bad");
		}
		setLayout(null);
		raleway=new Font("Raleway-Regular.ttf",Font.PLAIN,50);
		students=new ArrayList<>();
		Schedule bobS=new Schedule();
		Schedule joeS=new Schedule();
		Schedule carlS=new Schedule();
		bobS.addClass(1,"calculus");
		bobS.addClass(3, "physics");
		bobS.addClass(5,"us history");
		joeS.addClass(1, "architecture");
		joeS.addClass(2,"3d art");
		joeS.addClass(3,"ceramics");
		carlS.addClass(4, "ap cs");
		carlS.addClass(2, "adv cs");
		carlS.addClass(6,"intro to cs");
		students.add(new Pair(new Student("Bob",bob),bobS));
		students.add(new Pair(new Student("Joe",joe),joeS));
		students.add(new Pair(new Student("Carl",carl),carlS));
		select1=new JButton("Select");
		select2=new JButton("Select");
		select3=new JButton("Select");
		search=new JTextField();
		submit=new JButton("Submit");
		name=new JTextField();
		period=new JTextField();
		addClass=new JButton("Add");
		back=new JButton("Back");
		select1.setBounds(100,165,80,40);
		select2.setBounds(100,235,80,40);
		select3.setBounds(100,305,80,40);
		search.setBounds(100,50,150,40);
		submit.setBounds(270,50,80,40);
		name.setBounds(380,350,100,50);
		period.setBounds(400,300,50,40);
		addClass.setBounds(380,420,100,50);
		back.setBounds(100,400,100,50);
		add(select1);
		add(select2);
		add(select3);
		add(search);
		add(submit);
		
		select1.addActionListener(this);
		select2.addActionListener(this);
		select3.addActionListener(this);
		submit.addActionListener(this);
		addClass.addActionListener(this);
		back.addActionListener(this);
	}
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(selectedStudent==null) {
			g.setFont(raleway);
			int y=200;
			for(Pair student:students) {
				//System.out.println("HELLO?");
				g.drawString(student.getA().toString(), 200,y);
				y+=70;
			}
		}else {
			
			g.drawString("Period: ", 360,320);
			g.drawString("Name:", 335,380);
			g.setFont(raleway);
			g.drawString(selectedStudent.getA().toString(), 180,50);
			g.drawImage(selectedStudent.getA().getImage(), 360,0,null);
			ArrayList<String> schedule=selectedStudent.getB().toList();
			int y=100;
			for(String s:schedule) {
				g.drawString(s, 60, y);
				y+=50;
			}
		}
			
	}
	public void back() {
		add(select1);
		add(select2);
		add(select3);
		add(search);
		add(submit);
		remove(name);
		remove(period);
		remove(addClass);
		remove(back);
	}
	public void select() {
		remove(select1);
		remove(select2);
		remove(select3);
		remove(search);
		remove(submit);
		add(name);
		add(period);
		add(addClass);
		add(back);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==select1) {
			selectedStudent=students.get(0);
			select();
			
		}
		if(e.getSource()==select2) {
			selectedStudent=students.get(1);
			select();
		}
		if(e.getSource()==select3) {
			selectedStudent=students.get(2);
			select();
		}
		if(e.getSource()==submit) {
			String name=search.getText();
			if(name.toUpperCase().equals("BOB")) {
				selectedStudent=students.get(0);
				select();
			}else if(name.toUpperCase().equals("JOE")) {
				selectedStudent=students.get(1);
				select();
			}else if(name.toUpperCase().equals("CARL")) {
				selectedStudent=students.get(2);
				select();
			}
		}
		if(e.getSource()==addClass) {
			int p=Integer.parseInt(period.getText());
			String n=name.getText();
			Schedule s=selectedStudent.getB();
			s.addClass(p, n);
		}
		if(e.getSource()==back) {
			selectedStudent=null;
			back();
		}
		repaint();
		
	}

}
