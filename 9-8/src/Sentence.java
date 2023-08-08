import java.util.Scanner;
public class Sentence {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a verb.");
		String verb=s.next();
		System.out.println("Enter a noun.");
		String noun=s.next();
		String sentence="The "+noun+" "+verb+"s.";
		System.out.println(sentence);
	}

}
