
public class Runner2 {

	public static void main(String[] args) {
		ForTest f=new ForTest();
		f.printCount();
		f.printCount(10);
		f.printCount(5,20);
		int result=f.getFactorial(5);
		System.out.println(result);

	}

}
