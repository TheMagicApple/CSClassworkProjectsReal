
public class ArrayTest {
	private int[] numbers;
	public ArrayTest(int size) {
		numbers=new int[size];
		for(int i=0;i<size;i++) {
			numbers[i]=(int)(Math.random()*5+1);
		}
	}
	public void print() {
		for(int n:numbers) {
			System.out.println(n);
		}
	}
	public int getLargest() {
		int largest=numbers[0];
		for(int n:numbers) {
			if(n>largest) {
				largest=n;
			}
		}
		return largest;
	}
	public int find(int n) {
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]==n) {
				return i;
			}
		}
		return -1;
	}
}
