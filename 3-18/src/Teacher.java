
public class Teacher extends People{
	public Teacher(String name) {
		super(name);
	}
	public void printInfo() {
		super.printInfo();
		System.out.println("My name is "+super.getName());
		System.out.println("I am a teacher.");
	}
	
}
