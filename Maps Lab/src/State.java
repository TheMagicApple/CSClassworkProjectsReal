public class State {
	private String name;
	private String abbreviation;
	public State(String name,String abbreviation) {
		this.name=name;
		this.abbreviation=abbreviation;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	@Override
	public int hashCode() {
		return abbreviation.charAt(0)*29+abbreviation.charAt(1)*29;
	}
	@Override
	public boolean equals(Object other) {
		return ((State) other).getAbbreviation().equals(abbreviation);
	}
	@Override
	public String toString() {
		return name+" "+abbreviation;
	}
}