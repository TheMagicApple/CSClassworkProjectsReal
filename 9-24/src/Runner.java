
public class Runner {

	public static void main(String[] args) {
		Profile p1=new Profile();
		p1.printInfo();
		Profile p2=new Profile("Jen",4.0);
		p2.printInfo();
		p2.printInfo(2005);
		
	}

}
