import java.util.Scanner;
public class Runner2 {

	public static void main(String[] args) {
		ArrayTest2 a=new ArrayTest2();
		int[] nums=new int[10];
		for(int i=0;i<nums.length;i++) {
			nums[i]=(int)(Math.random()*10+1);
		}
		a.printArray(nums);
		a.scramble(nums);
		a.printArray(nums);
		
		System.out.println("Enter a number: ");
		int n=new Scanner(System.in).nextInt();
		System.out.println(a.search(n, nums));
		
		a.sort(nums);
		a.printArray(nums);
		
		String[] words= {"Dog","Cat","Fish","Penguin","Bear"};
		a.printArray(words);
		a.scramble(words);
		a.printArray(words);
		
	}

}
