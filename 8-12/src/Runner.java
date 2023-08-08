
public class Runner {

	public static void main(String[] args) {
		Animal a1=new Animal("Dog",5);
		System.out.println(a1);
		Manager.changeMe(a1, "Cat", 3);
		System.out.println(a1);
		

	}

}
