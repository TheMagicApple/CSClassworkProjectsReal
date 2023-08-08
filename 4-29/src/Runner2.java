public class Runner2 {
	public static void main(String[] args){
		
		System.out.println("Testing Part A: ");
		System.out.println("Secret Word: mississippi");
		WordMatch game = new WordMatch("mississippi");
		System.out.println("Guess is i, scoreGuess=" + game.scoreGuess("i"));
		System.out.println("Guess is iss, scoreGuess=" + game.scoreGuess("iss"));
		System.out.println("Guess is issipp, scoreGuess=" + game.scoreGuess("issipp"));
		System.out.println("Guess is mississippi, scoreGuess=" + game.scoreGuess("mississippi"));
		
		
		System.out.println("\nSecret Word: aaaabb");
		game = new WordMatch("aaaabb");
		System.out.println("Guess is a, scoreGuess=" + game.scoreGuess("a"));
		System.out.println("Guess is aa, scoreGuess=" + game.scoreGuess("aa"));
		System.out.println("Guess is aaa, scoreGuess=" + game.scoreGuess("aaa"));
		System.out.println("Guess is aabb, scoreGuess=" + game.scoreGuess("aabb"));
		System.out.println("Guess is c, scoreGuess=" + game.scoreGuess("c"));
		
		
		System.out.println("\nTesting Part B");
		game = new WordMatch("concatenation"); 
		System.out.println("Comparing ten and nation.");
		System.out.println("Better guess is: " + game.findBetterGuess("ten" , "nation"));
		System.out.println("Comparing con and cat.");
		System.out.println("Better guess is: " + game.findBetterGuess("con" , "cat"));
	}
}
