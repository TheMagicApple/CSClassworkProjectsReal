import java.awt.Graphics;
import java.util.*;


public class Bird extends Animal{
	private String name;
	public Bird(String name) {
		super(name);
	}
    public void speak(){
        System.out.println("Tweet");
    }
    public void printInfo(){
        super.speak();
        System.out.println(super.getName());
        System.out.print("I make the sound ");
        this.speak();
    }
    public void drawMe(Graphics g, int x, int y){
        super.drawMe(g, x, y);
        g.fillOval(x+10, y+10, 50, 25);
    }

}
