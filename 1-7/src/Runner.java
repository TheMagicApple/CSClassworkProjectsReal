
public class Runner {

	public static void main(String[] args) {
		Review r=new Review(5);
		r.printArray();
		int result=r.getLargest();
		System.out.println("Largest: "+result);

	}

}
