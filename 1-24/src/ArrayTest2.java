import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayTest2 {
	ArrayList<Integer> nums;
	public ArrayTest2(int size) {
		nums=new ArrayList<>();
		for(int i=0;i<size;i++) nums.add((int)(Math.random()*15+1));
	}
	public void print() {
		for(int num:nums) {
			System.out.print(num+" ");
		}
		System.out.println();
	}
	public void printBackwards() {
		Collections.reverse(nums);
		for(int num:nums) {
			System.out.print(num+" ");
		}
		System.out.println();
		
	}
	
}
