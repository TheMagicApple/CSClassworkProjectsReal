package Bank;

import java.awt.Graphics;

public class AccountManager {
	private Account[] account;
	public AccountManager() {
		account=new Account[3];
		account[0]=new Account("John",1234,10.10);
		account[1]=new Account("Jen",1111,99.99);
		account[2]=new Account("Jay",4321,11.11);
	}
	public void printInfo() {
		for(Account a:account) {
			System.out.println(a.toString());
		}
	}
	public void drawMe(Graphics g) {
		for(int i=0;i<account.length;i++) {
			g.drawString(account[i].toString(), 300, 100*(i+1));
		}
	}
}
