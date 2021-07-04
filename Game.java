//Name: Rayan Bouamrane
//Student Number: 260788250

public class Game {

    public static void main(String[] args) {

        new Deck();

//        optional loop to print unshuffled deck
//        for (int i = 0; i < 52; i++)
//            Deck.cardArray[i].print();

        Deck.shuffle();
//          this loop prints the shuffled deck
//        for (int i = 0; i < 52; i++)
//            Deck.cardArray[i].print();

        System.out.println();

        int numP = 4;

        //an array storing each player's hand is initialized by calling the dealHand method from the Deck class
        for (int i = 1; i <= numP; i++) {
            Card[] hand = Deck.dealHand(13, i);
            System.out.println("Player " + i + " was dealt the following hand:");

            //the individual elements from the Card[] hand are passed through the print() method from the Card class
            for (int j = 0; j < hand.length; j++)
                hand[j].print();

            System.out.println("This hand is worth " + BridgeUtilities.countPoints(hand) + " points.");
            System.out.println();
        }
    }
}
