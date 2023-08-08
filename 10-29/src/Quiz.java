
public class Quiz {
	public void countUpBy2(int i) {
		int k=0;
		while(k<=i) {
			System.out.println(k);
			k+=2;
		}
	}
	public int getSummation(int i) {
		int j=1;
		int total=0;
		while(j<=i) {
			total+=j;
			j++;
		}
		return total;
	}
}
