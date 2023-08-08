import java.util.ArrayList;

public class Runner2 {
	public static void main(String[] args){
		System.out.println("Testing Part A");
		String[] tokens1 = {"(", "x+y", ")", " * 5"};
		Delimiters test1 = new Delimiters("(",")");
		System.out.println( test1.getDelimitersList(tokens1));
		String[] tokens2 = {"<q>", "yy", "</q>", "zz", "</q>"};
		Delimiters test2 = new Delimiters("<q>","</q>");
		System.out.println( test2.getDelimitersList(tokens2));
		
		System.out.println("\nTesting Part B");
		ArrayList<String> delimiters1 = new ArrayList<String>();
		Delimiters test = new Delimiters("<sup>","</sup>");
		delimiters1.add("<sup>");
		delimiters1.add("<sup>");
		delimiters1.add("</sup>");
		delimiters1.add("<sup>");
		delimiters1.add("</sup>");
		delimiters1.add("</sup>");
		System.out.println(test.isBalanced(delimiters1));
		
		ArrayList<String> delimiters2 = new ArrayList<String>();
		delimiters2.add("<sup>");
		delimiters2.add("</sup>");
		delimiters2.add("</sup>");
		delimiters2.add("</sup>");
		System.out.println(test.isBalanced(delimiters2));
		
		
		ArrayList<String> delimiters3 = new ArrayList<String>();
		delimiters3.add("</sup>");
		System.out.println(test.isBalanced(delimiters3));
		
		ArrayList<String> delimiters4 = new ArrayList<String>();
		delimiters4.add("<sup>");
		delimiters4.add("<sup>");
		delimiters4.add("</sup>");
		System.out.println(test.isBalanced(delimiters4));
	}
}
