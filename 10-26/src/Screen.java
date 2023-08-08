import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Screen extends JPanel implements ActionListener{
	private JTextArea data;
	private HashMap<Object,Object> students=new HashMap<>();
	private JButton search;
	private JTextField idSearch;
	private Data display=null;
	private Profile display2=null;
	String[] schools= {"MVHS","LAHS","AVHS"};
	String[] allclasses= {"Algebra","Biology","US History","Spanish","Literature"};
	public Screen() throws IOException {
		File f=new File("src/names.txt");
		BufferedReader br= new BufferedReader(new FileReader(f));
		String ss;
		int id=1;
		while((ss=br.readLine())!=null) {
			String[] student=ss.split(" ");
			Profile p=new Profile(student[0],student[1],id);
			DLList<String> classes=new DLList<>();
			classes.add(allclasses[(int)(Math.random()*5)]);
			classes.add(allclasses[(int)(Math.random()*5)]);
			classes.add(allclasses[(int)(Math.random()*5)]);
			Data d=new Data(schools[(int)(Math.random()*3)],classes,id);
			id++;
			students.put(p, d);
			students.put(d, p);
		}
		setLayout(null);
		data=new JTextArea();
		data.setSize(300,300);
		data.setVisible(true);
		data.setEditable(false);
		add(data);
		JScrollPane scroll=new JScrollPane(data);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(10,10,580,300);
	    add(scroll);
	    search=new JButton("Search");
	    idSearch=new JTextField();
	    search.setBounds(100,450,100,50);
	    idSearch.setBounds(100,390,100,50);
	    add(search);
	    add(idSearch);
	    search.addActionListener(this);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Object o:students.keySet()) {
			if(o.getClass()==Profile.class) {
				Profile p=(Profile)o;
				data.append(p.toString()+"\n");
			}
		}
		if(display!=null) {
			g.setFont(new Font("Arial",Font.PLAIN,20));
			g.drawString(display.getSchool(),300,450);
			g.drawString(display.getClasses().toString(),230,500);
			g.drawString(display2.getFirst(),230,550);
		}
	}
	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			display=(Data) students.get(new Profile("","",Integer.parseInt(idSearch.getText())));
			display2=(Profile)students.get(display);
		}
		repaint();
	}
}