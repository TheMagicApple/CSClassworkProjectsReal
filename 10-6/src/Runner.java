
public class Runner {

	public static void main(String[] args) {
		MiniBank2 bank=new MiniBank2(100,1234);
		bank.printBalance();
		bank.setAccess(1234);
		bank.printBalance();
		bank.deposit(1);
		bank.withDraw(100);

	}

}
