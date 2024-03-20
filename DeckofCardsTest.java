public class DeckofCardsTest {
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in

        // print all 52 Cards in the order in whic
        for (int i = 1; i <= 52; i++) {
            // deal and display a Card
            System.out.printf("%-19s", myDeckOfCards.dealCard());
            if (i % 4 == 0) { // output a newline a
                System.out.println();
            }
        }
    }
}