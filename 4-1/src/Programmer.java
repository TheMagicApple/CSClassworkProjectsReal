
public class Programmer extends Profile{
	public Programmer(String employerName,String employeeName) {
		super(employerName,employeeName);
	}
	public String getInfo() {
		return "Programmer "+getName()+" "+getEmployer();
	}
}
