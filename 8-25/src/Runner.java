import java.util.Scanner;

public class Runner {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter in a number to convert to binary.");
		int number = sc.nextInt();
		int remainder = 0;
		int result = 0;
	
		int a=32768;
		for(int i=0;i<16;i++) {
			
			result = number/a; 
			if( result > 0 ){
				System.out.print(1);
				number=number-a;
			} else {
				System.out.print(0);
				
			}
			a=a/2;
		}
		

	}
}

