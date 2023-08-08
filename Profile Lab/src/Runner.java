import java.util.Scanner;
public class Runner {

	public static void main(String[] args) {
		boolean going=true;
		Scanner s=new Scanner(System.in);
		Profile p1=new Profile("Bob",20,"Math","Creating things","Pizza");
		Profile p2=new Profile("Carl",15,"Science","Doing things","Pizza");
		Profile p3=new Profile("Steve",23,"English","Creating things","Salad");
		while(going==true) {
			System.out.println("--PROFILE 1--");
			p1.printInfo();
			System.out.println("-------------");
			System.out.println("--PROFILE 2--");
			p2.printInfo();
			System.out.println("-------------");
			System.out.println("--PROFILE 3--");
			p3.printInfo();
			System.out.println("-------------");
			System.out.println("Which profile do you want to change?(1,2,3)");
			int change=s.nextInt();
			System.out.println("New name: ");
			String newName=s.next();
			System.out.println("New age: ");
			int newAge=s.nextInt();
			System.out.println("New favorite subject(Math, Science, or English): ");
			String newSubject=s.next();
			System.out.println("New favorite hobby(Creating things or Doing things): ");
			s.nextLine();
			String newHobby=s.nextLine();
			System.out.println("New favorite food(Pizza or Salad): ");
			String newFood=s.next();
			if(change==1) {
				p1.updateProfile(newName,newAge,newSubject,newHobby,newFood);
				p1.printInfo();
			}
			if(change==2) {
				p2.updateProfile(newName,newAge,newSubject,newHobby,newFood);
				p2.printInfo();
			}
			if(change==3) {
				p3.updateProfile(newName,newAge,newSubject,newHobby,newFood);
				p3.printInfo();
			}
			System.out.println("QUIT?(Y/N)");
			String quit=s.next();
			if(quit.equals("Y")) {
				going=false;
				break;
			}
			
		}
		
		

	}

}
