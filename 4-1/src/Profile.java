
public abstract class Profile {
	private String employerName;
	private String employeeName;
	public Profile(String employerName,String employeeName) {
		this.employerName=employerName;
		this.employeeName=employeeName;
	}
	public abstract String getInfo();
	public String getEmployer() {
		return employerName;
	}
	public String getName() {
		return employeeName;
	}
}
