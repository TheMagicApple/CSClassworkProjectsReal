import java.util.Scanner;
public class Trivia {
	public static Scanner s=new Scanner(System.in);
	public static int score=0;
	public static void main(String[] args) {
		System.out.println(trivia("Hg is the chemical symbol of which element","Mercury"));
		System.out.println(trivia("What is the highest waterfall in the world?","Angel Falls"));
		System.out.println(trivia("What is the world's biggest island?","Greenland"));
		System.out.println(trivia("Who played Neo in the Matrix?","Keanu Reeves"));
		System.out.println(trivia("What is the only American state that begins with the letter p?","Pennsylvania"));
		System.out.println("You got a "+score+" out of 5!");
	}
	public static String trivia(String question,String answer) {
		System.out.println(question);
		String playeranswer;
		if(answer.contains(" ")) {
			s.nextLine();
			playeranswer=s.nextLine();
		}else {
			playeranswer=s.next();
		}
		if(playeranswer.equals(answer)) {
			score++;
			return "Correct";
			
		}else {
			return "Incorrect";
		}
	}

}
