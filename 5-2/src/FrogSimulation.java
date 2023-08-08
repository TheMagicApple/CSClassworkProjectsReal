public class FrogSimulation
{
	private int goalDistance;
	private int maxHops;
	
	private int[] hopValues;
	private int hopIndex = 0;
	
	private int[][] hopValuesMatrix;
	private int row=0;
	private int col=0;
	
	
	private int maxHopsHolder;
	private String part; 
	
	public FrogSimulation(int dist, int numHops)
	{
		goalDistance = dist;
		maxHops = numHops;
		maxHopsHolder = numHops;
	}

	private int hopDistance()
	{ 
		if( this.part.equals("A") )
		{
			int value = 0;
			if( hopValues != null && hopIndex < hopValues.length )
			{
				value = hopValues[hopIndex];
				hopIndex++;
			}
			
			return value;
		}
		else if (this.part.equals("B"))
		{
			int value = 0;
			if( hopValuesMatrix != null && row < hopValuesMatrix.length )
			{
				value = hopValuesMatrix[row][col];
				
				col++;
				
				if( col == hopValuesMatrix[row].length ){
					col = 0;
					row++;
				}
			}
			
			return value;
		} else {
			return 0;
		}
	}
	
	public boolean simulate()
	{ 
		/* to be implemented in part (a) */
		int spot=0;
		int hops=0;
		while(true) {
			spot+=hopDistance();
			hops++;
			if(spot<0) {
				return false;
			}
			if(spot>=goalDistance) {
				return true;
			}
			if(hops>=maxHops) {
				return false;
			}
		}
	}
	
	public double runSimulations(int num)
	{ 
		/* to be implemented in part (b) */ 
		int good=0;
		for(int i=0;i<num;i++) {
			boolean sim=simulate();
			if(sim) {
				good++;
			}
		}
		return (double)good/num;
	}
	
	public void setPart(String letter ){
		this.part = letter;
	}
	
	public void setHopValues(int[] hopValues)
	{
		this.hopValues = hopValues;
		this.hopIndex = 0;
		this.maxHops = maxHopsHolder;
	}
	
	public void setMultipleHopValues(int[][] hopValuesMatrix){
		this.hopValuesMatrix = hopValuesMatrix;
		this.row = 0;
		this.col = 0;
	}
	
	
	
	
} 

