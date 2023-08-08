public class SingleTable 
{
	private int seats;
	private double viewQuality;
	private int height;
	
	public SingleTable(int seats, double viewQuality, int height){
		this.seats = seats;
		this.viewQuality = viewQuality;
		this.height = height;
	}
	
	/** Returns the number of seats at this table. The value is always greater than or equal to 4. */
	public int getNumSeats() 
	{ 
		return seats;
	} 
	
	/** Returns the height of this table in centimeters. */ 
	public int getHeight() 
	{
		return height;
	} 
	
	/** Returns the quality of the view from this table. */ 
	public double getViewQuality() 
	{ 
		return viewQuality;
	} 
	
	/** Sets the quality of the view from this table to value . */ 
	public void setViewQuality(double value) 
	{
		viewQuality = value;
	} 
	
	// There may be instance variables, constructors, and methods that are not shown. 
} 
