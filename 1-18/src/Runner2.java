
public class Runner2 {

	public static void main(String[] args) {
		BinarySearchTree<Integer> b=new BinarySearchTree<>();
		b.add(90);
		b.add(80);
		b.add(100);
		b.add(70);
		b.add(85);
		b.add(98);
		b.add(120);
		//System.out.println(b);
		
		System.out.println(b.contains(85));
		System.out.println(b.contains(86));
		System.out.println();
		b.clear();
		b.add(90);
		b.add(80);
		b.add(100);
		b.add(70);
		b.add(85);
		b.add(98);
		b.add(120);
		b.remove(70);
		b.remove(120);
		System.out.println(b);
		System.out.println(b.toStringPreOrder());
		System.out.println();
		b.clear();
		b.add(90);
		b.add(80);
		b.add(100);
		b.add(70);
		b.add(85);
		b.add(98);
		b.add(120);
		//System.out.println(b);
		b.remove(100);
		System.out.println(b);
		System.out.println(b.toStringPreOrder());
		System.out.println();
		b.clear();
		b.add(90);
		b.add(80);
		b.add(100);
		b.add(98);
		b.add(91);
		b.add(99);
		b.remove(100);
		System.out.println(b);
		System.out.println(b.toStringPreOrder());
		System.out.println();
		b.clear();
		b.add(90);
		b.add(100);
		b.add(98);
		b.add(110);
		b.remove(90);
		System.out.println(b);
		System.out.println(b.toStringPreOrder());
		System.out.println();
		b.clear();
		b.add(90);
		b.add(80);
		b.add(100);
		b.add(98);
		b.add(91);
		b.add(99);
		b.add(110);
		b.remove(90);
		System.out.println(b);
		System.out.println(b.toStringPreOrder());
		System.out.println();
		b.clear();
		b.add(90);
		b.remove(90);
		System.out.println(b);
		System.out.println(b.toStringPreOrder());
		
		

	}

}
