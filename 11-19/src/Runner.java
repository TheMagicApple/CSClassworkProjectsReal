
public class Runner {

	public static void main(String[] args) {
		int[] array=new int[5];
		for(int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*9+1);
		}
		ArrayQuiz a=new ArrayQuiz(array);
		a.print();
		int total=a.getSummation();
		System.out.println("Total: "+total);
		int largest=a.getLargest();
		System.out.println("Largest: "+largest);

	}

}
