
public class State implements Comparable<State>{
	private String name;
	private String abbreviation;
	public State(String name) {
		this.name=name;
		
	}
	public String toString() {
		return name+" ";
	}
	public String getName() {
		return name;
	}
	public int compareTo(State other) {
		
			return name.compareTo(other.getName());
		
	}
	public int hashCode() {
		return ((int)abbreviation.charAt(0))*29+((int)abbreviation.charAt(1))*31;
	}
	public boolean equals(Object other) {
		return other.hashCode()==hashCode();
	}
}	
