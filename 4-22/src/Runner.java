public class Runner {
	public static void main(String[] args){
		
		Theater theater = new Theater(10, 3, 4);
		
		System.out.println("Testing part A");
		System.out.println(theater);
		
		//adding seats
		System.out.println("Testing part B");
		theater.assignSeat(0,0);
		theater.assignSeat(1,1);
		theater.assignSeat(2,2);
		theater.assignSeat(3,3);
		theater.assignSeat(4,4);
		theater.assignSeat(5,5);
		theater.assignSeat(6,6);
		System.out.println(theater);
		
		System.out.println("Moving seat 0,0 to seat 0,9: " + theater.reassignSeat(0, 0, 0, 9));
		System.out.println(theater);
		System.out.println("Moving seat 1,1 to seat 2,2: " + theater.reassignSeat(1, 1, 2, 2));
		System.out.println(theater);
		System.out.println("Moving seat 1,1 to seat 1,3: " + theater.reassignSeat(1, 1, 3, 1));
		System.out.println(theater);
		System.out.println("Moving seat 6,6 to seat 1,0: " + theater.reassignSeat(6, 6, 1, 0));
		System.out.println(theater);
	}
}
