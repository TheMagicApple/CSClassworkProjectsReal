
public class Student {
	private String name;
	private int id;
	public Student(String name,int id) {
		this.name=name;
		this.id=id;
	}
	public int getID() {
		return id;
	}
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object other) {
		Student otherr=(Student)other;
		if(otherr.getID()==id) {
			return true;
		}
		System.out.println(otherr.getID());
		System.out.println(id);
		return false;
	}
	public String toString() {
		return name+" "+id;
	}
}

