import java.util.Scanner;
public class AgeCalculator {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int currentYear=2021;
		System.out.println("Put in your birth year");
		int birthYear=s.nextInt();
		System.out.println("You are about "+(currentYear-birthYear)+" years old.");

	}

}
