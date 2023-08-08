
public class Profile {
	private static String[] careers= {"Scientist","Coder","Mathmetician","Author","Chef","Construction worker","Financial advisor","Physicist","Journalist","Lawyer","Screenwriter","Biochemical engineer"};
	private String name;
	private int age;
	private String subject;
	private String hobby;
	private String food;
	public Profile(String name,int age,String subject,String hobby,String food) {
		this.name=name;
		this.age=age;
		this.subject=subject;
		this.hobby=hobby;
		this.food=food;
	}
	public void printInfo() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Subject: "+subject);
		System.out.println("Hobby: "+hobby);
		System.out.println("Food: "+food);
		printCareer();
	}
	private void printCareer() {
		System.out.println("The perfect career is...");
		int career=0;
		if(subject.equals("Math")) {
			if(hobby.equals("Creating things")) {
				if(food.equals("Pizza")) {
					career=7;
				}else {
					career=2;
				}
			}else {
				if(food.equals("Pizza")) {
					career=5;
				}else {
					career=6;
				}
			}
		}
		if(subject.equals("English")) {
			if(hobby.equals("Creating things")) {
				if(food.equals("Pizza")) {
					career=3;
				}else {
					career=8;
				}
			}else {
				if(food.equals("Pizza")) {
					career=10;
				}else {
					career=9;
				}
			}
		}
		if(subject.equals("Science")) {
			if(hobby.equals("Creating things")) {
				if(food.equals("Pizza")) {
					career=4;
				}else {
					career=0;
				}
			}else {
				if(food.equals("Pizza")) {
					career=1;
				}else {
					career=11;
				}
			}
		}
		System.out.println(careers[career]+"!");
	}
	public void updateProfile(String name,int age,String subject,String hobby,String food) {
		this.name=name;
		this.age=age;
		this.subject=subject;
		this.hobby=hobby;
		this.food=food;
	}
}
