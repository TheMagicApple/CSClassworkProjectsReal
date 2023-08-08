
public class Profile {
	private String name;
	private double gpa;
	public Profile() {
		name="no name";
		gpa=0;
	}
	public Profile(String name,double gpa) {
		this.name=name;
		this.gpa=gpa;
	}
	public void printInfo() {
		System.out.println("Name: "+name);
		System.out.println("GPA: "+gpa);
	}
	public void printInfo(int birthYear) {
		printInfo();
		System.out.println("Estimated age: "+(2021-birthYear));
	}
}
