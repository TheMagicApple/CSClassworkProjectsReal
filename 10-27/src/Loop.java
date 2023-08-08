
public class Loop {
	private int min;
	private int max;
	public Loop(int min,int max) {
		this.min=min;
		this.max=max;
	}
	public void countWhile() {
		int count=min;
		while(count<=max) {
			System.out.println(count);
			count+=2;
		}
	}
	public int getSum() {
		int total=0;
		int count=min;
		do {
			total+=count;
			count+=1;
		}while(count<=max);
		return total;
		
	}
}
