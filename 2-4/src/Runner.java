import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		ArrayListQuiz aq=new ArrayListQuiz();
		ArrayList<Student> studentList=new ArrayList<>();
		studentList.add(new Student("John",12.34));
		studentList.add(new Student("Jen",12.34));
		studentList.add(new Student("Jose",11.11));
		studentList.add(new Student("Jane",43.21));
		aq.printList(studentList);
		System.out.println("scramble");
		aq.scramble(studentList);
		aq.printList(studentList);
		System.out.println("total: "+aq.total(studentList));
		aq.printList(studentList);
		System.out.println("remove");
		aq.remove(studentList, 12.34);
		aq.printList(studentList);
		
	}

}
