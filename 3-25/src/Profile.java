
public class Profile {
	private String name;
	private String specialty;
	public Profile(String name,String specialty) {
		this.name=name;
		this.specialty=specialty;
	}
	public void speak() {
		System.out.println("Hi, My name is "+name+".");
	}
	public void printInfo() {
		speak();
		System.out.println("My specialty is "+specialty);
	}
}
