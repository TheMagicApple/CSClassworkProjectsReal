
public class Milk extends Item{
	public Milk(double price) {
		super(price);
	}
	public String toString() {
		return super.toString()+"Milk: "+super.getPrice();
	}
	
}


