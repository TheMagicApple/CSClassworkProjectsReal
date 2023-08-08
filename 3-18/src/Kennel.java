import java.util.ArrayList;

public class Kennel
{
	private ArrayList<Pet> petList = new ArrayList<Pet>();
	
	public void add(Pet newPet)
	{
		petList.add(newPet);
	}
	
	public void allSpeak()
	{
		for(Pet pet:petList) {
			System.out.println(pet.getName()+" says "+pet.speak());
		}
	}
}
