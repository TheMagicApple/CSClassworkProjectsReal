
public class Friend {
	private String name;
	private String school;
	private String email;
	private int id;
	public static int nextId=0;
	private String password;
	public Friend(String name,String school,String email,String password) {
		this.name=name;
		this.school=school;
		this.email=email;
		this.id=nextId;
		this.password=password;
		nextId++;
	}
	public Friend(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public String getSchool() {
		return school;
	}
	public String getEmail() {
		return email;
	}
	public int getID() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public int hashCode() {
		return id;
	}
	public String toString() {
		return id+":"+name+"("+password+")";
	}
	
	public boolean equals(Object o) {
		return hashCode()==o.hashCode();
	}
	
}
