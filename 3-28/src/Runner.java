import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Animal> animals=new ArrayList<>();
		animals.add(new Dog());
		animals.add(new Bird());
		for(Animal animal:animals) {
			animal.speak();
		}
	}

}
