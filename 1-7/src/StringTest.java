
public class StringTest {
	private String myText;
	public StringTest(String text){
		myText=text;
	}
	private int getLength() {
		return myText.length();
	}
	public void printInfo() {
		System.out.println("myText: "+myText);
		System.out.println("length:"+getLength());
	}
	public void printChar(int i) {
		if(i>=myText.length()) {
			System.out.println("bruhhhhhhhh");
		}else {
			System.out.println("character at "+i+" : "+myText.charAt(i));
		}
	}
	public void printLocation(String s) {
		if(myText.indexOf(s)!=-1) {
			System.out.println("location of "+s+" : "+myText.indexOf(s));
		}else {
			System.out.println("bruhhhhhhhh");
		}
	}
	public int countChar(char special) {
		int specialCounter=0;
		for(int i=0;i<myText.length();i++) {
			if(myText.charAt(i)==special) {
				specialCounter++;
			}
		}
		return specialCounter;
	}
}
