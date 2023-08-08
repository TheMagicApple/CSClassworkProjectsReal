import java.awt.Graphics;

public class Dog extends Animal{
	public Dog(String name) {
		super(name);
	}
	public void printInfo() {
		super.speak();
		System.out.println(super.getName());
		System.out.print("I make the sound ");
		this.speak();
	}
	public void speak() {
		System.out.println("woof");
	}
	public void drawMe(Graphics g,int x,int y) {
		super.drawMe(g, x, y);
		g.drawOval(x+30, y-20, 30, 30);
	}
}
