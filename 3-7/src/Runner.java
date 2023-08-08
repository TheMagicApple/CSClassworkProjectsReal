
public class Runner {

	public static void main(String[] args) {
		int[][] i=new int[4][5];
		for(int a=0;a<i.length;a++) {
			for(int b=0;b<i[a].length;b++) {
				i[a][b]=(int)(Math.random()*50+1);
			}
		}
		WarmUp w=new WarmUp(i);
		w.print();
		System.out.println(w.findLargest());

	}

}
