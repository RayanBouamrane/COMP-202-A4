//Name: Rayan Bouamrane
//Student Number: 260788250

public class BridgeUtilities {

    private BridgeUtilities() {
    }

    private static int countValue(Card[] cardArray, int p) {

        //this loop checks that the card value inputted equals the value of the element in the array,
        //and adds one to the int counter every time this is true
        int counter = 0;
        for (int i = 0; i < cardArray.length; i++)
            if (p == cardArray[i].getValue())
                counter++;

        return counter;
    }

    private static int countSuit(Card[] cardArray, String s) {

        //same as previous loop, with a string input instead
        int counter = 0;
        for (int i = 0; i < cardArray.length; i++)
            if (s.equalsIgnoreCase(cardArray[i].getSuit()))
                counter++;

        return counter;
    }

    public static int countPoints(Card[] cardArray) {

        //the high card points are obtained by calling countValue with inputs 1, 13, 12, and 11
        //an ace is worth four points, so the number of aces is multiplies by 4 and added to hcp
        int hcp = 0;

        hcp += 4 * (countValue(cardArray, 1));
        hcp += 3 * (countValue(cardArray, 13));
        hcp += 2 * (countValue(cardArray, 12));
        hcp += (countValue(cardArray, 11));

        //distribution points are obtained by calling countSuit with the suits as inputs. if and only if
        //the return value is greater than 4, value-4 is added to dp
        int dp = 0;

        if (countSuit(cardArray, "clubs") >= 4)
            dp += (countSuit(cardArray, "clubs")) - 4;
        if (countSuit(cardArray, "hearts") >= 4)
            dp += (countSuit(cardArray, "hearts")) - 4;
        if (countSuit(cardArray, "diamonds") >= 4)
            dp += (countSuit(cardArray, "diamonds")) - 4;
        if (countSuit(cardArray, "spades") >= 4)
            dp += (countSuit(cardArray, "spades")) - 4;

        return (hcp + dp);
    }
}



