
public class MyMath {
	public void countDown(int x) {
		System.out.println(x);
		if(x>0) countDown(x-1);
	}
	public void countUp(int x) {
		
		if(x>1)countUp(x-1);
		System.out.println(x);
	}
	public int factorial(int x) {
		if(x==1)return 1;
		else return x*factorial(x-1);
	}
	public int summation(int x) {
		if(x==1)return 1;
		else return x+summation(x-1);
	}
}
