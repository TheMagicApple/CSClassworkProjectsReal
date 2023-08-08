import java.util.Scanner;
public class Runner2 {
	public static void main (String[] args) {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		for (int i =0;i<1000;i++) {
			heap.add((int)(Math.random()*1000+1));
		}
		System.out.println(heap);
		Scanner sc = new Scanner(System.in);
		//int num = sc.nextInt();
		//heap.remove(num);
		//System.out.println(heap);
		while(heap.size()>0) {
			System.out.print(heap.poll());
		}
	}
}
