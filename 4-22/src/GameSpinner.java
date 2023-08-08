
public class GameSpinner {
	private int sectors;
	private int previousSpin=0;
	private int streak=0;
	public GameSpinner(int sectors) {
		this.sectors=sectors;
	}
	public int spin() {
		int result=(int)(Math.random()*sectors+1);
		if(previousSpin==result) {
			streak++;
		}else {
			streak=1;
		}
		previousSpin=result;
		return result;
	}
	public int currentRun() {
		return streak;
	}
}
