
public class Animal {
	private String animalType;
	private int age;
	public void setVariables(String animalTypeInput,int ageInput) {
		animalType=animalTypeInput;
		age=ageInput;
	}
	public void printInfo() {
		System.out.println("Animal type: "+animalType);
		System.out.println("Animal age: "+age);
	}
}
