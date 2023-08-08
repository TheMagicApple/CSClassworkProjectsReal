
public class Profile implements Comparable<Profile>{
	private String name;
	private int id;
	public Profile(String name,int id) {
		this.name=name;
		this.id=id;
	}
	public String toString() {
		return name+" "+id;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int compareTo(Profile other) {
		if(other.getID()==id) {
			return 0;
		}
		if(name.equals(other.getName())) {
			return Integer.compare(id, other.getID());
		}else {
			return name.compareTo(other.getName());
		}
	}
}	
