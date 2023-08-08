import java.util.HashSet;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		HashSet<Student> set=new HashSet<>();
		set.add(new Student("Bob",1));
		set.add(new Student("Carl",2));
		set.add(new Student("Joe",3));
		set.add(new Student("Tom",4));
		set.add(new Student("Student",5));
		boolean quit=false;
		while(!quit) {
			System.out.println("1. Display all Students");
			System.out.println("2. Add a Student");
			System.out.println("3. Search for a Student");
			System.out.println("4. Remove a Student");
			System.out.println("5. Quit");
			int choice=s.nextInt();
			if(choice==1) {
				System.out.println(set);
			}else if(choice==2) {
				System.out.println("New Student name: ");
				String name=s.next();
				System.out.println("New Student id: ");
				int abbreviation=s.nextInt();
				set.add(new Student(name,abbreviation));
			}else if(choice==3) {
				System.out.println("Student id: ");
				int abbreviation=s.nextInt();
				System.out.println(set.contains(new Student("",abbreviation)));
			}else if(choice==4) {
				System.out.println("Student id: ");
				int abbreviation=s.nextInt();
				set.remove(new Student("",abbreviation));
			}else if(choice==5) {
				quit=true;
			}
		}

	}

}
