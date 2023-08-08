
public class Patient implements Comparable<Patient>{
	public String name;
	public String illness;
	public int priority;
	public int age;
	public int time;
	public String note;
	public static int t=0;
	public Patient(String name,String illness,int priority,int age) {
		this.name=name;
		this.illness=illness;
		this.priority=priority;
		this.age=age;
		this.time=Patient.t;
		Patient.t++;
	}
	public int compareTo(Patient o) {
		boolean p=(priority-o.priority<0) ? true : false;
		boolean a=(age-o.age<0) ? true : false;
		boolean t=(time-o.time<0) ? true : false;
		if(priority!=o.priority) return p?-1:1;
		if(age!=o.age) return a?-1:1;
		if(time!=o.time) return t?-1:1;
		return 0;
	}
	public boolean equals(Object o) {
		return hashCode()==o.hashCode();
	}
	public String toString() {
		return name+": "+illness+", "+((priority==0)?"High":(priority==1)?"Medium":"Low")+", "+((age==0)?"Child":"Adult")+", "+time;
	}
	
	
}
