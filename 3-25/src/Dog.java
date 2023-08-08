
public class Dog extends Animal{
	private String name;
	public Dog(String sound,String name) {
		super(sound);
		this.name=name;
	}
	public String toString() {
		return super.toString()+" My name is "+name;
	}
}
