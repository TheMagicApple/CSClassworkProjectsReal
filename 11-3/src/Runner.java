import java.util.Scanner;
public class Runner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		NestedLoops n=new NestedLoops();
		n.drawFilledBox();
		System.out.println("Enter width:");
		int width=s.nextInt();
		System.out.println("Enter height");
		int height=s.nextInt();
		n.drawFilledBox(height,width);
		n.drawMultiChart();
		n.drawTriangle();
		
	}

}
