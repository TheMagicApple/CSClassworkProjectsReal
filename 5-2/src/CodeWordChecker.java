
public class CodeWordChecker implements StringChecker{
	private int minLen;
	private int maxLen;
	private String badString;
	public CodeWordChecker(String badString) {
		minLen=6;
		maxLen=20;
		this.badString=badString;
	}
	public CodeWordChecker(int minLen,int maxLen,String badString) {
		this.minLen=minLen;
		this.maxLen=maxLen;
		this.badString=badString;
	}
	@Override
	public boolean isValid(String str) {
		if(str.length()>=minLen && str.length()<=maxLen) {
			if(str.indexOf(badString)==-1) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}
