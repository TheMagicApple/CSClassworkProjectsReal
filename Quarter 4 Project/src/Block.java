import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Block {
	
	//private BufferedImage[] blockImages=new BufferedImage[3];
	private int blockType;
	private BufferedImage blockImage;
	
	public Block(int blockType) {
		this.blockType=blockType;
		
		try {
			blockImage=ImageIO.read(new File("src/MCBlock"+blockType+".png"));
			/*
			for(int i=0;i<blockImages.length;i++) {
				blockImages[i]=ImageIO.read(new File("src/MCBlock"+i+".png"));
			}
			*/
			
		}catch(IOException eeeeeeeeeee) {
			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		}
	}
	public void drawMe(Graphics g,int x,int y) {
		g.drawImage(blockImage, x,y,null);
	}
	public int getBlockType() {
		return blockType;
	}
}
