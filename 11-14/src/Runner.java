import java.io.*;
import java.util.Scanner;
public class Runner{

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DLList<String> todo=new DLList<>();
		try {
			ObjectInputStream o=new ObjectInputStream(new FileInputStream("save.dat"));
			todo=(DLList<String>)o.readObject();
			o.close();
		}catch(FileNotFoundException e) {
			
		}catch(Exception e) {
			System.out.println("rip");
		}
		Scanner s=new Scanner(System.in);
		boolean quit=false;
		while(!quit) {
			System.out.println("Choose option");
			System.out.println("1. Add a task");
			System.out.println("2. View tasks");
			System.out.println("3. Quit");
			int choice=s.nextInt();
			if(choice==1) {
				System.out.println("Task: ");
				String task=s.next();
				todo.add(task);
				ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("save.dat"));
				o.writeObject(todo);
			}else if(choice==2) {
				System.out.println(todo);
			}else if(choice==3){
				quit=true;
			}
		}

	}

}
