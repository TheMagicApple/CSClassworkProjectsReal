
public class MiniBank {
	private double balance;
	public MiniBank(double balance) {
		this.balance=balance;
	}
	public void printBalance() {
		System.out.println("Balance: "+balance);
	}
	public void withDraw(double withDraw) {
		balance-=withDraw;
		System.out.println("You successfully withdrew "+withDraw+" dollars from your account!");
		printBalance();
	}
	public void deposit(double deposit) {
		balance+=deposit;
		System.out.println("You successfully deposited "+deposit+" dollars into your account!");
		printBalance();
	}
}
