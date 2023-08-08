import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



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
					//System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public void computer() {
		boolean played=false;
		while(!played) {
			int x=(int)(Math.random()*3);
			int y=(int)(Math.random()*3);
			if(table[x][y]==0) {
				table[x][y]=2;
				played=true;
				break;
			}
		}
	}
	public void insertXO(int a,int b) {
		if(table[a][b]==0) {
			table[a][b]=1;
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
	public void drawMe(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(230, 100, 10, 400);
		g.fillRect(370, 100, 10, 400);
		g.fillRect(100,230, 400, 10);
		g.fillRect(100,370, 400, 10);
		int x=130;
		int y=190;
		Font font = new Font("Arial", Font.PLAIN, 80);
		g.setFont(font);
		for(int a=0;a<table.length;a++) {
			for(int b=0;b<table[a].length;b++) {
				if(table[a][b]==1) {
					g.drawString("X", x, y);
				}else if(table[a][b]==2) {
					g.drawString("O", x, y);
				}else {
					//g.drawString("*", x, y);
					//System.out.println("asterisk");
				}
				x+=140;
			}
			y+=140;
			x=130;
		}
	}
	public void restart() {
		for(int a=0;a<3;a++) {
			for(int b=0;b<3;b++) {
				table[a][b]=0;
			}
		}
	}
	
}

