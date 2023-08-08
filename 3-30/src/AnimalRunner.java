import java.util.ArrayList;

public class AnimalRunner {

	public static void main(String[] args) {
		ArrayList<Animal> animals=new ArrayList<>();
		animals.add(new Dog("Fido"));
		animals.add(new Cat("Meowster"));
		animals.add(new Bird("Tweety"));
		for(Animal animal:animals) {
			System.out.println(animal);
		}

	}

}
