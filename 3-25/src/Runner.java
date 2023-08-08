import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		Programmer p=new Programmer("Jennifer","gaming");
		Doctor d=new Doctor("Maria","reading");
		ArrayList<Profile> profiles=new ArrayList<Profile>();
		profiles.add(p);
		profiles.add(d);
		for(Profile profile:profiles) {
			profile.printInfo();
		}

	}

}
