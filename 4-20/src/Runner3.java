public class Runner3{
	public static void main(String[] args){
		
		StepTracker tr = new StepTracker(10000);
		
		System.out.println("activeDays: " + tr.activeDays());
		System.out.println("averageSteps: " + tr.averageSteps());
		
		tr.addDailySteps(9000);
		tr.addDailySteps(5000);
		
		System.out.println("\nactiveDays: " + tr.activeDays());
		System.out.println("averageSteps: " + tr.averageSteps());
		
		tr.addDailySteps(13000);
		
		System.out.println("\nactiveDays: " + tr.activeDays());
		System.out.println("averageSteps: " + tr.averageSteps());
		
		tr.addDailySteps(23000);
		tr.addDailySteps(1111);
		
		System.out.println("\nactiveDays: " + tr.activeDays());
		System.out.println("averageSteps: " + tr.averageSteps());
	}
}