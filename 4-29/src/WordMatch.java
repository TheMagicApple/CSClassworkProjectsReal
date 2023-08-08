public class WordMatch 
{ 
	/** The secret string. */ 
	private String secret; 
	
	
	
	/** Constructs a WordMatch object with the given secret string of lowercase letters. */ 
	public WordMatch(String word) 
	{ 
		secret = word;
		
	} 
	
	
	
	/** Returns a score for guess, as described in part (a). 
	* Precondition: 0 < guess.length() <= secret.length() 
	*/ 
	public int scoreGuess(String guess) 
	{ /* to be implemented in part (a) */ 
		String s=secret;
		int nOccurences=0;
		int i=0;
		while(s.indexOf(guess)!=-1) {
			nOccurences++;
			i=s.indexOf(guess);
			s=s.substring(i+1,s.length());
		}
		return nOccurences*(int)Math.pow(guess.length(), 2);
		
	} 
	
	
	/** Returns the better of two guesses, as determined by scoreGuess and the rules for a 
	* tie-breaker that are described in part (b). 
	* Precondition: guess1 and guess2 contain all lowercase letters. 
	* guess1 is not the same as guess2. 
	*/ 
	public String findBetterGuess(String guess1, String guess2) 
	{ /* to be implemented in part (b) */ 
		int score1=scoreGuess(guess1);
		int score2=scoreGuess(guess2);
		if(score1==score2) {
			if(guess1.compareTo(guess2)<0) {
				return guess2;
			}else {
				return guess1;
			}
		}else {
			if(score1>score2) {
				return guess1;
			}else {
				return guess2;
			}
		}
		
	} 
} 
