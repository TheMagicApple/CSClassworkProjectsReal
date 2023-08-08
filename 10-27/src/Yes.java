import java.util.Random;
import java.util.Scanner;
public class Yes {

	public static void main(String[] args) {
		int points=20;
		Random r=new Random();
		
		Scanner s=new Scanner(System.in);
		boolean done=false;
		int i=100;
		while(i>0) {
			int n1=r.nextInt(5)+1;
			int n2=r.nextInt(5)+1;
			if(n1==5 && n2==5) {
				//System.out.println("you won 10 points!!!!!");
				points+=10;
				
			}else if(n1==n2) {
				//System.out.println("you won 3 points!!!");
				points+=3;
				
			}else if(n1>3 && n2>3) {
				//System.out.println("you won 1 point!");
				points++;
				
			}else {
				//System.out.println("you lost 1 point :(");
				points--;
				
			}
			
			//STATISTICAL PROBABILITY OF WINNING ANYTHING: 28%
			i--;
			/*
			System.out.println("you have "+points+" points.");
			System.out.println("play again??????");
			if(s.next().equals("no")) {
				done=true;
			}
			*/
			
		}
		System.out.println("you have "+points+" points.");
		
		
		

	}

}
