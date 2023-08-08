import java.util.Scanner;
public class MathLibraryRunner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		MathLibrary m=new MathLibrary();
		System.out.println("Enter the radius:");
		System.out.println("Circle area: "+m.areaCircle(s.nextDouble()));
		System.out.println("Enter the radius and the height");
		double radius=s.nextDouble();
		double height=s.nextDouble();
		System.out.println("Cylinder volume: "+m.volCylinder(radius, height));
		System.out.println("Cone volume: "+m.volCone(radius, height));
		
	}

}
