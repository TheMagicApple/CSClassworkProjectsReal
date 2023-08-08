import java.util.Scanner;
public class Count {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n=s.nextInt();
		int i=1;
		while(i<=n) {
			System.out.println(i);
			i++;
		}
		i=1;
		do {
			System.out.println(i);
			i++;
		}while(i<=n);
		System.out.println("Enter a number that is even and less than 10.");
		int n2=s.nextInt();
		i=50;
		while(i>=n2) {
			System.out.println(i);
			i-=2;
		}
		i=50;
		do {
			System.out.println(i);
			i-=2;
		}while(i>=n2);
		

	}

}
