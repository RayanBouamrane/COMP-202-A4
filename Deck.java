//Name: Rayan Bouamrane
//Student Number: 260788250

import java.util.Random;

public class Deck {

    private static Card[] cardArray = new Card[52];

    public Deck() {

        //In the Deck constructor, n stores the array index up to 51, and counts up
        //j iterates though the 4 suits, indexes 0 to 4, and i iterates from 1 to 13 through the 13 ranks
        String[] suits = {"hearts", "spades", "clubs", "diamonds"};
        int n = 0;
        for (int j = 0; j < suits.length; j++)
            for (int i = 1; i <= 13; i++) {
                cardArray[n] = new Card(suits[j], i);
                n++;
            }
    }

    public static void shuffle() {

        //two random values between 0 and 51 are stored as ints, arrays of their indexes are swapped
        int seed = 123;
        Random randNum = new Random(seed);
        for (int i = 0; i < 1000; i++) {
            int rand1 = randNum.nextInt(52);
            int rand2 = randNum.nextInt(52);
            Card temp = cardArray[rand1];
            cardArray[rand1] = cardArray[rand2];
            cardArray[rand2] = temp;
        }
    }

    public static Card[] dealHand(int n, int numP) {

        //the cards dealt indicate the number of cards above the cards the player will be dealt
        int cardsDealt = (numP - 1) * n;

        Card[] playerCards = new Card[n];

        //loop iterates up to n to initialize elements in the playerCards array
        for (int i = 0; i < n; i++) {
            //The elements in the array we created assigned the value of an element in the shuffled deck,
            //plus the cards that have already been dealt, effectively moving down the deck to the cards meant for them
            //if statement checks for an ArrayIndexOutOfBoundsException, and an illegalArgumentException is thrown.
            if (i + cardsDealt >= cardArray.length) {
                throw new IllegalArgumentException("The are no more cards in the deck");
            }
            playerCards[i] = cardArray[i + cardsDealt];
        }
        return playerCards;
    }
}
