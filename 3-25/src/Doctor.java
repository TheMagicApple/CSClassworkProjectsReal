
public class Doctor extends Profile{
	private String hobby;
	public Doctor(String name,String hobby) {
		super(name,"healing");
		this.hobby=hobby;
	}
	public void printInfo() {
		super.printInfo();
		System.out.println("My hobby is "+hobby);
	}
}
