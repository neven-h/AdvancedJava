import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        warGame();
    }

    // start the warGame
    public static void warGame() {
        String message;
        DeckOfCards deckA = new DeckOfCards();
        DeckOfCards deckB = new DeckOfCards();
        DeckOfCards temp = new DeckOfCards();
        deckA.ClearDeck();
        deckB.ClearDeck();
        temp.shuffle();
        divide(deckA, deckB, temp);
        temp.ClearDeck();

        while(!deckA.IsEmpty() && !deckB.IsEmpty()) {
            Card cardA = deckA.dealCard();
            Card cardB = deckB.dealCard();
            message = "Player A Card is: " + cardA + "\nPlayer B Card is: " + cardB.toString();
            if (cardA.cardValue() > cardB.cardValue()) {
                AddToDeck(cardA, cardB, deckA, temp);
                message += "\nPlayer A won!";
                JOptionPane.showMessageDialog(null, message);
            }
            else if (cardA.cardValue() < cardB.cardValue()) {
                AddToDeck(cardB, cardA, deckB, temp);
                message += "\nPlayer B won!";
                JOptionPane.showMessageDialog(null, message);
            }
            // War mode
            else {
                message += "\nIts a war!";
                JOptionPane.showMessageDialog(null, message);
                //We will add 2 cards from each player to the temp deck and after the war will give them to the winner
                for (int i = 0; i < 2; i++){
                    cardA = deckA.dealCard();
                    cardB = deckB.dealCard();
                    temp.addCard(cardA);
                    temp.addCard(cardB);
                }
            }
        }// End of while
        winner(deckA, deckB);
    }

    // make a message of who won the game
    public static  void winner (DeckOfCards A, DeckOfCards B) {
        if(A.IsEmpty())
            JOptionPane.showMessageDialog(null,  "Player B won the game!");
        else
            JOptionPane.showMessageDialog(null, "Player A won the game!");
    }

    // add cards A and B and deck temp to the deck
    public static void AddToDeck(Card cardA, Card cardB, DeckOfCards deck, DeckOfCards temp) {
        temp.addCard(cardA);
        temp.addCard(cardB);
        deck.addDeck(temp);
        temp.ClearDeck();
    }
    // divide the cards from deck MainDeck to dackA and deckB
    public static void divide(DeckOfCards deckA,DeckOfCards deckB, DeckOfCards MainDeck) {
        for(int i=0;i<52;i++) {
            if(i%2==0)
                deckA.addCard(MainDeck.dealCard());
            else
                deckB.addCard(MainDeck.dealCard());
        }
    }
}// End class Main

