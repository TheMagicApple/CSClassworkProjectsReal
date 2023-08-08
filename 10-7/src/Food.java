public class Food {
	private String name;
	private double price;
	public Food(String name,double price) {
		this.name=name;
		this.price=price;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String toString() {
		return name+" "+price;
	}
	@Override
	public boolean equals(Object other) {
		Food f=(Food)other;
		if(f.getName().equals(name) && f.getPrice()==price) {
			return true;
		}
		return false;
	}
}