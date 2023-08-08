
public class Location {
	public int x;
	public int y;
	public String name;
	public String abbreviation;
	public Location(int x,int y,String name) {
		this.x=x;
		this.y=y;
		this.name=name;
		this.abbreviation=String.valueOf(name.charAt(0))+String.valueOf(name.charAt(1))+String.valueOf(name.charAt(2));
	}
	public int hashCode() {
		return abbreviation.charAt(0)*29+abbreviation.charAt(1)*31+abbreviation.charAt(2)*37;
	}
	public boolean equals(Object o) {
		if(o==null)return false;
		return hashCode()==o.hashCode();
	}
	public String toString() {
		return abbreviation;
	}
}
