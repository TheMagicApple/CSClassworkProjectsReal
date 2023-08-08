
public class Runner {

	public static void main(String[] args) {
		ArrayTest a=new ArrayTest(5);
		a.print();
		int result=a.getLargest();
		System.out.println(result);
		int r=a.find(1);
		System.out.println(r);

	}

}
