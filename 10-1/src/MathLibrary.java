
public class MathLibrary {
	private double pi=3.14;
	public void volCylinder(double radiusInput,double height) {
		System.out.println("Cylinder Volume: " + radiusInput*radiusInput*height*pi);
	}
	public void volSphere(double radius) {
		System.out.println("Sphere volume: "+radius*radius*radius*(4.0/3.0));
	}
	public void solveQuadratic(int a,int b,int c) {
		double solution1=(b*-1+Math.sqrt(b*b-4*a*c))/2*a;
		double solution2=(b*-1-Math.sqrt(b*b-4*a*c))/2*a;
		System.out.println("X = "+solution1+" , "+solution2);
	}
    public void solvePythagorean(int a, int b) {
        double c;
        System.out.println("Side C: " + Math.sqrt(a*a + b*b));
    }
}
	

