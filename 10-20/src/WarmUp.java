import java.util.Scanner;
public class WarmUp {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number between 10 and 15");
		int num=s.nextInt();
		int i=1;
		while(i<=num) {
			System.out.println(i);
			i++;
		}
		i=30;
		while(i>=num) {
			System.out.println(i);
			i--;
		}

	}

}
