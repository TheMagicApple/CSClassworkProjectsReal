
public class Circle {
	private double pi;
	private double radius;
	public Circle() {
		radius=0;
		pi=3.14;
	}
	public Circle(double newRadius) {
		radius=newRadius;
		pi=3.14;
	}
	public void printArea() {
		System.out.println("Area of circle: "+(pi*radius*radius));
	}
}
