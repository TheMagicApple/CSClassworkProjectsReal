
public class Cereal extends Item{
	public Cereal(double price) {
		super(price);
	}
	public String toString() {
		return super.toString()+"Cereal: "+super.getPrice();
	}
	
}

