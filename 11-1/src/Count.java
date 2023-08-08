
public class Count {
	public int getTotal(int n) {
		int i=2;
		int total=0;
		if(n%2==0) {
			while(i<=n) {
				total+=i;
				i+=2;
			}
		}else {
			while(i<=n-1) {
				total+=i;
				i+=2;
			}
		}
		
		return total;
	}
}
