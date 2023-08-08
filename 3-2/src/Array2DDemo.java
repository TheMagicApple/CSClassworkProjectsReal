import java.util.Scanner;

public class Array2DDemo {
	
	private void print2DInt(int[][] i) {
		for(int a=0;a<i.length;a++) {
			for(int b=0;b<i[a].length;b++) {
				System.out.print(i[a][b]+"\t");
			}
			System.out.println();
		}
	}
	public int[][] test1(){
		int[][] i=new int[5][5];
		for(int a=0;a<i.length;a++) {
			for(int b=0;b<i[a].length;b++) {
				i[a][b]=(int)(Math.random()*10+1);
			}
		}
		print2DInt(i);
		return i;
	}
	public void test3() {
		String[][] animals= {{"dog","cat","penguin"},{"bear","fish","lion"},{"bird","hamster","shark"}};
		Scanner s=new Scanner(System.in);
		for(int a=0;a<animals.length;a++) {
			for(int b=0;b<animals[a].length;b++) {
				System.out.print(animals[a][b]+"\t");
			}
			System.out.println();
		}
		System.out.println("give me an animal ");
		String animal=s.next();
		for(int a=0;a<animals.length;a++) {
			for(int b=0;b<animals[a].length;b++) {
				if(animals[a][b].equals(animal)) {
					System.out.println("yes "+a+" "+b);
					return;
				}
			}

		}
		System.out.println("no");
		
	}

	public void test2(){
		int[][] test1 = test1();

		int largest = test1[0][0];
		
		for(int i = 0; i<test1.length; i++){
			for(int j = 0; j<test1[i].length; j++){
				if(test1[i][j]>largest){
					largest = test1[i][j];
				}
			}
		}

		System.out.println(largest);
	}
}
