
public class Item {
	private String name;
	private double price;
	public Item(String name,double price) {
		this.name=name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public int hashCode() {
		int first=name.charAt(0)-96;
		int second=name.charAt(1)-96;
		return (int) (first*31+second+Math.round(price));
	}
	@Override
	public boolean equals(Object other) {
		Item otherState=(Item)other;
		if(otherState.getName().equals(name) && otherState.getPrice()==price) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return name+" "+price;
	}
	
}
