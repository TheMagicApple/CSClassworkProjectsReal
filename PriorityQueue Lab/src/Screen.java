import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Screen extends JPanel implements ActionListener{
	private JButton nurseView;
	private JButton doctorView;
	private JButton addButton;
	private JComboBox<String> addAge;
	private JComboBox<String> addPriority;
	private JTextField addIllness;
	private JTextField addName;
	private JButton searchButton;
	private JTextField searchName;
	private JTextField searchIllness;
	private JComboBox<String> searchPriority;
	private JButton searchSave;
	private JTextField doctorNote;
	private JButton dischargeButton;
	
	MinHeap<Patient> heap;
	
	Patient searchPatient=null;
	
	Patient doctorPatient=null;
	
	MyArrayList<Patient> finishedPatients=new MyArrayList<>();
	
	int view=0;
	public Screen() {
		setLayout(null);
		nurseView = new JButton();
		nurseView.setFont(new Font("Arial", Font.BOLD, 20));
		nurseView.setHorizontalAlignment(SwingConstants.CENTER);
		nurseView.setBounds(5, 5, 200, 30);
		nurseView.setText("Nurse");
		this.add(nurseView);
		nurseView.addActionListener(this);

		doctorView = new JButton();
		doctorView.setFont(new Font("Arial", Font.BOLD, 20));
		doctorView.setHorizontalAlignment(SwingConstants.CENTER);
		doctorView.setBounds(593, 6, 200, 30);
		doctorView.setText("Doctor");
		this.add(doctorView);
		doctorView.addActionListener(this);

		addButton = new JButton();
		addButton.setFont(new Font("Arial", Font.BOLD, 20));
		addButton.setHorizontalAlignment(SwingConstants.CENTER);
		addButton.setBounds(5, 360, 200, 30);
		addButton.setText("Add");
		this.add(addButton);
		addButton.addActionListener(this);

		addPriority = new JComboBox<>(new String[] {"High", "Medium", "Low"});
		addPriority.setFont(new Font("Arial", Font.BOLD, 20));
		addPriority.setBounds(5, 315, 200, 30);
		this.add(addPriority);
		

		addAge = new JComboBox<>(new String[] {"Child", "Adult"});
		addAge.setFont(new Font("Arial", Font.BOLD, 20));
		addAge.setBounds(5, 272, 200, 30);
		this.add(addAge);
		

		addIllness = new JTextField();
		addIllness.setFont(new Font("Arial", Font.PLAIN, 12));
		addIllness.setHorizontalAlignment(SwingConstants.CENTER);
		addIllness.setBounds(5, 229, 200, 30);
		addIllness.setText("illness");
		this.add(addIllness);

		addName = new JTextField();
		addName.setFont(new Font("Arial", Font.PLAIN, 20));
		addName.setHorizontalAlignment(SwingConstants.CENTER);
		addName.setBounds(5, 190, 200, 30);
		addName.setText("Name");
		this.add(addName);

		searchButton = new JButton();
		searchButton.setFont(new Font("Arial", Font.BOLD, 20));
		searchButton.setHorizontalAlignment(SwingConstants.CENTER);
		searchButton.setBounds(591, 221, 200, 30);
		searchButton.setText("Search");
		this.add(searchButton);
		searchButton.addActionListener(this);

		searchName = new JTextField();
		searchName.setFont(new Font("Arial", Font.PLAIN, 20));
		searchName.setHorizontalAlignment(SwingConstants.CENTER);
		searchName.setBounds(590, 180, 200, 30);
		searchName.setText("Name");
		this.add(searchName);

		searchIllness = new JTextField();
		searchIllness.setFont(new Font("Arial", Font.PLAIN, 12));
		searchIllness.setHorizontalAlignment(SwingConstants.CENTER);
		searchIllness.setBounds(592, 280, 200, 30);
		searchIllness.setText("illness");
		
		searchSave = new JButton();
		searchSave.setFont(new Font("Arial", Font.BOLD, 20));
		searchSave.setHorizontalAlignment(SwingConstants.CENTER);
		searchSave.setBounds(591, 361, 200, 30);
		searchSave.setText("Save");
		searchSave.addActionListener(this);
		

		searchPriority = new JComboBox<>(new String[] {"High", "Medium", "Low"});
		searchPriority.setFont(new Font("Arial", Font.BOLD, 20));
		searchPriority.setBounds(593, 324, 200, 30);
		
		
		

		doctorNote = new JTextField();
		doctorNote.setFont(new Font("Arial", Font.PLAIN, 20));
		doctorNote.setHorizontalAlignment(SwingConstants.CENTER);
		doctorNote.setBounds(300, 286, 200, 30);
		doctorNote.setText("Doctor's Note");

		dischargeButton = new JButton();
		dischargeButton.setFont(new Font("Arial", Font.BOLD, 20));
		dischargeButton.setHorizontalAlignment(SwingConstants.CENTER);
		dischargeButton.setBounds(299, 327, 200, 30);
		dischargeButton.setText("Discharge");
		dischargeButton.addActionListener(this);
		
		heap=new MinHeap<>();
		heap.add(new Patient("Bob","Stage 4 Advanced Full Body Cancer",2,0));
		heap.add(new Patient("Carl","Stepped on a lego",0,0));
		heap.add(new Patient("Jim","COVID",1,1));

	}
	public void paintComponent(Graphics g) {
		g.setColor(new Color(240,255,255));
		g.fillRect(0, 0, 800, 400);
		g.setColor(new Color(0,0,0));
		if(view==0) {
			MyArrayList<Patient> patients=heap.toArray();
			int x=250;
			int y=250;
			for(int i=0;i<patients.size();i++) {
				g.drawString(patients.get(i).toString(),x,y);
				y+=30;
			}
		}
		if(view==1) {
			int x=600;
			int y=200;
			g.drawString("Finished:", 600, 180);
			for(int i=0;i<finishedPatients.size();i++) {
				g.drawString(finishedPatients.get(i).name+": "+finishedPatients.get(i).note,x,y);
				y+=30;
			}
			if(doctorPatient==null) {
				doctorPatient=heap.poll();
			}
			g.drawString(doctorPatient==null?"No more patients":doctorPatient.toString(),250, 200);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addButton) {
			heap.add(new Patient(addName.getText(),addIllness.getText(),addPriority.getSelectedIndex(),addAge.getSelectedIndex()));
		}
		if(e.getSource()==searchButton) {
			String searchName=this.searchName.getText();
			MyArrayList<Patient> patients=heap.toArray();
			for(int i=0;i<patients.size();i++) {
				if(patients.get(i).name.equals(searchName)) {
					searchPatient=patients.get(i);
					add(searchIllness);
					searchIllness.setText(searchPatient.illness);
					add(searchPriority);
					searchPriority.setSelectedIndex(searchPatient.priority);
					add(searchSave);
					break;
				}
			}
				
		}
		if(e.getSource()==searchSave) {
			searchPatient.illness=searchIllness.getText();
			searchPatient.priority=searchPriority.getSelectedIndex();
			heap.remove(searchPatient);
			System.out.println("REMOVED:"+heap);
			heap.add(searchPatient);
			System.out.println("ADDED:"+heap);
			searchPatient=null;
			remove(searchIllness);
			remove(searchPriority);
			remove(searchSave);
		}
		if(e.getSource()==dischargeButton) {
			doctorPatient.note=doctorNote.getText();
			finishedPatients.add(doctorPatient);
			doctorPatient=null;
		}
		if(e.getSource()==nurseView) {
			if(doctorPatient!=null) {
				heap.add(doctorPatient);
				doctorPatient=null;
			}
			add(addButton);
			add(addAge);
			add(addPriority);
			add(addIllness);
			add(addName);
			add(searchButton);
			add(searchName);
			remove(doctorNote);
			remove(dischargeButton);
			view=0;
		}
		if(e.getSource()==doctorView) {
			remove(addButton);
			remove(addAge);
			remove(addPriority);
			remove(addIllness);
			remove(addName);
			remove(searchButton);
			remove(searchName);
			add(doctorNote);
			add(dischargeButton);
			view=1;
		}
		repaint();
	}
	
	
	
	public Dimension getPreferredSize() {
		return new Dimension(800,400);
	}
}
