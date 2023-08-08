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
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Screen extends JPanel implements ActionListener{
	private JButton viewAllStates;
	private JTextField stateAbbreviationFind;
	private JButton findState;
	private JTextField stateAbbreviationDelete;
	private JButton deleteState;
	private JButton addState;
	private JTextField stateSize;
	private JTextField statePopulation;
	private JTextField stateCapital;
	private JTextField stateAbbreviation;
	private JTextField stateName;
	private JButton addImage;
	private JTextField image;
	
	private MyHashMap<State,StateInfo> states=new MyHashMap<>();
	
	private boolean viewAll;
	private StateInfo viewing;
	public Screen() {
		setLayout(null);
		viewAllStates = new JButton();
		viewAllStates.setFont(new Font("Arial", Font.BOLD, 20));
		viewAllStates.setHorizontalAlignment(SwingConstants.CENTER);
		viewAllStates.setBounds(24, 23, 200, 30);
		viewAllStates.setText("View All States");
		
		this.add(viewAllStates);
		viewAllStates.addActionListener(this);

		stateAbbreviationFind = new JTextField();
		stateAbbreviationFind.setFont(new Font("Arial", Font.PLAIN, 15));
		stateAbbreviationFind.setHorizontalAlignment(SwingConstants.CENTER);
		stateAbbreviationFind.setBounds(376, 15, 200, 30);
		 stateAbbreviationFind.setForeground(Color.GRAY);
			stateAbbreviationFind.setText("State abbreviation...");
		this.add(stateAbbreviationFind);
		stateAbbreviationFind.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (stateAbbreviationFind.getText().equals("State abbreviation...")) {
		            stateAbbreviationFind.setText("");
		            stateAbbreviationFind.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (stateAbbreviationFind.getText().isEmpty()) {
		            stateAbbreviationFind.setForeground(Color.GRAY);
		            stateAbbreviationFind.setText("State abbreviation...");
		        }
		    }
		});
		

		findState = new JButton();
		findState.setFont(new Font("Arial", Font.BOLD, 20));
		findState.setHorizontalAlignment(SwingConstants.CENTER);
		findState.setBounds(377, 63, 200, 30);
		findState.setText("Find State");
		this.add(findState);
		findState.addActionListener(this);

		stateAbbreviationDelete = new JTextField();
		stateAbbreviationDelete.setFont(new Font("Arial", Font.PLAIN, 15));
		stateAbbreviationDelete.setHorizontalAlignment(SwingConstants.CENTER);
		stateAbbreviationDelete.setBounds(377, 411, 200, 30);
		 stateAbbreviationDelete.setForeground(Color.GRAY);
		stateAbbreviationDelete.setText("State abbreviation...");
		stateAbbreviationDelete.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (stateAbbreviationDelete.getText().equals("State abbreviation...")) {
		            stateAbbreviationDelete.setText("");
		            stateAbbreviationDelete.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (stateAbbreviationDelete.getText().isEmpty()) {
		            stateAbbreviationDelete.setForeground(Color.GRAY);
		            stateAbbreviationDelete.setText("State abbreviation...");
		        }
		    }
		});
		this.add(stateAbbreviationDelete);

		deleteState = new JButton();
		deleteState.setFont(new Font("Arial", Font.BOLD, 20));
		deleteState.setHorizontalAlignment(SwingConstants.CENTER);
		deleteState.setBounds(378, 456, 200, 30);
		deleteState.setText("Delete State");
		this.add(deleteState);
		deleteState.addActionListener(this);

		addState = new JButton();
		addState.setFont(new Font("Arial", Font.BOLD, 20));
		addState.setHorizontalAlignment(SwingConstants.CENTER);
		addState.setBounds(14, 457, 200, 30);
		addState.setText("Add State");
		this.add(addState);
		addState.addActionListener(this);

		stateSize = new JTextField();
		stateSize.setFont(new Font("Arial", Font.PLAIN, 15));
		stateSize.setHorizontalAlignment(SwingConstants.CENTER);
		stateSize.setBounds(15, 416, 200, 30);
		stateSize.setText("State size...");
		stateSize.setForeground(Color.gray);
		stateSize.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (stateSize.getText().equals("State size...")) {
		            stateSize.setText("");
		            stateSize.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (stateSize.getText().isEmpty()) {
		            stateSize.setForeground(Color.GRAY);
		            stateSize.setText("State size...");
		        }
		    }
		});
		this.add(stateSize);

		statePopulation = new JTextField();
		statePopulation.setFont(new Font("Arial", Font.PLAIN, 15));
		statePopulation.setHorizontalAlignment(SwingConstants.CENTER);
		statePopulation.setBounds(14, 373, 200, 30);
		statePopulation.setText("State population...");
		statePopulation.setForeground(Color.gray);
		statePopulation.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (statePopulation.getText().equals("State population...")) {
		            statePopulation.setText("");
		            statePopulation.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (statePopulation.getText().isEmpty()) {
		            statePopulation.setForeground(Color.GRAY);
		            statePopulation.setText("State population...");
		        }
		    }
		});
		this.add(statePopulation);

		stateCapital = new JTextField();
		stateCapital.setFont(new Font("Arial", Font.PLAIN, 15));
		stateCapital.setHorizontalAlignment(SwingConstants.CENTER);
		stateCapital.setBounds(14, 329, 200, 30);
		stateCapital.setText("State capital...");
		stateCapital.setForeground(Color.gray);
		stateCapital.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (stateCapital.getText().equals("State capital...")) {
		            stateCapital.setText("");
		            stateCapital.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (stateCapital.getText().isEmpty()) {
		            stateCapital.setForeground(Color.GRAY);
		            stateCapital.setText("State capital...");
		        }
		    }
		});
		this.add(stateCapital);

		stateAbbreviation = new JTextField();
		stateAbbreviation.setFont(new Font("Arial", Font.PLAIN, 15));
		stateAbbreviation.setHorizontalAlignment(SwingConstants.CENTER);
		stateAbbreviation.setBounds(13, 288, 200, 30);
		stateAbbreviation.setText("State abbreviation...");
		stateAbbreviation.setForeground(Color.gray);
		stateAbbreviation.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (stateAbbreviation.getText().equals("State abbreviation...")) {
		            stateAbbreviation.setText("");
		            stateAbbreviation.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (stateAbbreviation.getText().isEmpty()) {
		            stateAbbreviation.setForeground(Color.GRAY);
		            stateAbbreviation.setText("State abbreviation...");
		        }
		    }
		});
		this.add(stateAbbreviation);

		stateName = new JTextField();
		stateName.setFont(new Font("Arial", Font.PLAIN, 15));
		stateName.setHorizontalAlignment(SwingConstants.CENTER);
		stateName.setBounds(13, 246, 200, 30);
		stateName.setText("State name...");
		stateName.setForeground(Color.gray);
		stateName.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (stateName.getText().equals("State name...")) {
		            stateName.setText("");
		            stateName.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (stateName.getText().isEmpty()) {
		            stateName.setForeground(Color.GRAY);
		            stateName.setText("State name...");
		        }
		    }
		});
		this.add(stateName);
		
		image=new JTextField();
		image.setBounds(300,110,250,30);
		image.setFont(new Font("Arial", Font.PLAIN, 15));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		addImage=new JButton("Add Image");
		addImage.setFont(new Font("Arial", Font.PLAIN, 15));
		
		
		addImage.setHorizontalAlignment(SwingConstants.CENTER);
		addImage.setBounds(300, 146, 150, 30);
		
		addImage.addActionListener(this);
		states.put(new State("California","ca"), new StateInfo("Sacremento",40000000,400000,"https://cdn.cnn.com/cnnnext/dam/assets/170606120957-california---travel-destination---shutterstock-220315747.jpg","https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Flag_of_California.svg/1200px-Flag_of_California.svg.png"));
		states.put(new State("Colorado","co"), new StateInfo("Denver",5800000,1000000,"https://www.history.com/.image/ar_4:3%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTU3ODc5MDgzMjExMTcxMTQ1/aspen-at-twilight.jpg","https://coloradoencyclopedia.org/sites/default/files/styles/large/public/Maroon_Bells_20090928.jpg?itok=ND30sdIZ"));
		states.put(new State("Arizona","az"), new StateInfo("Phoenix",7000000,113000,"https://www.history.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTU3ODc5MDgzMjA5MDA4ODYz/grand_canyon-arizona.jpg","https://lp-cms-production.imgix.net/2021-08/GettyRF_866010860.jpg"));

	}
	public Dimension getPreferredSize() {
		return new Dimension(600,500);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D)g;
		if(viewAll) {
			Iterator i=states.keySet().toIterator();
			int y=150;
			g.setFont(new Font("Arial",Font.PLAIN,20));
			Object next=i.next();
			while(i.hasNext()) {
				if(next!=null) {
					g.drawString(next.toString(), 300, y);
					y+=30;
				}
				next=i.next();
			}
		}else {
			if(viewing!=null) {
				g.setFont(new Font("Arial",Font.PLAIN,15));
				g.drawString(viewing.toString(),250, 250);
				DLList<String> images=viewing.getImages();
				int x=250;
				for(int i=0;i<images.size();i++) {
					try {
						BufferedImage image = ImageIO.read(new URL(images.get(i)));
					    graphics2D.drawImage(image, x,300, 100, 100, null);
					    x+=100;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==viewAllStates) {
			viewAll=true;
			viewing=null;
			remove(addImage);
			remove(image);
		}
		if(e.getSource()==findState) {
			viewing=states.get(new State("",stateAbbreviationFind.getText()));
			viewAll=false;
			if(viewing!=null) {
				add(addImage);
				add(image);
			}else {
				remove(addImage);
				remove(image);
			}
		}
		if(e.getSource()==addImage) {
			viewing.addImage(image.getText());
		}
		if(e.getSource()==deleteState) {
			viewing=null;
			viewAll=false;
			remove(addImage);
			remove(image);
			states.remove(new State("",stateAbbreviationDelete.getText()));
		}
		if(e.getSource()==addState) {
			State state=new State(stateName.getText(),stateAbbreviation.getText());
			StateInfo stateInfo=new StateInfo(stateCapital.getText(),Integer.parseInt(statePopulation.getText()),Integer.parseInt(stateSize.getText()));
			states.put(state,stateInfo);
		}
		repaint();
	}
}