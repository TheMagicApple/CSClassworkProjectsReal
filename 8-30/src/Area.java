import java.util.Scanner;
public class Area {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter length:");
		int length=s.nextInt();
		System.out.println("Enter width:");
		double width=s.nextDouble();
		System.out.println("Length:"+length);
		System.out.println("Width:"+width);
		double area=length*width;
		System.out.println("Area:"+area);
	}

}