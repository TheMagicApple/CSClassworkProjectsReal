
public class Runner {

	public static void main(String[] args) {
		ComputerScienceStudent bob=new ComputerScienceStudent("Bob");
		System.out.println(bob.saying());
		Student newBob=(Student)bob;
		System.out.println(newBob.saying());

	}

}
