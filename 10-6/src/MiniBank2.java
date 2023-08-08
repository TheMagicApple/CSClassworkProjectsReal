
public class MiniBank2 {
	private double balance;
	private int pin;
	private boolean access;
	public MiniBank2(double balance,int pin) {
		this.balance=balance;
		this.pin=pin;
	}
	public void printBalance() {
		if(access==true) {
			System.out.println("Balance: "+balance);
		}else {
			System.out.println("Access denied.");
		}
	}
	public void setAccess(int pin) {
		if(this.pin==pin) {
			access=true;
			System.out.println("Access granted.");
		}
	}
	public void withDraw(double withDraw) {
		if(access==true) {
			balance-=withDraw;
			System.out.println("You withdrew $"+withDraw);
			printBalance();
		}else {
			System.out.println("Access denied.");
		}
		
	}
	public void deposit(double deposit) {
		if(access==true) {
			balance+=deposit;
			System.out.println("You deposited $"+deposit);
			printBalance();
		}else {
			System.out.println("Access denied.");
		}
	}
}
