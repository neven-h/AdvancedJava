import java.util.Objects;

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
    public int cardValue() {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        for(int i=0;i<faces.length;i++) {
            if(Objects.equals(face, faces[i]))
                return i+1;
        }
        return 0;
    }
}

