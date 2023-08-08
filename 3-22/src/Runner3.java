import java.util.Scanner;
public class Runner3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MinHeap<Task> heap = new MinHeap<Task>();
		for (int i = 0;i<5;i++) {
			sc.nextLine();
			System.out.println("Enter task name:");
			String name = sc.nextLine();
			System.out.println("Enter priority:");
			int prio = sc.nextInt();
			heap.add(new Task(name,prio));
		}
		while(heap.size()>0) {
			System.out.println(heap.poll());
		}
	}

}