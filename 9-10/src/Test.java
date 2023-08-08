import java.util.Scanner;
public class Test {
	private double pi=0;
	private int radius=0;
	public void setVariables() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the radius:");
		radius=s.nextInt();
		pi=3.14;
	}
	public void printCircumference() {
		double circumference=radius*2*pi;
		System.out.println("Circumference: "+circumference);
	}
}
