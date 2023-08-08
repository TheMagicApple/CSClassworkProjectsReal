
public class ArrayTest {
	private int[] numbers;
	public ArrayTest(int size) {
		numbers=new int[size];
		for(int i=0;i<size;i++) {
			numbers[i]=(int)(Math.random()*9+1);
		}
			
	}
	public void print() {
		for(int n:numbers) {
			System.out.println(n);
		}
	}
	public int getProduct() {
		int product=1;
		for(int n:numbers) {
			product*=n;
		}
		return product;
	}
	
}
