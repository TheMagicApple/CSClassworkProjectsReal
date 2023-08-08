import java.util.ArrayList;
public class Runner {
	public static void main(String[] args) {
		ArrayList<Monster> monsters=new ArrayList<>();
		monsters.add(new Mummy("Joe"));
		monsters.add(new Vampire("Ben"));
		monsters.add(new Witch("Carl"));
		for(Monster monster:monsters) {
			System.out.println(monster);
		}
	}
}