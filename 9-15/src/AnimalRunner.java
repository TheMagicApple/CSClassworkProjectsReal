import java.util.Scanner;
public class AnimalRunner {

	public static void main(String[] args) {
		Animal animal=new Animal();
		Scanner s=new Scanner(System.in);
		System.out.println("What is the animal type?");
		String animalType=s.next();
		System.out.println("What is the animal age?");
		int animalAge=s.nextInt();
		animal.setVariables(animalType, animalAge);
		animal.printInfo();
		
		

	}

}
