
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class Runner {

	public static void main(String[] args) {
		SortedMap<State,Info> map=new TreeMap<>();
		map.put(new State("California"), new Info("California","Sacramento",40000000));
		map.put(new State("Hawaii"),new Info("Hawaii","Honolulu",2000000000));
		map.put(new State("Wyoming"), new Info("Wyoming","Cheyenne",0));
		Scanner s=new Scanner(System.in);
		while(true) {
			System.out.println("Choose an option:");
			System.out.println("1. View States");
			System.out.println("2. Add a State");
			System.out.println("3. Search State");
			System.out.println("4. Delete a State");
			System.out.println("5. Quit");
			int choice=s.nextInt();
			if(choice==1) {
				Set<State> i=map.keySet();
				for(State ss:i) {
					System.out.println(ss);
				}
			}
			if(choice==2) {
				System.out.println("State name: ");
				String name=s.next();
				System.out.println("State capital: ");
				String capital=s.next();
				System.out.println("State population: ");
				int population=s.nextInt();
				map.put(new State(name), new Info(name,capital,population));
			}
			if(choice==3) {
				System.out.println("State name: ");
				String name=s.next();
				System.out.println(map.get(new State(name)));
			}
			if(choice==4) {
				System.out.println("State name: ");
				String name=s.next();
				map.remove(new State(name));
			}
			if(choice==5) {
				break;
			}
		}

	}

}
