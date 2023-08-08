import java.util.Scanner;
public class Runner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Bank theBank=new Bank();
		boolean done=false;
		while(done==false) {
			System.out.println("0. Done 1. View information 2. Deposit 3. Withdraw");
			int choice=s.nextInt();
			if(choice==0) {
				done=true;
			}
			if(choice==1) {
				theBank.viewInformation();
			}
			if(choice==2) {
				theBank.deposit();
			}
			if(choice==3) {
				theBank.withDraw();
			}
		}
		

	}

}
