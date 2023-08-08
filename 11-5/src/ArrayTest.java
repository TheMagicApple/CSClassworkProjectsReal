import java.util.Random;
import java.util.Scanner;
public class ArrayTest {
	private Random r=new Random();
	private Scanner s=new Scanner(System.in);
	public void arrayDemo1() {
		System.out.println("Demo 1");
		int[] a=new int[5];
		a[0]=r.nextInt(15)+1;
		a[1]=r.nextInt(15)+1;
		a[2]=r.nextInt(15)+1;
		a[3]=r.nextInt(15)+1;
		a[4]=r.nextInt(15)+1;
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
	}
	public void arrayDemo2() {
		System.out.println("Demo 2");
		int[] a=new int[25];
		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(9)+1;
		}
		for(int n:a) {
			System.out.println(n);
		}
	}
	public void arrayDemo3() {
		System.out.println("Demo 3");
		String[] a=new String[5];
		a[0]="chicken";
		a[1]="apple";
		a[2]="feather";
		a[3]="yes";
		a[4]="orange";
		for(String s:a) {
			System.out.println(s);
		}
	}
	public void arrayDemo4() {
		System.out.println("Demo 4");
		String[] a=new String[5];
		a[0]="chicken";
		a[1]="apple";
		a[2]="feather";
		a[3]="banana";
		a[4]="cow";
		for(String s:a) {
			System.out.println(s);
		}
		System.out.println("What are you searching for?");
		String search=s.next();
		for(int i=0;i<a.length;i++) {
			if(a[i].equals(search)) {
				System.out.println("index: "+i);
			}
		}
		
	}
}
