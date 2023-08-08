
public class Test {

	public static void main(String[] args) {
		drawFilledBox();
		drawMultiChart();

	}
	public static void drawFilledBox() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void drawMultiChart() {
		for(int i=1;i<=9;i++) {
			for(int k=1;k<=9;k++) {
				if(i*k>=10) {
					System.out.print(i*k+"\t");
				}else {
					System.out.print(i*k+"\t");
				}
				
			}
			System.out.println();
		}
	}

}
