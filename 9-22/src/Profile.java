
public class Profile {
	private String name;
	private int age;
	public Profile() {
		name="John";
		age=15;
	}
	public Profile(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public void printInfo() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
	}
	public void printInfo(int id) {
		printInfo();
		System.out.println("ID: "+id);
	}
}
