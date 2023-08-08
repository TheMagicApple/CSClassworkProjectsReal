import java.util.ArrayList;

public class Runner3 {

	public static void main(String[] args) {
		ArrayList<Item> cart=new ArrayList<>();
		cart.add(new Apple(0.99));
		cart.add(new Cereal(4.99));
		cart.add(new Milk(3.99));
		for(Item item:cart) {
			System.out.println(item);
		}

	}

}
