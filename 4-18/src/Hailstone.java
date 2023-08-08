public class Hailstone
{
	/** Returns the length of a hailstone sequence that starts with n,
	* as described in part (a).
	* Precondition: n>0
	*/
	public static int hailstoneLength(int n)
	{ /* to be implemented in part (a) */ 
		int length=1;
		while(n!=1) {
			length++;
			if(n%2==1) {
				n=n*3;
				n+=1;
			}else {
				n=n/2;
			}
		}
		return length;
	}
	
	
	/** Returns true if the hailstone sequence that starts with n is considered long
	* and false otherwise, as described in part (b).
	* Precondition: n>0
	*/
	public static boolean isLongSeq(int n)
	{ /* to be implemented in part (b) */
		int length=hailstoneLength(n);
		return length>n;
		//return hailstoneLength(n)>n;
	}
	
	
	/** Returns the proportion of the first n hailstone sequences that are considered long,
	* as described in part (c).
	* Precondition: n>0
	*/
	
	public static double propLong(int n)
	{ /* to be implemented in part (c) */ 
		double nLong=0;
		for(int i=1;i<=n;i++) {
			if(isLongSeq(i)) {
				nLong++;
			}
		}
		return nLong/n;
	}
	// There may be instance variables, constructors, and methods not shown.
}
