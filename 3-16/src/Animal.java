import java.awt.Graphics;

public class Animal {
	private String name;
	public Animal(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void speak() {
		System.out.print("Hello, my name is ");
	}
	public void drawMe(Graphics g,int x,int y) {
		g.drawRect(x, y,50,50);
	}
}
