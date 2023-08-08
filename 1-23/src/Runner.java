import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		BinarySearchTree<Animal> b=new BinarySearchTree<Animal>();
		Scanner s=new Scanner(System.in);
		b.add(new Animal("monkey",5));
		b.add(new Animal("bear",7));
		b.add(new Animal("bear",8));
		b.add(new Animal("octopus",4));
		System.out.println(b);
		System.out.println("Animal to add: ");
		String animal=s.next();
		System.out.println("Animal age: ");
		int age=s.nextInt();
		b.add(new Animal(animal,age));
		System.out.println(b);
		//System.out.println(b);
		
		System.out.println("Animal to remove: ");
		animal=s.next();
		System.out.println("Animal age: ");
		age=s.nextInt();
		b.remove(new Animal(animal,age));
		System.out.println(b);

	}

}
