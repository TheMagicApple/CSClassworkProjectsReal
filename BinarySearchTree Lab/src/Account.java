
public class Account implements Comparable<Account>{
	public String firstName;
	public String lastName;
	public int pin;
	public float balance;
	public Account(String firstName,String lastName,int pin,float balance) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.pin=pin;
		this.balance=balance;
	}
	@Override
	public int compareTo(Account o) {
		if(!o.lastName.equals(lastName)) {
			return lastName.compareTo(o.lastName);
		}
		return firstName.compareTo(o.firstName);
	}
	public String toString() {
		return lastName+", "+firstName;
	}

}
