
public class MathLibrary {
	private double pi;
	public MathLibrary() {
		pi=3.14;
	}
	public double areaCircle(double radius) {
		return radius*radius*pi;
	}
	public double volCylinder(double radius,double height) {
		return areaCircle(radius)*height;
	}
	public double volCone(double radius,double height) {
		return (areaCircle(radius)*height)/3.0;
	}
}
