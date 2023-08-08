
public class Vector {
	private double x1;
	private double y1;
	private int x2;
	private int y2;
	private double deltaX;
	private double deltaY;
	public Vector(double x1,double y1,int x2,int y2) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		
	}
	
	public double[] unitVector(){
		deltaX=x2-x1;
		deltaY=y2-y1;
		double[] i=new double[2];
		double magnitude=Math.sqrt(deltaX*deltaX+deltaY*deltaY);
		i[0]=deltaX/magnitude;
		i[1]=deltaY/magnitude;
		return i;
	}
	
}
