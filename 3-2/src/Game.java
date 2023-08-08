
public class Game {
	private int[][] table;
	private int turn;
	public Game() {
		table=new int[3][3];
		turn=1;
		
	}
	public void printTable() {
		for(int a=0;a<table.length;a++) {
			for(int b=0;b<table[a].length;b++) {
				if(table[a][b]==1) {
					System.out.print("X");
				}else if(table[a][b]==2) {
					System.out.print("O");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public void insertXO(int a,int b) {
		if(table[a][b]==0) {
			table[a][b]=turn;
		}
		if(turn==1) {
			turn=2;
		}else {
			turn=1;
		}
		
	}
	public boolean checkFull() {
		for(int a=0;a<table.length;a++) {
			for(int b=0;b<table[a].length;b++) {
				if(table[a][b]==0) {
					return false;
				}
			}
		}
		return true;
	}
	public int checkTicTacToe() {
		int lookingFor=1;
		for(int a=0;a<table.length;a++) {
			if(table[a][0]==lookingFor && table[a][1]==lookingFor && table[a][2]==lookingFor) {
				return lookingFor;
			}
		}
		for(int b=0;b<table[0].length;b++) {
			if(table[0][b]==lookingFor && table[1][b]==lookingFor && table[2][b]==lookingFor) {
				return lookingFor;
			}
		}
		if(table[0][0]==lookingFor && table[1][1]==lookingFor && table[2][2]==lookingFor) {
			return lookingFor;
		}
		if(table[0][2]==lookingFor && table[1][1]==lookingFor && table[2][0]==lookingFor) {
			return lookingFor;
		}
		lookingFor=2;
		for(int a=0;a<table.length;a++) {
			if(table[a][0]==lookingFor && table[a][1]==lookingFor && table[a][2]==lookingFor) {
				return lookingFor;
			}
		}
		for(int b=0;b<table[0].length;b++) {
			if(table[0][b]==lookingFor && table[1][b]==lookingFor && table[2][b]==lookingFor) {
				return lookingFor;
			}
		}
		if(table[0][0]==lookingFor && table[1][1]==lookingFor && table[2][2]==lookingFor) {
			return lookingFor;
		}
		if(table[0][2]==lookingFor && table[1][1]==lookingFor && table[2][0]==lookingFor) {
			return lookingFor;
		}
		return 0;
	}
	
}
