import java.util.PriorityQueue;
import java.util.Scanner;

public class Runner2 {

	public static void main(String[] args) {
		DLList<Ticket> completedTickets=new DLList<>();
		PriorityQueue<Ticket> serviceTickets=new PriorityQueue<>();
		Scanner s=new Scanner(System.in);
		while(true) {
			System.out.println("1. Create Ticket");
			System.out.println("2. Service Ticket");
			System.out.println("3. View Completed Tickets");
			System.out.println("4. Quit");
			int choice=s.nextInt();
			if(choice==1) {
				System.out.println("Name: ");
				String name=s.next();
				System.out.println("Description: ");
				s.nextLine();
				String description=s.nextLine();
				System.out.println("High priority? ");
				boolean priority=s.nextBoolean();
				serviceTickets.add(new Ticket(name,description,priority,System.currentTimeMillis(),""));
			}
			if(choice==2) {
				System.out.println(serviceTickets.peek());
				System.out.println("Service note: ");
				s.nextLine();
				String note=s.nextLine();
				serviceTickets.peek().note=note;
				completedTickets.add(serviceTickets.poll());
			}
			if(choice==3) {
				s.nextLine();
				System.out.println(completedTickets);
			}
			if(choice==4) {
				return;
			}
				
		}

	}

}
