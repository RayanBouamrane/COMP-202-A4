//Name: Rayan Bouamrane
//Student Number: 260788250

public class Card {

    private String suit;
    private int value;

    //constructor that takes in a String and int input
    public Card(String suit, int value) {

        //if statement checks the String equals a valid suit, otherwise it throws an IllegalArgumentException
        if (suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("diamonds") || suit.equalsIgnoreCase("clubs"))
            this.suit = suit;
        else
            throw new IllegalArgumentException("You need to input a valid suit: hearts, spades, diamonds or clubs");

        //this checks that the int parameter is between 1 and 13, or throws an error
        if (value >= 1 && value <= 13)
            this.value = value;
        else
            throw new IllegalArgumentException("You need to input an integer between 1 and 13 (both included)");
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    //method to cleanly print the the value and suit of an instance of the Card class
    private static void printCard(Card c) {

        //This prints face cards as their names, by checking if the value equals 1, 11, 12 or 13
        if (c.value == 1)
            System.out.println("Ace of " + c.suit);
        else if (c.value == 11)
            System.out.println("Jack of " + c.suit);
        else if (c.value == 12)
            System.out.println("Queen of " + c.suit);
        else if (c.value == 13)
            System.out.println("King of " + c.suit);
        else
            System.out.println(c.value + " of " + c.suit);
    }

    public void print() {
        printCard(this);
    }
}
