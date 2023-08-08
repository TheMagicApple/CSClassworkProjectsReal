import java.util.Scanner;
public class Runner2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 3 scores.");
		double score1=s.nextInt();
		double score2=s.nextInt();
		double score3=s.nextInt();
		Grade grade=new Grade(score1,score2,score3);
		boolean pass=grade.checkPass();
		if(pass) {
			System.out.println("you passed");
		}else {
			System.out.println("you did not pass");
		}
		

	}

}
