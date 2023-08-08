
public class Programmer extends Profile{
	private String hobby;
	public Programmer(String name,String hobby) {
		super(name,"coding");
		this.hobby=hobby;
	}
	public void printInfo() {
		super.printInfo();
		System.out.println("My hobby is "+hobby);
	}
}
