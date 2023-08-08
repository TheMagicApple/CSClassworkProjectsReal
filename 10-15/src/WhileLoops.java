import java.util.Scanner;
public class WhileLoops {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number greater than 20:");
		int max=s.nextInt();
		System.out.println("Enter a number to count by:");
		int count=s.nextInt();
		int x=1;
		while(x<=max) {
			System.out.println(x);
			x+=count;
		}

	}

}
