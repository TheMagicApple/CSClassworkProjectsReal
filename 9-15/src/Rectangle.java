
public class Rectangle {
	private int length;
	private int width;
	public Rectangle() {
		length=0;
		width=0;
	}
	public Rectangle(int a,int b) {
		length=a;
		width=b;
	}
	public void printArea() {
		System.out.println(length*width);
	}
}
