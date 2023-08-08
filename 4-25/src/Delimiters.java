import java.util.ArrayList;

public class Delimiters
{
	/** The open and close delimiters. */
	private String openDel;
	private String closeDel;
	
	/** Constructs a Delimiters object where open is the open delimiter and close is the
	* close delimiter.
	* Precondition: open and close are non-empty strings.
	*/
	public Delimiters(String open, String close)
	{
		openDel = open;
		closeDel = close;
	}
	
	/** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
	public ArrayList<String> getDelimitersList(String[] tokens)
	{ /* to be implemented in part (a) */
		ArrayList<String> d=new ArrayList<>();
		for(String token:tokens) {
			if(token.equals(openDel) || token.equals(closeDel)) {
				d.add(token);
			}
		}
		return d;
	}
	
	
	/** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
	* Precondition: delimiters contains only valid open and close delimiters.
	*/
	public boolean isBalanced(ArrayList<String> delimiters)
	{ /* to be implemented in part (b) */ 
		int open=0;
		int closed=0;
		for(String delimiter:delimiters) {
			if(delimiter.equals(openDel)) {
				open++;
			}else {
				closed++;
			}
			if(closed>open) {
				return false;
			}
		}
		if(open!=closed) {
			return false;
		}else {
			return true;
		}
	}
	// There may be instance variables, constructors, and methods that are not shown.
} 
