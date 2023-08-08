import java.util.Scanner;



public class SubjectTest{
	
	public static void main(String[] args){
		boolean done = false;
		Scanner s=new Scanner(System.in);
		while (!done) {
		System.out.println("What class would you like to attend?");
		System.out.println("1.) Math");
		System.out.println("2.) History");
		System.out.println("3.) Art");
		System.out.println("4.) Done");
		int choice = s.nextInt();
		
		if (choice == 1) {
			int mathscore=0;
			System.out.println("Welcome to Math.");
			System.out.println("What is 3*5");
			int answer1=s.nextInt();
			if(answer1==15) {
				System.out.println("good");
				mathscore++;
			}else {
				System.out.println("bad");
			}
			System.out.println("What is 24/3");
			int answer2=s.nextInt();
			if(answer2==8) {
				System.out.println("good");
				mathscore++;
			}else {
				System.out.println("bad");
			}
			System.out.println("Solve x=5 for x");
			int answer3=s.nextInt();
			if(answer3==5) {
				System.out.println("good");
				mathscore++;
			}else {
				System.out.println("bad");
			}
			System.out.println("What is 9-7");
			int answer4=s.nextInt();
			if(answer4==2) {
				System.out.println("good");
				mathscore++;
			}else {
				System.out.println("bad");
			}
			System.out.println("You got a "+mathscore+" out of 4");
			
			
		}
		
		if (choice == 2){
			int historyscore=0;
			System.out.println("Welcome to History.");
			System.out.println("What is the capital of China");
			String answerHistory1 = s.next();
			if (answerHistory1.equals ("Beijing")) {
				System.out.println("good");
				historyscore++;
			}
			else {
				System.out.println("bad");
			}
			System.out.println("Where was the Declaration of Independance signed?");
			String answerHistory2 = s.next();
			if (answerHistory2.equals ("Philadelphia")) {
				System.out.println("good");
				historyscore++;
			}
			else {
				System.out.println("bad");
			}
			System.out.println("What was the 13th amendment?");
			s.nextLine();
			String answerHistory3 = s.nextLine();
			if (answerHistory3.equals ("It freed slaves")) {
				System.out.println("good");
				historyscore++;
			}
			else {
				System.out.println("bad");
			}
			System.out.println("What were Jim Crow Laws");
			String answerHistory4 = s.next();
			if (answerHistory4.equals ("Segregation")) {
				System.out.println("good");
				historyscore++;
			}
			else {
				System.out.println("bad");
			}
			System.out.println("You got a "+historyscore+" out of 4");
			
		}
		if(choice==3) {
			System.out.println("Welcome to Art");
			int artscore=0;
			System.out.println("____");
			System.out.println("|  |");
			System.out.println("|__|");
			String artanswer1=s.next();
			if(artanswer1.equals("Square")) {
				System.out.println("good");
				artscore++;
			}else {
				System.out.println("bad");
			}
			System.out.println(" /\\ ");
			System.out.println("/  \\");
			System.out.println("----");
			String artanswer2=s.next();
			if(artanswer2.equals("Triangle")) {
				System.out.println("good");
				artscore++;
			}else {
				System.out.println("bad");
			}
			System.out.println("()");
			String artanswer3=s.next();
			if (artanswer3.equals ("Circle")) {
				System.out.println("good");
				artscore++;
			}
			else {
				System.out.println("bad");
			}
			System.out.println("____________");
			System.out.println("|          |");
			System.out.println("|__________|");
			String artanswer4=s.next();
			if(artanswer4.equals("Rectangle")) {
				System.out.println("good");
				artscore++;
			}else {
				System.out.println("bad");
			}
			System.out.println("You got a "+artscore+" out of 4");
			
			
		}
		if (choice == 4) {
			done = true;
		}
				
		

	}
	
}
}

