import java.util.Scanner;
public class Input {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your first name:");
		String name=s.next();
		System.out.println("Hello "+name);
		System.out.println("Triangle.");
		System.out.println("Enter the height:");
		int height=s.nextInt();
		System.out.println("Enter the base:");
		int base=s.nextInt();
		double trianglearea=0.5*base*height;
		System.out.println("Area: "+trianglearea);
		System.out.println("Circle.");
		System.out.println("Enter the radius:");
		double radius=s.nextDouble();
		double circlearea=radius*radius*3.14;
		System.out.println("Area: "+circlearea);

	}

}
