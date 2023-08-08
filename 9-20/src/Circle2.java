
public class Circle2 {
	private double pi;
	private double radius;
	public Circle2() {
		pi=3.14;
		radius=1;
	}
	public Circle2(double radiusInput) {
		pi = 3.14;
		radius = radiusInput;
	}
	public void printArea() {
		System.out.println("Area: "+(pi*radius*radius));
	}
	public void printArea(double radiusInput) {
		System.out.println("Area: "+(pi*radiusInput*radiusInput));
	}
	public void printVol(double radiusInput) {
		System.out.println("Volume: " + (4.0/3.0 * pi * radius * radius * radius));
	}
	public void printVol(double radiusInput, double height) {
		System.out.println("Volume: "+(pi*radius*radius*height));
	}
}
