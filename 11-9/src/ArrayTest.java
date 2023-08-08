import java.util.Random;
public class ArrayTest {
	private Random r=new Random();
	private int[] numbers;
	public ArrayTest(int size) {
		numbers=new int[size];
		for(int i=0;i<size;i++) {
			numbers[i]=r.nextInt(5)+1;
		}
	}
	public void print() {
		for(int n:numbers) {
			System.out.println(n);
		}
	}
	public int getSum() {
		int total=0;
		for(int n:numbers) {
			total+=n;
		}
		return total;
	}
}
