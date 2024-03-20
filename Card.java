public class Card {
    private final String face;
    private final String suit;

    // two-argument constructor initializes card'
    public Card(String cardFace, String cardSuit){
        this.face = cardFace;
        this.suit = cardSuit;
    }
    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }
}

