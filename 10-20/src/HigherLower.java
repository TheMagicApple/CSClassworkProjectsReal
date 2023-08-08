import java.util.Random;
import java.util.Scanner;
public class HigherLower {

	public static void main(String[] args) {
		boolean done=false;
		Random r=new Random();
		Scanner s=new Scanner(System.in);
		int theNumber=r.nextInt(999)+1;
		int help=0;
		while(!done) {
			
			if(help==0) {
				System.out.println("Enter a number");
			}
			if(help==-1) {
				System.out.println("Enter a higher number: ");
			}
			if(help==1) {
				System.out.println("Enter a lower number: ");
			}
			int guess=s.nextInt();
			if(guess<theNumber) {
				help=-1;
			}
			if(guess>theNumber) {
				help=1;
			}
			if(guess==theNumber) {
				System.out.println("wow you did it");
				done=true;
				
			}
		}

	}

}
