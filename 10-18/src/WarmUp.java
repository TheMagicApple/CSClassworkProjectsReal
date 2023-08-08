import java.util.Scanner;
public class WarmUp {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num=s.nextInt();
		for(int i=0;i<num;i++) {
			System.out.println("******");
		}
		System.out.println("Enter a number greater than 1: ");
		int num2=s.nextInt();
		int total=0;
		for(int i=0;i<=num2;i++) {
			total+=i;
		}
		System.out.println("Total: "+total);
		

	}

}
