
public class SearchRunner {

	public static void main(String[] args) {
		int[] a = new int[7];

		a[0] = 3;
		a[1] = 5;
		a[2] = 6;
		a[3] = 8;
		a[4] = 10;
		a[5] = 13;
		a[6] = 14;

		BinarySearch b=new BinarySearch();
		b.resetPass();
		System.out.println(b.search(a,5,0,6));
		System.out.println(b.getPass());
		


		b.resetPass();
		System.out.println(b.search(a,14,0,6));
		System.out.println(b.getPass());


		b.resetPass();
		System.out.println(b.search(a,99,0,6));
		System.out.println(b.getPass());
	}

}
