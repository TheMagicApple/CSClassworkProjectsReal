
public class Price {
	private double price;
	public Price(double price) {
		this.price=price;
	}
	public int hashCode() {
		return (int)price*100;
	}
	public String toString() {
		return ""+price;
	}
	public double getPrice() {
		return price;
	}
	public boolean equals(Object other) {
		return ((Price)other).getPrice()==price;
	}
}
