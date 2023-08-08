import java.util.Scanner;
public class Bank {
	private int pin=1234;
	private double balance=1999.99;
	private String name="Daniel";
	private Scanner s=new Scanner(System.in);
	private int wrong=0;
	
	public void withDraw() {
		System.out.println("Enter the pin:");
		int userPin=s.nextInt();
		if(userPin==pin) {
			System.out.println("How much do you want to withdraw?");
			double money=s.nextDouble();
			if(money>balance) {
				System.out.println("you do not have enough money in your bank account");
			}else {
				System.out.println("withdraw complete");
				balance-=money;
			}
			
		}else {
			System.out.println("incorrect pin");
			wrong+=1;
			if(wrong>=3) {
				while(true) {
					System.out.println("HACKER DETECTED.");
				}
			}
		}
	}
	public void deposit() {
		System.out.println("Enter the pin:");
		int userPin=s.nextInt();
		if(userPin==pin) {
			System.out.println("How much do you want to deposit?");
			double deposit=s.nextDouble();
			System.out.println("deposit complete");
			balance+=deposit;
		}else {
			System.out.println("incorrect pin");
			wrong+=1;
			if(wrong>=3) {
				while(true) {
					System.out.println("HACKER DETECTED.");
				}
			}
		}
	}
	public void viewInformation() {
		System.out.println("Enter the pin:");
		int userPin=s.nextInt();
		if(userPin==pin) {
			System.out.println("Name: "+name);
			System.out.println("Balance: "+balance);
		}else {
			System.out.println("incorrect pin");
			wrong+=1;
			if(wrong>=3) {
				while(true) {
					System.out.println("HACKER DETECTED.");
				}
			}
		}
	}
}
