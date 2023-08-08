import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener,Serializable{
	private MyHashTable<Country,MyImage> countries;
	private JTextArea countryList;
	private JTextField countryAbbreviation;
	private JButton search;
	private JButton left;
	private JButton right;
	private JTextField imageURL;
	private JTextField landmarkName;
	private JTextField imageAbbreviation;
	private JButton addImage;
	private JButton removeImage;
	private Country display;
	private DLList displayImages;
	private int imageViewing=0;
	public Screen() throws IOException {
		countries=new MyHashTable<>();
		BufferedReader r=new BufferedReader(new FileReader("countries.txt"));
		String s=r.readLine();
		while(s!=null) {
			countries.put(new Country(s.split(",")[1],s.split(",")[0]), -1);
			s=r.readLine();
		}
		setLayout(null);
		countries.put(new Country("","us"),new MyImage("https://hips.hearstapps.com/edc.h-cdn.co/assets/16/25/american-landmarks-mount-rushmore_1.jpg","Mt Rushmore"),new MyImage("https://www.fodors.com/wp-content/uploads/2018/11/10-Golden-Gate-Bridge.jpg","Golden Gate Bridge"),new MyImage("https://www.the-american-dream.com/assets/Uploads-EN/woman-child-usa-flag.jpg","I have no idea what this is"));
		countries.put(new Country("","fr"),new MyImage("https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg","Eiffel Tower"),new MyImage("https://i.natgeofe.com/k/54b5e731-f8d6-4a93-92e0-b7b137cac411/france-champs-elysees-paris.jpg?w=636&h=358","Paris"),new MyImage("https://european-union.europa.eu/sites/default/files/styles/ewcms_metatag_image/public/2022-02/Flag_of_France.png?itok=dFLJijgd","French Flag"));
		countries.put(new Country("","gb"), new MyImage("https://imgproxy.natucate.com/e9H97jMu4UKYa2GXXzLj3I_CZxi45elu2gAYHe-3ong/rs:fill/g:ce/w:3840/h:2160/aHR0cHM6Ly93d3cubmF0dWNhdGUuY29tL21lZGlhL3BhZ2VzL3JlaXNlemllbGUvZDM0MTBkYTMtZWM4Yi00ODM5LTgzYzYtMWNkM2M3OGNlNDgzLzMzNDU5NDYwMjEtMTU1OTY1OTM2OC9ncm9zc2JyaXRhbm5pZW4tdWstbGFlbmRlcmluZm9ybWF0aW9uZW4tYnJ1ZWNrZS10b3dlci1icmlkZ2UtbG9uZG9uLW5hdHVjYXRlLmpwZw","London"),new MyImage("https://www.destguides.com/dynamic-files/itinerary/347/background-image-4x3.jpg","Big Ben Tower"),new MyImage("https://loveincorporated.blob.core.windows.net/contentimages/gallery/b8c7260b-8c13-4944-a006-6bfa005fdbb1-Landmark_Stonehenge.jpg","Pile of rocks"));
		//save
		BufferedReader rr=new BufferedReader(new FileReader("save.txt"));
		String ss=rr.readLine();
		while(ss!=null) {
			String[] command=ss.split("~");
			//System.out.println(command[0]);
			if(command[0].equals("a")) {
				countries.put(new Country("",command[1]), new MyImage(command[2],command[3]));
			}else {
				countries.remove(new Country("",command[1]),new MyImage(command[2],command[3]));
			}
			ss=rr.readLine();
		}
		countryList= new JTextArea();
		countryList.setSize(200,200);  
		countryList.setVisible(true);
		countryList.setEditable(false);
	    add(countryList);
	    JScrollPane scroll=new JScrollPane(countryList);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(10,10,280,580);
	    add(scroll);
	    countryAbbreviation=new JTextField();
	    countryAbbreviation.setBounds(300,490,140,50);
	    countryAbbreviation.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (countryAbbreviation.getText().equals("Country abbreviation...")) {
		            countryAbbreviation.setText("");
		            countryAbbreviation.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (countryAbbreviation.getText().isEmpty()) {
		            countryAbbreviation.setForeground(Color.GRAY);
		            countryAbbreviation.setText("Country abbreviation...");
		        }
		    }
		});
	    countryAbbreviation.setForeground(Color.GRAY);
        countryAbbreviation.setText("Country abbreviation...");
	    add(countryAbbreviation);
	    search=new JButton("Search");
	    search.setBounds(320,550,100,40);
	    add(search);
	    search.addActionListener(this);
	    left=new JButton("<-");
	    right=new JButton("->");
	    left.setBounds(300,400,100,50);
	    left.setFont(new Font("Arial",Font.PLAIN,20));
	   
	    left.addActionListener(this);
	    right.setBounds(680,400,100,50);
	    right.setFont(new Font("Arial",Font.PLAIN,20));
	    right.addActionListener(this);
	    imageURL=new JTextField();
	    imageURL.setBounds(580,500,200,30);
	    
	    imageURL.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (imageURL.getText().equals("Image url...")) {
		            imageURL.setText("");
		            imageURL.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (imageURL.getText().isEmpty()) {
		            imageURL.setForeground(Color.GRAY);
		            imageURL.setText("Image url...");
		        }
		    }
		});
	    imageURL.setForeground(Color.GRAY);
        imageURL.setText("Image url...");
	    add(imageURL);
	    landmarkName=new JTextField();
	    landmarkName.setBounds(560,460,120,30);
	    
	    landmarkName.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (landmarkName.getText().equals("Image name...")) {
		            landmarkName.setText("");
		            landmarkName.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (landmarkName.getText().isEmpty()) {
		            landmarkName.setForeground(Color.GRAY);
		            landmarkName.setText("Image name...");
		        }
		    }
		});
	    landmarkName.setForeground(Color.GRAY);
        landmarkName.setText("Image name...");
	    add(landmarkName);
	    imageAbbreviation=new JTextField();
	    imageAbbreviation.setBounds(680,460,120,30);
	    imageAbbreviation.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (imageAbbreviation.getText().equals("Country abbreviation...")) {
		            imageAbbreviation.setText("");
		            imageAbbreviation.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (imageAbbreviation.getText().isEmpty()) {
		            imageAbbreviation.setForeground(Color.GRAY);
		            imageAbbreviation.setText("Country abbreviation...");
		        }
		    }
		});
	    imageAbbreviation.setForeground(Color.GRAY);
        imageAbbreviation.setText("Country abbreviation...");
	    add(imageAbbreviation);
	    addImage=new JButton("Add");
	    addImage.setBounds(580,540,200,50);
	    add(addImage);
	    addImage.addActionListener(this);
	    removeImage=new JButton("Remove Image");
	    removeImage.setBounds(440,400,200,50);
	    removeImage.addActionListener(this);
	    
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D)g;
		DLList<Country> key=countries.keySet();
		String s="";
		for(int i=0;i<key.size();i++) {
			if(countries.get((Country)key.get(i)).size()>0) {
				s+=key.get(i).toString()+" - "+countries.get((Country)key.get(i)).size()+"\n";
			}
		}
		countryList.setText(s);
		
		if(display!=null) {
			g.setFont(new Font("Arial",Font.PLAIN,20));
			g.drawString(display.getName()+" - "+display.getAbbreviation(), 300,50);
			if(countries.get(display).size()==0) {
				g.setFont(new Font("Arial",Font.PLAIN,40));
				g.drawString("no images?", 430, 300);
				remove(right);
				remove(left);
				remove(removeImage);
			}else {
				add(right);
				add(left);
				add(removeImage);
				displayImages=countries.get(display);
				try {
					BufferedImage image = ImageIO.read(new URL(((MyImage)displayImages.get(imageViewing)).getURL()));
				    graphics2D.drawImage(image, 330,80, 400, 300, null);
				    
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawString(((MyImage)displayImages.get(imageViewing)).getLandmark(), 500,50);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			DLList key=countries.keySet();
			for(int i=0;i<key.size();i++) {
				if(((Country)key.get(i)).getAbbreviation().equals(countryAbbreviation.getText())) {
					display=(Country)key.get(i);
					imageViewing=0;
					
				}
			}
		}
		if(e.getSource()==left) {
			if(imageViewing!=0) {
				imageViewing--;
			}
		}
		if(e.getSource()==right) {
			if(imageViewing<displayImages.size()-1) {
				imageViewing++;
			}
		}
		if(e.getSource()==addImage) {
			countries.put(new Country("",imageAbbreviation.getText()), new MyImage(imageURL.getText(),landmarkName.getText()));
			try {
				BufferedWriter w=new BufferedWriter(new FileWriter("save.txt"));
				w.append("a~"+imageAbbreviation.getText()+"~"+imageURL.getText()+"~"+landmarkName.getText());
				w.newLine();
				w.close();
			} catch (IOException e1) {
				System.out.println("err");
			}
		}
		if(e.getSource()==removeImage) {
			try {
				BufferedWriter w=new BufferedWriter(new FileWriter("save.txt",true));
				w.append("r~"+display.getAbbreviation()+"~"+((MyImage)displayImages.get(imageViewing)).getURL()+"~"+((MyImage)displayImages.get(imageViewing)).getLandmark());
				w.newLine();
				w.close();
			} catch (IOException e1) {
				System.out.println("err");
			}
			countries.remove(display,(MyImage)displayImages.get(imageViewing));
			
			if(imageViewing==displayImages.size()) {
				imageViewing--;
			}
		}
		repaint();
		
	}
}
