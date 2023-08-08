
public class ForTest2 {
	public void printCount(int a,int b) {
		for(int i=a;i<=b;i++) {
			System.out.println(i);
		}
	}
	public int getSum(int a) {
		int total=0;
		for(int i=1;i<=a;i++) {
			total+=i;
		}
		return total;
	}
}
