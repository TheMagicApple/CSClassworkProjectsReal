
public class Triangle {
	private int base;
	private int height;
	public Triangle() {
		base=0;
		height=0;
	}
	public Triangle(int a,int b) {
		base=a;
		height=b;
	}
	public void printArea() {
		System.out.println(base*height*0.5);
	}
}
