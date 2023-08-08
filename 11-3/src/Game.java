
public class Game {
	private int slot1;
	private int slot2;
	private int slot3;
	private int balance;
	private String message;
	public Game() {
		slot1=0;
		slot2=0;
		slot3=0;
		balance=20;
		message="";
	}
	public void spin() {
		balance-=1;
		
		slot1 = (int)(Math. random()*9+1);
		slot2 = (int)(Math. random()*9+1);
		slot3 = (int)(Math. random()*9+1);
		System.out.print(slot1+" "+slot2+" "+slot3);
		System.out.println();
		balance+=getResult();
	}
	public int getResult() {
		if(slot1==7 && slot2==7 && slot3==7) {
			message="WINNER!!!!!!!!!! 100 TOKENS!!!!!";
			return 100;
		}else if(slot1==slot2 && slot1==slot3) {
			message="You won 10 tokens!!";
			return 10;
		}else if(slot1==slot2 || slot1==slot3 || slot2==slot3) {
			message="You won 2 tokens!";
			return 2;
		}else {
			message="You won nothing!";
			return 0;
		}
	}
	public String getMessage() {
		return message;
	}
	public int getBalance() {
		return balance;
	}
}
