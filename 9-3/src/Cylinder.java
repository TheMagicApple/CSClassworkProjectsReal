import java.util.Scanner;
public class Cylinder {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Radius:");
		double radius=s.nextDouble();
		System.out.println("Height:");
		double height=s.nextDouble();
		double pi=3.14;
		System.out.println("Volume:"+(pi*Math.pow(radius, 2)*height));	
	}

}
