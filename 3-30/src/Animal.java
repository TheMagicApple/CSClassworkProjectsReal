
public abstract class Animal {
	private String name;
	public Animal(String name) {
		this.name=name;
	}
	public String getName() {
		return "I am "+name;
	}
	public abstract String speak();
	public abstract String getColor();
	public String toString() {
		return getName()+" "+speak()+" "+getColor();
	}
	
	
	
}
