
public class Runner {

	public static void main(String[] args) {
		ArrayTest a=new ArrayTest(5);
		a.print();
		int result=a.getSmallest();
		System.out.println("Smallest: "+result);

	}

}
