
public class Radius {
	private double pi=3.14;
	public void printArea(double radius) {
		System.out.println("Area: "+(pi*radius*radius));
	}
	public void printCir(double radius) {
		System.out.println("Circumference: "+(pi*radius*2));
	}
	public void printConeVol(double radius,double height) {
		System.out.println("Volume of cone: "+(pi*radius*radius*height*(1.0/3.0)));
	}
}
