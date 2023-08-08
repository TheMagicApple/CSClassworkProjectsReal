
public class Review {
	private int[] nums;
	public Review(int size) {
		nums=new int[size];
		for(int i=0;i<nums.length;i++) {
			nums[i]=(int)(Math.random()*101+1);
		}
	}
	public void printArray() {
		for(int n:nums) {
			System.out.println(n);
		}
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
