
public class Contact {
	private String firstName;
	private String lastName;
	private String email;
	public Contact(String firstName,String lastName,String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	public String toString() {
		return firstName+" "+lastName+": "+email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getUsername() {
		return email.substring(0,email.indexOf("@"));
	}
	public String getDomainName() {
		return email.substring(email.indexOf("@")+1,email.lastIndexOf("."));
	}
	public String getDomainExtension() {
		return email.substring(email.lastIndexOf(".")+1);
	}
}
