import java.util.*;
public class Runner {
	public static void main(String[] args) {
		HashMap<Integer,String> studentList=new HashMap<>(); studentList.put(0,"Bob"); studentList.put(1, "Carl"); studentList.put(2, "John"); studentList.put(3, "Henry"); studentList.put(4, "Robert"); Scanner s=new Scanner(System.in); boolean quit=false;
		while(!quit) {
			System.out.println("1. View All Students"); System.out.println("2. Add a new student"); System.out.println("3. Get a student name given ID"); System.out.println("4. Remove a student given ID"); System.out.println("5. Quit"); int choice=s.nextInt();
			if(choice==1) {
				for(int i:studentList.keySet()) System.out.println(i+" "+studentList.get(i));
			}
			if(choice==2) {
				System.out.println("Student name: "); String name=s.next(); System.out.println("Student ID: "); int id=s.nextInt(); studentList.put(id, name);
			}
			if(choice==3) {
				System.out.println("Student ID: "); int id=s.nextInt(); System.out.println(studentList.get(id));
			}
			if(choice==4) {
				System.out.println("Student ID: "); int id=s.nextInt(); System.out.println(studentList.remove(id));
			}
			if(choice==5) quit=true;
		}
	}
}