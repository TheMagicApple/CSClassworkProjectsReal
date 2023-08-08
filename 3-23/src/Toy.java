
public class Toy extends Item{
	private String name;
	private String company;
	public Toy(String name,String company,double price) {
		super(price);
		this.name=name;
		this.company=company;
	}
	public String toString() {
		return super.toString()+" This toy is a "+name+" and is made by "+company;
	}
}
