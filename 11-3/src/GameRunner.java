import java.util.Scanner;
public class GameRunner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Game game=new Game();
		while(game.getBalance()>0) {
			boolean goodAnswer=false;
			while(!goodAnswer) {
				System.out.println("You have "+game.getBalance()+" tokens.");
				System.out.println("Spin the slot machine!");
				String answer=s.next();
				if(answer.equals("no")) {
					System.out.println("That is not a valid answer.");
				}else {
					goodAnswer=true;
				}
			}
			game.spin();
			System.out.println(game.getMessage());
		}
		System.out.println("You ran out of money:(");
		
		
		

	}

}
