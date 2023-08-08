
public class Student extends People{
	public Student(String name) {
		super(name);
	}
	public void printInfo() {
		super.printInfo();
		System.out.println("My name is "+super.getName());
		System.out.println("I am a student.");
	}
}
