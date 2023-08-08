
public class Runner {

	public static void main(String[] args) {
		int[][] m1=new int[(int)(Math.random()*5+2)][(int)(Math.random()*5+2)];
		for(int a=0;a<m1.length;a++) {
			for(int b=0;b<m1[a].length;b++) {
				m1[a][b]=(int)(Math.random()*20+1);
			}
		}
		MRQuiz2 m=new MRQuiz2(m1);
		m.print();
		System.out.println(m.findLargest());
		System.out.println(m.sum());
	}

}
