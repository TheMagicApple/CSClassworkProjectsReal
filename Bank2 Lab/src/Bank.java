
public class Bank{
	private String name;
	private double balance;
	private int pin;
	private boolean access;
	
	public Bank(String name, double balance, int pin){
		this.name = name;
		this.balance = balance;
		this.pin = pin;
		this.access = false;
	}
	
	public String getName(){
		if( access == true){
			return name;
		} else {
			return "Signed out.";
		}
	}
	public double getBalance() {
		if(access==true) {
			return (Math.round(balance*100.0))/100.0;
		}else {
			return 0;
		}
	}
	public void disableAccess() {
		access=false;
	}
	public boolean getAccess() {
		return access;
	}
	public boolean checkPin(int pinInput){
		if( pin == pinInput ){
			access = true;
			return true;
		} else {
			access = false;
			return false;
		}
	}
	public void withDraw(double withDraw) {
		if(balance-withDraw>=0) {
			balance-=withDraw;
		}
		
	}
	public void deposit(double deposit) {
		balance+=deposit;
	}
	public void updateName(String name) {
		this.name=name;
	}
	
	
	
	
}
