
public class Ticket implements Comparable<Ticket>{
	public String name;
	public String description;
	public boolean high;
	public long time;
	public String note;
	public Ticket(String name,String description,boolean high,long time,String note) {
		this.name=name;
		this.description=description;
		this.high=high;
		this.time=time;
		this.note=note;
	}
	public String toString() {
		return name+"("+high+"): "+description+", "+note+" ( "+time+")";
	}
	public int compareTo(Ticket o) {
		return (o.high?1:0)-(high?1:0);
	}
	
}
