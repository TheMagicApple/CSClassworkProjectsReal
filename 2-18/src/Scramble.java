import java.util.ArrayList;
import java.util.List;

public class Scramble
{
	/** Scrambles a given word.
	* @param word the word to be scrambled
	* @return the scrambled word (possibly equal to word)
	* Precondition: word is either an empty string or contains only uppercase letters.
	* Postcondition: the string returned was created from word as follows:
	* - the word was scrambled, beginning at the first letter and continuing from left to right
	* - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
	*/
	public static String scrambleWord(String word)
	{
		String[] wordSplit=word.split("");
		for(int i=0;i<wordSplit.length-1;i++) {
			if(wordSplit[i].equals("A")) {
				if(wordSplit[i+1].equals("A")) {
				}else {
					String temp=wordSplit[i];
					wordSplit[i]=wordSplit[i+1];
					wordSplit[i+1]=temp;
					i++;
				}
			}
		}
		return String.join("", wordSplit);
	}
	
	/** Modifies wordList by replacing each word with its scrambled
	* version, removing any words that are unchanged as a result of scrambling.
	* @param wordList the list of words
	* Precondition: wordList contains only non-null objects
	* Postcondition:
	* - all words unchanged by scrambling have been removed from wordList
	* - each of the remaining words has been replaced by its scrambled version
	* - the relative ordering of the entries in wordList is the same as it was
	* before the method was called
	*/
	public static void scrambleOrRemove(List<String> wordList)
	{
		for(int i=0;i<wordList.size();i++) {
			if(scrambleWord(wordList.get(i)).equals(wordList.get(i))) {
				wordList.remove(i);
				i--;
			}else {
				wordList.set(i, scrambleWord(wordList.get(i)));
			}
			
		}
	}
}
