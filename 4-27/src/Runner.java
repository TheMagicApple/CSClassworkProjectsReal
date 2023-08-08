import java.util.ArrayList;

public class Runner {
	public static void main(String[] args){
		
		System.out.println("Testing Part A: ");
		ClubMembers cm = new ClubMembers();
		
		String[] names = new String[3];
		names[0] = "John";
		names[1] = "Jose";
		names[2] = "Jane";
		
		cm.addMembers(names, 2019);
		
		
		names = new String[2];
		names[0] = "Maria";
		names[1] = "Mary";

		cm.addMembers(names, 2020);
		
		System.out.println(cm);
		
		System.out.println("\nTesting Part B: ");
		System.out.println("before the method call removeMembers(2018)");
		cm = new ClubMembers();
		cm.setupPartB();
		System.out.println(cm);
		
		System.out.println("after the method call removeMembers(2018)");
		ArrayList<MemberInfo> memberList = cm.removeMembers(2018);
		System.out.println(cm);
		
		System.out.println("returned by the method call removeMembers(2018)");
		for(int i=0; i<memberList.size(); i++){
			System.out.println(memberList.get(i).toString());
		}
	}
}
