import java.util.Random;
import java.util.Scanner;
public class RunnerC {

	public static void main(String[] args) {
		Random r=new Random();
		Scanner s=new Scanner(System.in);
		int[] a=new int[5];
		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(3)+2;
		}
		for(int n:a) {
			System.out.println(n);
		}
		System.out.println("Enter a number greater than 10");
		System.out.println(r.nextInt(s.nextInt())+1);
		System.out.println("Enter two positive numbers, where the second is greater than the first");
		int n1=s.nextInt();
		int n2=s.nextInt();
		System.out.println(r.nextInt(n2-n1+1)+n1);
		int[] aa=new int[5];
		for(int i=0;i<aa.length;i++) {
			aa[i]=r.nextInt(99)+1;
		}
		for(int n:aa) {
			System.out.println(n);
		}
		int max=aa[0];
		int maxI=0;
		for(int i=0;i<aa.length;i++) {
			if(aa[i]>max) {
				max=aa[i];
				maxI=i;
			}
		}
		System.out.println("max:"+max);
		System.out.println("index:"+maxI);
		
		

	}

}
