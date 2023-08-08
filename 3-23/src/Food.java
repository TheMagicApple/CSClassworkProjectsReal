
public class Food extends Item{
	private String name;
	public Food(String name,double price) {
		super(price);
		this.name=name;
	}
	public String toString() {
		return super.toString()+" This food item is a "+name;
	}
	
}
