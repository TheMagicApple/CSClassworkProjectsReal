
public class Student {
	private String firstName;
	private String lastName;
	private int age;
	public Student(String firstName,String lastName, int age) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public int getAge() {
		return age;
	}
}
