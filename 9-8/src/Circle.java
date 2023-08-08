import java.util.Scanner;
public class Circle {
	double pi=3.14;
	double radius=0;
	public void setRadius() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a new radius");
		radius=s.nextInt();
		
	}
	public void printArea() {
		System.out.println("Circle Area: "+(pi*radius*radius));
	}
}
