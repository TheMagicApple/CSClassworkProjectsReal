
public class ArrayTest {
	private int[] numbers;
	public ArrayTest(int size) {
		numbers=new int[size];
		for(int i=0;i<size;i++) {
			numbers[i]=(int)(Math.random()*99+1);
		}
	}
	public void print() {
		for(int n:numbers) {
			System.out.println(n);
		}
	}
	public int getSmallest() {
		int smallest=numbers[0];
		for(int n:numbers) {
			if(n<smallest) {
				smallest=n;
			}
		}
		return smallest;
	}
	
}