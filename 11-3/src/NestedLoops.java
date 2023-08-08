
public class NestedLoops {
	public void drawFilledBox() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void drawFilledBox(int a,int b) {
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void drawMultiChart() {
		for(int i=1;i<=9;i++) {
			for(int k=1;k<=9;k++) {
				if(i*k>=10) {
					System.out.print(i*k+"  ");
				}else {
					System.out.print(i*k+"   ");
				}
				
			}
			System.out.println();
		}
	}
	public void drawTriangle() {
		for(int i=1;i<=5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
