
public class Two {
	private String name;
	public Two() {
		name="none";
	}
	public Two(String name) {
		this.name=name;
	}
	public void printName() {
		System.out.println("Name: "+name);
	}
	public void printName(int age) {
		printName();
		System.out.println("Age: "+age);
	}
}
