
public class Runner {

	public static void main(String[] args) {
		ArrayTest a=new ArrayTest();
		a.printNumArray();
		a.swapNumArray(0, 9);
		a.printNumArray();
		a.printStringArray();
		a.swapStringArray(0, 1);
		a.printStringArray();
		System.out.println(a.searchString("Panda"));
		System.out.println(a.countLetter('e'));
		System.out.println(a.countLetter('a'));

	}

}
