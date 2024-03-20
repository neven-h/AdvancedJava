import java.util.Collections;
import java.util.ArrayList;
import java.security.SecureRandom;

public class DeckOfCards {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52; // constant # of Card
    private ArrayList<Card> deck = new ArrayList<>(NUMBER_OF_CARDS);
    private int currentCard = 0;

    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        // populate deck with Card objects
        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck.add(new Card(faces[count % 13], suits[count / 13]));
        }
    }

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // next call to method dealCard should start at deck[0] again
        currentCard = 0;
        // Use Collections.shuffle() to shuffle the deck
        Collections.shuffle(deck, randomNumbers);
    }

    //deal one Card
    //Assuming you have a dealCard method to deal cards
    public Card dealCard() {
        if (currentCard < deck.size()) {
            return deck.get(currentCard++);
        } else {
            return null; // or throw an exception if preferred
        }

    }
}

