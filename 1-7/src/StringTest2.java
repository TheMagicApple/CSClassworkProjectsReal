public class StringTest2 {
   
    String myText;

    public StringTest2(String words){
        myText = words;
    }

    public void printEachChar(){
        for(int i = 0; i < myText.length(); i++){
            System.out.print(myText.charAt(i) + " ");
        }
        System.out.println("");
    }

    public boolean contains(String word){
        if (myText.indexOf(word) != -1){
            return true;
        }
        return false;
    }

    public int countVowels(){
        int numVowels = 0;
        for(int i = 0; i < myText.length(); i++){
            if (myText.charAt(i) == 'a'){
                numVowels++;
            } else if (myText.charAt(i) == 'e'){
                numVowels++;
            } else if (myText.charAt(i) == 'i'){
                numVowels++;
            } else if (myText.charAt(i) == 'o'){
                numVowels++;
            } else if (myText.charAt(i) == 'u'){
                numVowels++;
            }
        }
        return numVowels;
    }
}
