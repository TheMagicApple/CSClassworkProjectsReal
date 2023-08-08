import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Student> students=new ArrayList<>();
		students.add(new Student("Henry",34));
		students.add(new Student("Jose",21));
		students.add(new Student("Carla",21));
		students.add(new Student("Nancy",19));
		students.removeIf(s->(s.getAge()==21));
		for(Student student:students) {
			if(student.getAge()==21) {
				System.out.println(student);
			}
		}
		
		//for(Student student:students) if(student.getAge()==21) System.out.println(student);

	}

}
