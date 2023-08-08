
public class Runner {

	public static void main(String[] args) {
		Student s=new Student("Bob");
		System.out.println(s.saying());
		Profile p=(Profile)s;
		System.out.println(p.saying());

	}

}
