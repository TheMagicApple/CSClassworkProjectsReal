
public class VolCylinder implements Runnable{
	private double area;
	private int height;
	private double volume;
	public VolCylinder(double area,int height) {
		this.area=area;
		this.height=height;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			System.out.println("AUGGGGGGGGGGGGGGGGHHHHHHHHHHHHHHHHHHHHh");
		}
		volume=area*height;
	}
	public double getVolume() {
		return volume;
	}
	
}
