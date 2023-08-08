import java.util.HashSet;
import java.util.Scanner;

public class Runner2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		HashSet<Item> set=new HashSet<>();
		set.add(new Item("Milk",3.1));
		set.add(new Item("Cheese",10));
		set.add(new Item("Bread",1));
		set.add(new Item("Burger",3));
		set.add(new Item("Lettuce",2));
		boolean quit=false;
		while(!quit) {
			System.out.println("1. Display all items");
			System.out.println("2. Add an item");
			System.out.println("3. Search for an item");
			System.out.println("4. Remove an item");
			System.out.println("5. Quit");
			int choice=s.nextInt();
			if(choice==1) {
				System.out.println(set);
			}else if(choice==2) {
				System.out.println("New item name: ");
				String name=s.next();
				System.out.println("New item price: ");
				double abbreviation=s.nextDouble();
				set.add(new Item(name,abbreviation));
			}else if(choice==3) {
				System.out.println("Item name: ");
				String abbreviation=s.next();
				System.out.println("Item price: ");
				double price=s.nextDouble();
				System.out.println(set.contains(new Item(abbreviation,price)));
			}else if(choice==4) {
				System.out.println("Item name: ");
				String abbreviation=s.next();
				System.out.println("Item price: ");
				double price=s.nextDouble();
				set.remove(new Item(abbreviation,price));
			}else if(choice==5) {
				quit=true;
			}
		}

	}

}
