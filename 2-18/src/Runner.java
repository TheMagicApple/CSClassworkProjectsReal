import java.util.ArrayList;
import java.util.List;

public class Runner
{
	public static void main(String[] args)
	{
		Scramble s = new Scramble();
		
		System.out.println( "Testing part A " );
		System.out.println( s.scrambleWord("TAN") );
		System.out.println( s.scrambleWord("ABRACADABRA") );
		System.out.println( s.scrambleWord("WHOA") );
		System.out.println( s.scrambleWord("AARDVARK") );
		System.out.println( s.scrambleWord("EGGS") );
		System.out.println( s.scrambleWord("A") );
		System.out.println();
		
		List<String> wordList = new ArrayList<String>();
		wordList.add("TAN");
		wordList.add("ABRACADABRA");
		wordList.add("WHOA");
		wordList.add("APPLE");
		wordList.add("EGGS");
		
		System.out.println( "Testing part B " );
		s.scrambleOrRemove( wordList);
		System.out.println( wordList );
	}
}