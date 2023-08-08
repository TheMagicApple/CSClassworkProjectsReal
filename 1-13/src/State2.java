
public class State2 implements Comparable<State2>{
	public String name;
	private String abbreviation;
	public State2(String name,String abbreviation) {
		this.name=name;
		this.abbreviation=abbreviation;
	}
	public String toString() {
		return name+" "+abbreviation;
	}
	public String getName() {
		return name;
	}
	public int compareTo(State2 other) {
		
			return name.compareTo(other.getName());
		
	}
	public int hashCode() {
		return ((int)abbreviation.charAt(0))*29+((int)abbreviation.charAt(1))*31;
	}
	public boolean equals(Object other) {
		return other.hashCode()==hashCode();
	}
}	
