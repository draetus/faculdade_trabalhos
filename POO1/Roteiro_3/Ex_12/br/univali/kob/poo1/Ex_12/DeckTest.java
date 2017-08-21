package br.univali.kob.poo1.Ex_12;

/**
 * @author Mauricio
 * Tests the Deck class, creating an array before shuffling and after shuffling.
 */
public class DeckTest {
    
    /**
     * Deck of cards
     */
    private final Deck deck = new Deck();
    
    /**
     * Runs the test
     */
    public void run()
    {
        System.out.println("Unshuffled Deck:");
        printUnshuffled();
        System.out.println();
        System.out.println("Shuffled Deck:");
        printShuffled();
    }
    
    /**
     * Prints the cards before shuffling.
     */
    public void printUnshuffled()
    {
        for (Card card : deck.getAll())
        {
            System.out.print(card.getValue() + " of " + card.getSuit() + " - ");
        }
    }
    
    /**
     * Prints the cards after shuffling.
     */
    public void printShuffled()
    {
        deck.shuffle();
        for (Card card : deck.getAll())
        {
            System.out.print(card.getValue() + " of " + card.getSuit() + " - ");
        }
    }
}