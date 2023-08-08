public class School {
	private String name;
	private int id;
	public School(String name,int id) {
		this.name=name;
		this.id=id;
	}
	public int hashCode() {
		return id;
	}
	public String toString() {
		return name+" "+id;
	}
	public int getID() {
		return id;
	}
	public boolean equals(Object other) {
		return ((School)other).getID()==id;
	}
}