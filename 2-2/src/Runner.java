import java.util.ArrayList;
import java.util.Iterator;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Student> students=new ArrayList<>();
		students.add(new Student("Henry",34));
		students.add(new Student("Jose",21));
		students.add(new Student("Carla",21));
		students.add(new Student("Nancy",19));
		//int total=0;
		//Iterator<Student> it = students.iterator();
		//while(it.hasNext())total+=it.next().getAge();
		//for(Student student:students)total+=student.getAge();
		
		
		System.out.println(students.stream().mapToInt(i->i.getAge()).sum());
		students.removeIf(s->(s.getAge()==21));
		for(Student student:students) System.out.println(student);
		
		//for(Student student:students) if(student.getAge()==21) System.out.println(student);

	}

}
