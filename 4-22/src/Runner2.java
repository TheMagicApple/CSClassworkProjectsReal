public class Runner2 {
	public static void main(String[] args){
	
		GameSpinner g = new GameSpinner(4);
		int currentRunTest = 0;
		int lastValue = 0;
		
		int currentRun = g.currentRun();
		System.out.print("currentRun: " + currentRun);
		if( currentRun == 0 ){
			System.out.println(" - Correct");
		}else {
			System.out.println(" - Incorrect");
		}
		
		for(int i=0; i<10; i++){
			int spin = g.spin();
			System.out.print("spin: " + spin);
			if( spin >= 1 && spin <= 4){
				System.out.println(" - Correct");
			}else {
				System.out.println(" - Incorrect");
			}
			if(spin == lastValue ){
				currentRunTest++;
			} else {
				currentRunTest = 1;
				lastValue = spin;
			}
			
			
			currentRun = g.currentRun();
			System.out.print("currentRun: " + currentRun);
			if( currentRun == currentRunTest ){
				System.out.println(" - Correct");
			}else {
				System.out.println(" - Incorrect");
			}
		}
		
	
		
	
	}

}
