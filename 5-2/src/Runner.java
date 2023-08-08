public class Runner 
{
	public static void main(String[] args)
	{
		System.out.println("Example 1:");
		StringChecker sc1 = new CodeWordChecker(5, 8, "$");
		System.out.println("happy \t\t->\t" + sc1.isValid("happy"));
		System.out.println("happy$ \t\t->\t" + sc1.isValid("happy$"));
		System.out.println("Code \t\t->\t" + sc1.isValid("Code"));
		System.out.println("happyCode \t->\t" + sc1.isValid("happyCode"));
		
		System.out.println("\nExample 2:");
		StringChecker sc2 = new CodeWordChecker("pass");
		System.out.println("MyPass \t\t\t->\t" + sc2.isValid("MyPass"));
		System.out.println("Mypassport \t\t->\t" + sc2.isValid("Mypassport"));
		System.out.println("happy \t\t\t->\t" + sc2.isValid("happy"));
		System.out.println("1,000,000,000,000,000 \t->\t" + sc2.isValid("1,000,000,000,000,000"));
	}
	
}
