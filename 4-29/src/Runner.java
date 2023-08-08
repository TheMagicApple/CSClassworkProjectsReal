public class Runner {
	public static void main(String[] args){
		SingleTable t1 = new SingleTable(4, 60.0, 74);
		SingleTable t2 = new SingleTable(8, 70.0, 74);
		SingleTable t3 = new SingleTable(12, 75.0, 76);
		
		CombinedTable c1 = new CombinedTable(t1, t2);
		System.out.println( "CombinedTable c1 = new CombinedTable(t1, t2)" );
		System.out.println( "c1.canSeat(9) - " + c1.canSeat(9) );
		System.out.println( "c1.canSeat(11) - " + c1.canSeat(11) );
		System.out.println( "c1.getDesirability() - " + c1.getDesirability() );
		
		CombinedTable c2 = new CombinedTable(t2, t3);
		System.out.println( "\nCombinedTable c2 = new CombinedTable(t1, t3);" );
		System.out.println( "c2.canSeat(18) - " + c2.canSeat(18) );
		System.out.println( "c2.getDesirability() - " + c2.getDesirability() );
		System.out.println( "t2.setViewQuality(80)");
		t2.setViewQuality(80);
		System.out.println( "c2.getDesirability() - " + c2.getDesirability() );
	}
}
