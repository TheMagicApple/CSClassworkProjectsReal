import java.util.ArrayList;
import java.util.List;


public class FoodRunner
{
	public static void main(String[] args)
	{
		
		Sandwich cheeseburger = new Sandwich("Cheeseburger", 2.75);
		Sandwich clubsandwich = new Sandwich("Club Sandwich", 2.75);
		
		Salad spinachsalad = new Salad("Spinach Salad", 1.25);
		Salad coleslaw = new Salad("Coleslaw", 1.25);
		
		Drink orangesoda = new Drink("Orange Soda", 1.25);
		Drink cappuccino = new Drink("Cappuccino", 3.50);
		
		System.out.println("Testing Part 1");
		Trio trio1 = new Trio(cheeseburger, spinachsalad, orangesoda);
		System.out.println( "Name : " + trio1.getName() );
		System.out.println( "Price : $" + trio1.getPrice() );
		System.out.println();
		
		
		System.out.println("Testing Part 2");
		Trio trio2 = new Trio(clubsandwich, coleslaw, cappuccino);
		System.out.println( "Name : " + trio2.getName() );
		System.out.println( "Price : $" + trio2.getPrice() );
		System.out.println();
		
		/* Your output shoud look like the following.
		
		Testing Part 1
		Name : Cheeseburger/Spinach Salad/Orange Soda Trio
		Price : $4.0

		Testing Part 2
		Name : Club Sandwich/Coleslaw/Cappuccino Trio
		Price : $6.25

		
		*/


		
		
	}
}