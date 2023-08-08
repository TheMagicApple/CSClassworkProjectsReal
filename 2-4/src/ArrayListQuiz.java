import java.util.ArrayList;

public class ArrayListQuiz {
	public void printList(ArrayList<Student> a) {
		for(Student student:a) {
			System.out.println(student);
		}
		System.out.println();
	}
	public void scramble(ArrayList<Student> a) {
		for(int i=0;i<a.size();i++) {
			int choice=(int)(Math.random()*a.size());
			Student temp=a.get(i);
			a.set(i, a.get(choice));
			a.set(choice, temp);
		}
		
	}
	public void remove(ArrayList<Student> a,double badBalance) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).getBalance()==badBalance) {
				a.remove(i);
				i--;
			}
		}
	}
	public double total(ArrayList<Student> a) {
		double sum=0;
		for(Student student:a) {
			sum+=student.getBalance();
		}
		return sum;
	}
}
