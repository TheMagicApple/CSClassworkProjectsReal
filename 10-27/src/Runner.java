import java.util.Scanner;
public class Runner {

	public static void main(String[] args) {
		Scanner realS=new Scanner(System.in);
		Selection s=new Selection();
		System.out.println("Enter a zip code: ");
		System.out.println(s.zipCode1(realS.nextInt()));
		System.out.println("Enter another zip code: ");
		System.out.println(s.zipCode2(realS.nextInt()));
		System.out.println("Enter another zip code: ");
		System.out.println(s.zipCode3(realS.nextInt()));
	}

}
