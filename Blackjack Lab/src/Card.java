
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Card {
	private int value;
	private String name;
	private String suit;
	private BufferedImage suitImage;
	
	public Card(int value,String name,String suit){
		this.value=value;
		this.name=name;
		this.suit=suit;
		if(suit.equals("Hearts")) {
			try {
				suitImage=ImageIO.read(new File("src/heartsreal.png"));
			}catch(IOException e) {
				System.out.println("could not load suit image...");
			}
		}
		if(suit.equals("Diamonds")) {
			try {
				suitImage=ImageIO.read(new File("src/diamonds2.png"));
			}catch(IOException e) {
				System.out.println("could not load suit image...");
			}
		}
		if(suit.equals("Clubs")) {
			try {
				suitImage=ImageIO.read(new File("src/clubs.png"));
			}catch(IOException e) {
				System.out.println("could not load suit image...");
			}
		}
		if(suit.equals("Spades")) {
			try {
				suitImage=ImageIO.read(new File("src/spades.png"));
			}catch(IOException e) {
				System.out.println("could not load suit image...");
			}
		}
	}
	
	public void drawMe(Graphics g,int x,int y) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 120,150);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, 120, 150);
		
		Font font=new Font("Arial",Font.PLAIN,50);
		g.setFont(font);
		if(suit.equals("Hearts") || suit.equals("Diamonds")) {
			g.setColor(Color.RED);
		}
		g.drawString(name, x+30, y+100);
		g.drawImage(suitImage, x+2,y,null);
		g.drawImage(suitImage, x+80,y,null);
		g.drawImage(suitImage, x+2,y+105,null);
		g.drawImage(suitImage, x+80,y+105,null);
	}
	public int getValue() {
		return value;
	}

}
