public class CombinedTable{
	private SingleTable t1;
	private SingleTable t2;
	public CombinedTable(SingleTable t1,SingleTable t2) {
		this.t1=t1;
		this.t2=t2;
	}
	public boolean canSeat(int people) {
		int maxSeats=t1.getNumSeats()+t2.getNumSeats()-2;
		if(people<=maxSeats) {
			return true;
		}else {
			return false;
		}
	}
	public double getDesirability() {
		if(t1.getHeight()==t2.getHeight()) {
			return (double)(t1.getViewQuality()+t2.getViewQuality())/2;
		}else {
			return ((double)(t1.getViewQuality()+t2.getViewQuality())/2)-10;
		}
	}
}