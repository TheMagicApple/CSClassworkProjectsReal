
public class Split {
	private String email;
	public Split(String email) {
		this.email=email;
	}
	public String getName() {
		return email.substring(0,email.indexOf("@"));
	}
	public String getDomain() {
		return email.substring(email.indexOf("@")+1,email.lastIndexOf("."));
	}
	public String getLastNameMVLA(String s) {
		return s.substring(email.indexOf(".")+1,email.indexOf("@")-2);
	}
	public String toString() {
		return "address: "+email;
	}
}
