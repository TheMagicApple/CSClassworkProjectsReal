public class Theater
{
	private Seat[][] theaterSeats;
	
	/** Constructs a Theater object, as described in part (a).
	* Precondition: seatsPerRow > 0; tier1Rows > 0; tier2Rows >= 0
	*/
	public Theater(int seatsPerRow, int tier1Rows, int tier2Rows)
	{ 
		/* to be implemented in part (a) */
		theaterSeats=new Seat[tier1Rows+tier2Rows][seatsPerRow];
		for(int i=0;i<tier1Rows;i++) {
			for(int k=0;k<seatsPerRow;k++) {
				theaterSeats[i][k]=new Seat(true,1);
			}
		}
		for(int i=tier1Rows;i<theaterSeats.length;i++) {
			for(int k=0;k<seatsPerRow;k++) {
				theaterSeats[i][k]=new Seat(true,2);
			}
		}
	}
		
		
	/** Returns true if a seat holder was reassigned from the seat at fromRow, fromCol
	* to the seat at toRow, toCol; otherwise it returns false, as described in part (b).
	* Precondition: fromRow, fromCol, toRow, and toCol represent valid row and
	* column positions in the theater.
	* The seat at fromRow, fromCol is not available.
	*/
	public boolean reassignSeat(int fromRow, int fromCol,
	int toRow, int toCol)
	{ 
		/* to be implemented in part (b) */ 
		Seat currentSeat=theaterSeats[fromRow][fromCol];
		Seat newSeat=theaterSeats[toRow][toCol];
		if(newSeat.isAvailable() && newSeat.getTier()>=currentSeat.getTier()) {
			theaterSeats[fromRow][fromCol].setAvailability(true);
			theaterSeats[toRow][toCol].setAvailability(false);
			return true;
		}else {
			return false;
		}
		
	}
	
	public void assignSeat(int row, int col){
		theaterSeats[row][col].setAvailability(false);
	}
	
	public String toString(){
		String str = "";
		for(int r=0; r<theaterSeats.length; r++){
			str += theaterSeats[r][0].getTier() + ": ";
			for(int c=0; c<theaterSeats[r].length; c++){
				if( theaterSeats[r][c].isAvailable() ){
					str += "-";
				} else {
					str += "X";
				}
			}
			str += "\n";
		}
		return str;
	}
}
