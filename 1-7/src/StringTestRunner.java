public class StringTestRunner {
    public static void main(String[] args){

        StringTest s = new StringTest("The quick brown fox jumps over the lazy dog.");
        s.printInfo();
        s.printChar(0);
        s.printChar(5);
        s.printChar(10);
        s.printChar(15);
        s.printLocation("h");
        s.printLocation("e");
        s.printLocation("jumps");
        s.printLocation("dog");
        int countChar = s.countChar('o');
        System.out.println("Count of o: " + countChar);
    }
}