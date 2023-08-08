public class Runner {
	public static void main (String[] args) {
		MinHeap<Integer> heap = new MinHeap<Integer>();
		for (int i =0;i<7;i++) {
			heap.add((int)(Math.random()*100+1));
		}
		System.out.println(heap);
	}
}