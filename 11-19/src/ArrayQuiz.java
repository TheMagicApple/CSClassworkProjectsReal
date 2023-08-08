
public class ArrayQuiz {
	private int[] nums;
	public ArrayQuiz(int[] numsInput) {
		nums=numsInput;
	}
	public void print() {
		for(int n:nums) {
			System.out.println(n);
		}
	}
	public int getSummation() {
		int total=0;
		for(int n:nums) {
			total+=n;
		}
		return total;
	}
	public int getLargest() {
		int largest=nums[0];
		for(int n:nums) {
			if(n>largest) {
				largest=n;
			}
		}
		return largest;
	}
}
