import java.util.Scanner;
public class DoWhile {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num=s.nextInt();
		if(num>0) {
			int i=1;
			do {
				System.out.println(i);
				i++;
			}while(i<=num);
		}
		if(num<0) {
			int i=-1;
			do {
				System.out.println(i);
				i--;
			}while(i>=num);
		}

	}

}