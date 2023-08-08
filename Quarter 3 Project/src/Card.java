import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Card {

   private int value;
   private String name;
   private String suit;
   private BufferedImage suitImage; 
   private BufferedImage cardImage;

   public Card(int value, String name, String suit){
		this.value = value;
		this.name = name;
		this.suit = suit;
		if(suit==null) {
			
		}else {
		
		
			if( suit.equals("hearts") ){
				try{
					suitImage = ImageIO.read(new File("src/heartsrealreal.png"));
					
				} catch (IOException e) {}
			}
			if(suit.equals("diamonds")) {
				try{
					suitImage = ImageIO.read(new File("src/diamondrealrealreal.png"));
					
				} catch (IOException e) {}
			}
			if(suit.equals("spades")) {
				try{
					suitImage = ImageIO.read(new File("src/spadesreal.png"));
					
				} catch (IOException e) {}
			}
			if(suit.equals("clubs")) {
				try{
					suitImage = ImageIO.read(new File("src/clubsreal.png"));
					
				} catch (IOException e) {}
			}
		}
		try {
			cardImage=ImageIO.read(new File("src/cardreal.png"));
		}catch(IOException e) {
			System.out.println("could not load card image");
		}
	 }

	 public int getValue(){
      return this.value;
   }

	 public void drawMe(Graphics g, int x, int y){
      g.setColor(Color.white);
      //g.fillRect(x,y,120,150);
      g.drawImage(cardImage, x-60, y-50, null);
      g.setColor(Color.black);
      //g.drawRect(x,y,120,150);
      
      //draw suit
      if(suit.equals("hearts")) {
    	  g.drawImage(suitImage, x+2, y, null);
          g.drawImage(suitImage, x+2,y+85,null);
          g.drawImage(suitImage, x+45, y, null);
          g.drawImage(suitImage, x+45,y+85,null);
      }else if(suit.equals("diamonds")) {
    	  g.drawImage(suitImage, x-15, y-15, null);
          g.drawImage(suitImage, x-15,y+70,null);
          g.drawImage(suitImage, x+35, y-15, null);
          g.drawImage(suitImage, x+35,y+70,null);
      }else if(suit.equals("spades")) {
    	  g.drawImage(suitImage, x+2, y, null);
          g.drawImage(suitImage, x+2,y+85,null);
          g.drawImage(suitImage, x+45, y, null);
          g.drawImage(suitImage, x+45,y+85,null);
      }else if(suit.equals("clubs")) {
    	  g.drawImage(suitImage, x+5, y, null);
          g.drawImage(suitImage, x+5,y+85,null);
          g.drawImage(suitImage, x+50, y, null);
          g.drawImage(suitImage, x+50,y+85,null);
      }
      
	   
      //Set Font to use with drawString   
      Font font = new Font("Arial", Font.PLAIN, 50);
      g.setFont(font);

			if( this.suit.equals("hearts") || this.suit.equals("diamonds")){
				g.setColor(Color.red);
			}
      
      if(this.name.equals("10")) {
    	  g.drawString(this.name+"", x+25, y + 85);
      }else {
    	  g.drawString(this.name+"", x+40, y + 85);
      }
      
      
      
   }
	 public void drawMeHidden(Graphics g, int x, int y){
	      g.setColor(Color.white);
	      //g.fillRect(x,y,120,150);
	     
	      g.drawImage(cardImage, x-60, y-50, null);
	      g.setColor(Color.black);
	      //g.fillRect(x,y,120,150);
	      
	      //draw suit
	      /*
	      g.drawImage(suitImage, x+2, y, null);
	      g.drawImage(suitImage, x+2,y+85,null);
	      g.drawImage(suitImage, x+45, y, null);
	      g.drawImage(suitImage, x+45,y+85,null);
		   */
	      //Set Font to use with drawString   
	      Font font = new Font("Arial", Font.PLAIN, 50);
	      g.setFont(font);

				
	      
	      //g.setColor(Color.white);
	      g.drawString("?", x+40, y + 85);
	      
	      
	   }
   
}