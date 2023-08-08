
public class LoudDog extends Dog2{
	public LoudDog(String name) {
		super(name);
	}
	public String speak() {
		return super.speak()+" "+super.speak();
	}
	
}
