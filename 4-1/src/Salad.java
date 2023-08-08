public class Salad implements MenuItem
{
	private String name;
	private double price;
	
	public Salad(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	/** @return the name of the menu item */
	public String getName()
	{
		return name;
	}
	
	/** @return the price of the menu item */
	public double getPrice()
	{
		return price;
	}
}
