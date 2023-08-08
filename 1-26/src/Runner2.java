
public class Runner2 {

	public static void main(String[] args) {
		Test t=new Test();
		t.printList();
		System.out.println(t.searchLargest());
		t.searchAndReplace(5);
		t.printList();
		t.searchAndRemove(2);
		t.printList();
		t.scramble();
		t.printList();
		t.sort();
		t.printList();
			

	}

}
