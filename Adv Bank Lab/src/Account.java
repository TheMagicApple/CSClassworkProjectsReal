import java.awt.Image;

public class Account {
	private String name;
	private double balance;
	private int pin;
	private boolean access;
	private Image img;
	public Account(String name,double balance,int pin,Image img) {
		this.name=name;
		this.balance=balance;
		this.pin=pin;
		this.img=img;
		access=false;
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		if(access) {
			return balance;
		}else {
			return 0;
		}
	}
	public boolean getAccess() {
		return access;
	}
	public void setAccess(int pin,String name) {
		if(name.equals(this.name) && pin==this.pin) {
			access=true;
		}
	}
	public void withdraw(double money) {
		if(access) {
			balance-=money;
		}
	}
	public void deposit(double money) {
		if(access) {
			balance+=money;
		}
	}
	public Image getImage() {
		return img;
	}
	public void logout() {
		access=false;
	}
}