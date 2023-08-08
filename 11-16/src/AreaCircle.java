
public class AreaCircle implements Runnable{
	private int radius;
	private double area;
	public AreaCircle(int radius) {
		this.radius=radius;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("");
			
		}
		area=Math.PI*radius*radius;
		
	}
	public double getArea() {
		return area;
	}

}
