
public class Item {
	private String name;
	private double price;
	private int quantity;
	public Item(String name,double price,int quantity) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	@Override
	public boolean equals(Object o) {
		Item other=(Item)o;
		if(other.getName().equals(name) && other.getPrice()==price) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return name+" $"+price+" "+quantity;
	}
	@Override
	public int hashCode() {
		return (int) (name.charAt(0)+name.charAt(1)+price);
	}
	
}
