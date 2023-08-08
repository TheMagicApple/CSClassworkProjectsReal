import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Screen extends JPanel implements ActionListener{
	// Remember to change your frame dimensions

	// Add to your screen class 

	private JTextField songName;
	private JTextField songArtist;
	private JTextField songAlbum;
	private JButton addButton;
	private JButton deleteButton;
	private JButton randomButton;
	private JButton sortNameButton;
	private JButton sortArtistButton;
	private JButton sortAlbumButton;
	private ArrayList<JButton> deleteSongs=new ArrayList<>();
	private int yy=185;
	private MyArrayList<Song> playlist=new MyArrayList<>();
	// Add to your screen class constructor 
	public Screen() {
		playlist.add(new Song("shivers","ed sheeran","colors"));
		playlist.add(new Song("rickroll","rick astley","freedom"));
		playlist.add(new Song("i hope not","daniel","advcs classwork"));
		playlist.add(new Song("the albanian","saahil","C.O.A.L"));
		playlist.add(new Song("labs","daniel","advcs classwork"));
		
		for(int i=0;i<5;i++) {
			JButton deleteSong=new JButton("Delete");
			deleteSong.setBounds(100,yy,90,20);
			deleteSong.addActionListener(this);
			add(deleteSong);
			yy+=30;
			deleteSongs.add(deleteSong);
		}
		setLayout(null);
		songName = new JTextField("Song name...");
		songName.setFont(new Font("Arial", Font.PLAIN, 20));
		songName.setHorizontalAlignment(SwingConstants.CENTER);
		songName.setBounds(5, 9, 150, 30);
		songName.setForeground(Color.GRAY);
		songName.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (songName.getText().equals("Song name...")) {
		            songName.setText("");
		            songName.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (songName.getText().isEmpty()) {
		            songName.setForeground(Color.GRAY);
		            songName.setText("Song name...");
		        }
		    }
		    });
		this.add(songName);

		songArtist = new JTextField();
		songArtist.setFont(new Font("Arial", Font.PLAIN, 20));
		songArtist.setHorizontalAlignment(SwingConstants.CENTER);
		songArtist.setBounds(5, 50, 150, 30);
		songArtist.setText("Song artist...");
		this.add(songArtist);
		songArtist.setForeground(Color.GRAY);
		songArtist.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (songArtist.getText().equals("Song artist...")) {
		            songArtist.setText("");
		            songArtist.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (songArtist.getText().isEmpty()) {
		            songArtist.setForeground(Color.GRAY);
		            songArtist.setText("Song artist...");
		        }
		    }
		    });
		songAlbum = new JTextField("Song album...");
		songAlbum.setFont(new Font("Arial", Font.PLAIN, 20));
		songAlbum.setForeground(Color.GRAY);
		songAlbum.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (songAlbum.getText().equals("Song album...")) {
		        	songAlbum.setText("");
		        	songAlbum.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (songAlbum.getText().isEmpty()) {
		        	songAlbum.setForeground(Color.GRAY);
		        	songAlbum.setText("Song album...");
		        }
		    }
		    });
		songAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		songAlbum.setBounds(5, 90, 150, 30);
	
		this.add(songAlbum);

		addButton = new JButton();
		addButton.setFont(new Font("Arial", Font.BOLD, 15));
		addButton.setHorizontalAlignment(SwingConstants.CENTER);
		addButton.setBounds(5, 132, 70, 30);
		addButton.setText("Add");
		this.add(addButton);
		addButton.addActionListener(this);

		deleteButton = new JButton();
		deleteButton.setFont(new Font("Arial", Font.BOLD, 10));
		deleteButton.setHorizontalAlignment(SwingConstants.CENTER);
		deleteButton.setBounds(85, 132, 70, 30);
		deleteButton.setText("Delete");
		this.add(deleteButton);
		deleteButton.addActionListener(this);

		randomButton = new JButton();
		randomButton.setFont(new Font("Arial", Font.BOLD, 20));
		randomButton.setHorizontalAlignment(SwingConstants.CENTER);
		randomButton.setBounds(178, 9, 300, 30);
		randomButton.setText("Randomize");
		this.add(randomButton);
		randomButton.addActionListener(this);

		sortNameButton = new JButton();
		sortNameButton.setFont(new Font("Arial", Font.BOLD, 10));
		sortNameButton.setHorizontalAlignment(SwingConstants.CENTER);
		sortNameButton.setBounds(168, 49, 100, 30);
		sortNameButton.setText("Sort by Name");
		this.add(sortNameButton);
		sortNameButton.addActionListener(this);

		sortArtistButton = new JButton();
		sortArtistButton.setFont(new Font("Arial", Font.BOLD, 10));
		sortArtistButton.setHorizontalAlignment(SwingConstants.CENTER);
		sortArtistButton.setBounds(277, 49, 100, 30);
		sortArtistButton.setText("Sort by Artist");
		this.add(sortArtistButton);
		sortArtistButton.addActionListener(this);

		sortAlbumButton = new JButton();
		sortAlbumButton.setFont(new Font("Arial", Font.BOLD, 10));
		sortAlbumButton.setHorizontalAlignment(SwingConstants.CENTER);
		sortAlbumButton.setBounds(385, 49, 100, 30);
		sortAlbumButton.setText("Sort by Album");
		this.add(sortAlbumButton);
		sortAlbumButton.addActionListener(this);
	}
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	public void paintComponent(Graphics g) {
		yy=185;
		super.paintComponent(g);
		for(JButton deleteSong:deleteSongs) {
			deleteSong.setBounds(100,yy,90,20);
			
			yy+=30;
		}
		int x=200;
		int y=200;
		for(Song song:playlist) {
			g.drawString(song.getName(),x,y);
			y+=30;
		}
		y=200;
		x=300;
		for(Song song:playlist) {
			g.drawString(song.getArtist(),x,y);
			y+=30;
		}
		x=400;
		y=200;
		for(Song song:playlist) {
			g.drawString(song.getAlbum(),x,y);
			y+=30;
		}
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==randomButton) {
			for(int i=0;i<playlist.size();i++) {
				int index=(int)(Math.random()*playlist.size());
				Song temp=playlist.get(index);
				playlist.set(index, playlist.get(i));
				playlist.set(i, temp);
			}
		}
		else if(e.getSource()==sortNameButton) {
			for(int i=0;i<playlist.size();i++) {
				for(int k=0;k<playlist.size()-1;k++) {
					if(playlist.get(k).getName().compareTo(playlist.get(k+1).getName())>0) {
						Song temp=playlist.get(k);
						playlist.set(k, playlist.get(k+1));
						playlist.set(k+1, temp);
					}
				}
			}
		}
		else if(e.getSource()==sortArtistButton) {
			for(int i=0;i<playlist.size();i++) {
				for(int k=0;k<playlist.size()-1;k++) {
					if(playlist.get(k).getArtist().compareTo(playlist.get(k+1).getArtist())>0) {
						Song temp=playlist.get(k);
						playlist.set(k, playlist.get(k+1));
						playlist.set(k+1, temp);
					}
				}
			}
		}
		else if(e.getSource()==sortAlbumButton) {
			for(int i=0;i<playlist.size();i++) {
				for(int k=0;k<playlist.size()-1;k++) {
					if(playlist.get(k).getAlbum().compareTo(playlist.get(k+1).getAlbum())>0) {
						Song temp=playlist.get(k);
						playlist.set(k, playlist.get(k+1));
						playlist.set(k+1, temp);
					}
				}
			}
		}
		else if(e.getSource()==addButton) {
			Song song=new Song(songName.getText(),songArtist.getText(),songAlbum.getText());
			playlist.add(song);
			JButton deleteSong=new JButton("Delete");
			deleteSong.setBounds(100,yy,90,20);
			deleteSong.addActionListener(this);
			add(deleteSong);
			yy+=30;
			deleteSongs.add(deleteSong);
		}
		else if(e.getSource()==deleteButton) {
			for(int i=0;i<playlist.size();i++) {
				if(playlist.get(i).getName().equals(songName.getText())) {
					playlist.remove(i);
					remove(deleteSongs.get(i));
					deleteSongs.remove(i);
					i--;
				}
			}
		}
		else {
			//System.out.println("HELLO");
			for(int i=0;i<deleteSongs.size();i++) {
				if(e.getSource()==deleteSongs.get(i)) {
					playlist.remove(i);
					remove(deleteSongs.get(i));
					deleteSongs.remove(i);
				}
			}
		}
		repaint();
		
	}
	
}
