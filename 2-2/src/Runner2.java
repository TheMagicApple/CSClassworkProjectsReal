import java.util.ArrayList;

import static java.lang.System.*;

public class Runner2 {
    public static void main(String[] args){

        ArrayTest test = new ArrayTest();

        ArrayList<Card> cardList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            cardList.add(new Card((int)(Math.random() * (5-1+1)+1)));
        }
        //System.out.println(cardList);
        test.printList(cardList);
        int total = test.findTotal(cardList);
        out.println(total);

        test.scramble(cardList);
        test.printList(cardList);
        out.println("Search and Delete");
        test.searchAndDelete(cardList,2);

        test.printList(cardList);
        out.println("Search and Replace");
        test.searchAndReplace(cardList,4);
        test.printList(cardList);
        test.sort(cardList);
        test.printList(cardList);


    }
}

