import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		MyHashTable<Price,Item> store=new MyHashTable<>();
		store.put(new Price(1.99),new Item("Pencil","Target"),new Item("Pen","Walmart"));
		store.put(new Price(899),new Item("TV","BestBuy"),new Item("Laptop","Amazon"));
		boolean quit=false;
		Scanner s=new Scanner(System.in);
		while(!quit) {
			System.out.println("--- Choose option! ---");
			System.out.println("1. Display items");
			System.out.println("2. Display store");
			System.out.println("3. Add item");
			System.out.println("4. Delete item");
			System.out.println("5. Delete all items with price");
			System.out.println("6. Quit");
			int choice=s.nextInt();
			if(choice==1) {
				DLList<Price> key=store.keySet();
				for(int i=0;i<key.size();i++) {
					DLList<Item> items=store.get(key.get(i));
					for(int k=0;k<items.size();k++) {
						System.out.println(items.get(k));
					}
					
				}
			}else if(choice==2) {
				DLList<Price> key=store.keySet();
				for(int i=0;i<key.size();i++) {
					System.out.print(key.get(i)+": ");
					DLList<Item> items=store.get(key.get(i));
					for(int k=0;k<items.size();k++) {
						System.out.print(items.get(k)+" ");
					}
					System.out.println();
					
				}
			}else if(choice==3) {
				System.out.println("Item price: ");
				double price=s.nextDouble();
				System.out.println("Item name: ");
				String name=s.next();
				System.out.println("Item store: ");
				String sstore=s.next();
				store.put(new Price(price), new Item(name,sstore));
			}else if(choice==4) {
				System.out.println("Item price: ");
				double price=s.nextDouble();
				System.out.println("Item name: ");
				String name=s.next();
				System.out.println("Item store: ");
				String sstore=s.next();
				store.remove(new Price(price), new Item(name,sstore));
			}else if(choice==5) {
				System.out.println("Item price: ");
				double price=s.nextDouble();
				store.remove(new Price(price));
			}else if(choice==6) {
				quit=true;
			}
			
			
		}

	}

}
