
public class Runner2 {

	public static void main(String[] args) {
		Split sp=new Split("john.smith@mvla.net");
		System.out.println(sp.getName());
		System.out.println(sp.getDomain());
		System.out.println(sp.getLastNameMVLA("jane.doe@mvla.net"));
		System.out.println(sp);
		
		

	}

}
