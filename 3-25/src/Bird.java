
public class Bird extends Animal{
	private String name;
	private String location;
	public Bird(String sound,String name,String location) {
		super(sound);
		this.name=name;
		this.location=location;
	}
	public String toString() {
		return super.toString()+" My name is "+name+" and I am from "+location;
	}
}
