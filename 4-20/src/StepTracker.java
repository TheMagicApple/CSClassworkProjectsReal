import java.util.ArrayList;

public class StepTracker {
	private int minSteps;
	ArrayList<Integer> stepTracks=new ArrayList<>();
	public StepTracker(int minSteps) {
		this.minSteps=minSteps;
	}
	public void addDailySteps(int steps) {
		stepTracks.add(steps);
	}
	public int activeDays() {
		if(stepTracks.size()==0) {
			return 0;
		}else {
			int n=0;
			for(int stepTrack:stepTracks) {
				if(stepTrack>minSteps) {
					n++;
				}
			}
			return n;
		}
	}
	public double averageSteps() {
		if(stepTracks.size()==0) {
			return 0.0;
		}else {
			double total=0;
			for(int stepTrack:stepTracks) {
				total+=stepTrack;
			}
			return total/stepTracks.size();
		}
		
	}
}
