import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		Game g = new Game();
		Scanner s = new Scanner(System.in);
		while(true){

			
			
			g.printTable();

			

			System.out.println("Player 1 turn (name a row)");

			int rowP1 = s.nextInt();



			System.out.println("Player 1 turn (name a column)");

			int columnP1 = s.nextInt();


			g.insertXO(rowP1, columnP1);

			g.printTable();

			int checkTicTacToe = g.checkTicTacToe();

			if (checkTicTacToe == 1){
				System.out.println("Player 1 wins");
				break;
			}
			
			if(g.checkFull() == true){
				break;
			}

			System.out.println("Player 2 turn (name a row)");

			int rowP2 = s.nextInt();



			System.out.println("Player 2 turn (name a column)");

			int columnP2 = s.nextInt();


			g.insertXO(rowP2, columnP2);

			g.printTable();


			checkTicTacToe = g.checkTicTacToe();

			

			if (checkTicTacToe == 2){
				System.out.println("Player 2 wins");
				break;
			}
			if(g.checkFull()) {
				break;
			}






			
			


		}
		

	}

}
