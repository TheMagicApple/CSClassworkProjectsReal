
public class State {
	private String name;
	private String abbreviation;
	public State(String name,String abbreviation) {
		this.name=name;
		this.abbreviation=abbreviation;
	}
	public String getName() {
		return name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	@Override
	public int hashCode() {
		int first=abbreviation.charAt(0)-96;
		int second=abbreviation.charAt(1)-96;
		return first*26+second;
	}
	@Override
	public boolean equals(Object other) {
		State otherState=(State)other;
		if(otherState.getAbbreviation().equals(abbreviation)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return name+" "+abbreviation;
	}
	
}
