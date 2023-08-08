import java.util.HashSet;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		HashSet<State> set=new HashSet<>();
		set.add(new State("California","ca"));
		set.add(new State("Colorado","co"));
		set.add(new State("Arizona","az"));
		set.add(new State("Utah","ut"));
		set.add(new State("Idaho","id"));
		boolean quit=false;
		while(!quit) {
			System.out.println("1. Display all states");
			System.out.println("2. Add a state");
			System.out.println("3. Search for a state");
			System.out.println("4. Remove a state");
			System.out.println("5. Quit");
			int choice=s.nextInt();
			if(choice==1) {
				System.out.println(set);
			}else if(choice==2) {
				System.out.println("New state name: ");
				String name=s.next();
				System.out.println("New state abbreviation: ");
				String abbreviation=s.next();
				set.add(new State(name,abbreviation));
			}else if(choice==3) {
				System.out.println("State abbreviation: ");
				String abbreviation=s.next();
				System.out.println(set.contains(new State("",abbreviation)));
			}else if(choice==4) {
				System.out.println("State abbreviation: ");
				String abbreviation=s.next();
				set.remove(new State("",abbreviation));
			}else if(choice==5) {
				quit=true;
			}
		}

	}

}
