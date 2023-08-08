
public class Apple extends Item{
	public Apple(double price) {
		super(price);
	}
	public String toString() {
		return super.toString()+"Apple: "+super.getPrice();
	}
	
}
