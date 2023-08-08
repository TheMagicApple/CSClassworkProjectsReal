import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Item> items=new ArrayList<>();
		items.add(new Food("Apple",0.75));
		items.add(new Food("Milk",2.99));
		items.add(new Toy("Doll","ABC Inc",19.99));
		for(Item item:items) {
			System.out.println(item);
		}

	}

}
