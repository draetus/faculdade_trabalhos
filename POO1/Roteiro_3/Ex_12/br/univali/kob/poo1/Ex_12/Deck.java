package br.univali.kob.poo1.Ex_12;

import java.util.Random;

/**
 * @author Mauricio
 * Represents a Deck with 52 cards within it.
 */
public class Deck {

    /**
     * Constructor: Create 52 cards
     */
    public Deck() {
        int i=0;
        for (Card.Suit suit : Card.Suit.values())
        {
            for (Card.Value value: Card.Value.values())
            {
                cards[i] = new Card(value, suit);
                i++;
            }
        }
    }

    /**
     * Array of cards
     */
    private final Card[] cards = new Card[52];

    /**
     * Shuffle the cards in the array
     */
    public void shuffle() {
        for (int i=0;i<50;i++)
        {
            int randint1 = new Random().nextInt(51);
            int randint2 = new Random().nextInt(51);
            Card aux = cards[randint1];
            cards[randint1] = cards[randint2];
            cards[randint2] = aux;
        }
    }

    /**
     * @param i The position of the card chosen in the array
     * @return Card chosen
     */
    public Card getCard(int i) {
        return this.cards[i];
    }

    /**
     * @return The array with all the cards
     */
    public Card[] getAll() {
        return cards;
    }

}