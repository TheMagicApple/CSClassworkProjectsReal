import java.util.Random;
import java.util.ArrayList;
public class ArrayTestB {
	private Random r=new Random();
	public void arrayDemo1() {
		System.out.println("----------Demo 1------------");
		int[] a=new int[10];
		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(8)+1;
		}
		for(int n:a) {
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println();
		a[5]=0;
		for(int n:a) {
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println();
	}
	public void arrayDemo2() {
		System.out.println("------------Demo 2------------");
		String[] a= {"apple","orange","banana","strawberry","mango"};
		for(String s:a) {
			System.out.print(s);
			System.out.print(" ");
		}
		System.out.println();
	}
	public void arrayDemo3(String search) {
		System.out.println("----------------Demo 3---------------");
		String[] a= {"dog","bird","cat","bear","cow"};
		for(String s:a) {
			System.out.print(s);
			System.out.print(" ");
		}
		System.out.println();
		ArrayList<String> aSearch=new ArrayList<>();
		for(String s:a) {
			aSearch.add(s);
		}
		if(aSearch.contains(search)) {
			System.out.println("found!!!!!!!!");
		}else {
			System.out.println("not found");
		}
		
	}
}
