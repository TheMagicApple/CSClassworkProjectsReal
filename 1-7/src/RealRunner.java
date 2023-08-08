
public class RealRunner {

	public static void main(String[] args) {
		StringTest2 s=new StringTest2("hello java");
		s.printEachChar();
		System.out.println(s.contains("dog"));
		System.out.println(s.contains("java"));
		System.out.println(s.countVowels());
		StringTest2 s2=new StringTest2("hello world");
		s2.printEachChar();
		System.out.println(s2.contains("hello"));
		System.out.println(s2.contains("cat"));
		System.out.println(s2.countVowels());

	}

}
