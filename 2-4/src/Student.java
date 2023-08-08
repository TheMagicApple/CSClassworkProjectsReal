
public class Student {
	private String name;
	private double balance;
	public Student(String name,double balance) {
		this.name=name;
		this.balance=balance;
	}
	public double getBalance() {
		return balance;
	}
	public String toString() {
		return name+" : "+balance;
	}
}
