public class Runner {
	public static void main(String[] args){
		
		System.out.println("Testing Part A");
		System.out.println( "1900-1999 :" + APCalendar.numberOfLeapYears(1900, 1999) );
		System.out.println( "2000-2020 :" + APCalendar.numberOfLeapYears(2000, 2020) );
	
		System.out.println("\nTesting Part B");
		System.out.println( "dayOfWeek(1, 5, 2019): " + APCalendar.dayOfWeek(1, 5, 2019) );
		System.out.println( "dayOfWeek(1, 10, 2019): " + APCalendar.dayOfWeek(1, 10, 2019) );
		
	
	}
}
