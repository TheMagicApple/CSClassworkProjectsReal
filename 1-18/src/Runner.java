
public class Runner {

	public static void main(String[] args) {
		Node<Integer> n1=new Node<>(1);
		Node<Integer> n2=new Node<>(2);
		Node<Integer> n3=new Node<>(3);
		Node<Integer> n4=new Node<>(4);
		Node<Integer> n5=new Node<>(5);
		Node<Integer> n6=new Node<>(6);
		Node<Integer> n7=new Node<>(7);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n3.right=n7;
		printInOrder(n1);
		System.out.println();
		printPreOrder(n1);
		System.out.println();
		printPostOrder(n1);
		System.out.println();
		printRevOrder(n1);

	}
	public static void printInOrder(Node<Integer> n) {
		if(n!=null) {
			printInOrder(n.left);
			System.out.print(n.value+" ");
			printInOrder(n.right);
		}
	}
	public static void printPreOrder(Node<Integer> n) {
		if(n!=null) {
			System.out.print(n.value+" ");
			printPreOrder(n.left);
			printPreOrder(n.right);
		}
	}
	public static void printPostOrder(Node<Integer> n) {
		if(n!=null) {
			printPostOrder(n.left);
			printPostOrder(n.right);
			System.out.print(n.value+" ");
		}
	}
	public static void printRevOrder(Node<Integer> n) {
		if(n!=null) {
			printRevOrder(n.right);
			System.out.print(n.value+" ");
			printRevOrder(n.left);
		}
	}

}
