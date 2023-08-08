public class GrayImage 
{ 
	public static final int BLACK = 0; 
	public static final int WHITE = 255; 

 
	/** The 2-dimensional representation of this image. Guaranteed not to be null. 
	*  All values in the array are within the range [BLACK, WHITE], inclusive. 
	*/ 
	private int[][] pixelValues; 

	public GrayImage(int[][] pixelValues)
	{
		this.pixelValues = pixelValues; 
	}


	/** @return the total number of white pixels in this image.  
	*  Postcondition: this image has not been changed. 
	*/ 
	public int countWhitePixels() 
	{  /* to be implemented in part (a) */ 
		int count=0;
		for(int a=0;a<pixelValues.length;a++) {
			for(int b=0;b<pixelValues[a].length;b++) {
				if(pixelValues[a][b]==WHITE) {
					count++;
				}
			}
		}
		return count;
	
		
	} 
	
	public void processImage() 
	{  /* to be implemented in part (b) */  
		for(int a=0;a<pixelValues.length;a++) {
			for(int b=0;b<pixelValues[a].length;b++) {
				if(a+2<pixelValues.length && b+2<pixelValues[a].length) {
					pixelValues[a][b]-=pixelValues[a+2][b+2];
					if(pixelValues[a][b]<BLACK) {
						pixelValues[a][b]=BLACK;
					}
				}
			}
				
		}
	} 
	
	public void printPixels()
	{
		for(int row=0; row < pixelValues.length; row++)
		{
			for(int col=0; col < pixelValues[row].length; col++)
			{
				System.out.print( pixelValues[row][col] + "\t" );
			}
			System.out.println("");
		}
	}
}