import java.util.ArrayList;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Language> languages=new ArrayList<>();
		languages.add(new English());
		languages.add(new Spanish());
		languages.add(new French());
		languages.add(new Italian());
		for(Language language:languages) {
			System.out.println(language.getAuthor());
			System.out.println(language.getHello());
			System.out.println(language.getBye());
			System.out.println(language.getThankYou());
		}
		

	}

}
