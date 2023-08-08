
public class Country {
	private String name;
	private String abbreviation;
	public Country(String name,String abbreviation) {
		this.name=name;
		this.abbreviation=abbreviation;
	}
	public String getName() {
		return name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public int hashCode() {
		return abbreviation.charAt(0)+abbreviation.charAt(1)*29;
	}
	public String toString() {
		return abbreviation+" - "+name;
	}
	
}

