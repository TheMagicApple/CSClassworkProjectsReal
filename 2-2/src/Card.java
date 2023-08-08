public class Card {
    private int value;

    public Card(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void changeValue(int change){
        this.value = change;
    }

    public String toString() {
        return "Value: " + value;
    }
}