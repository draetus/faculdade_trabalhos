package br.univali.kob.poo1.Ex_12;

/**
 * @author Mauricio
 * Represents a card from a deck.
 */
public class Card {

    /**
     * Enumeration with all the possible card's Suits.
     */
    public static enum Suit 
    {
        SPADES("Spades"),
        HEARTS("Hearts"),
        CLUBS("Clubs"),
        DIAMONDS("Diamonds");
        
        String suit;
        
        private Suit(String suit)
        {
            this.suit = suit;
        }
        
        public String getSuit()
        {
            return this.suit;
        }
    }
    
    /**
     * Enumeration with all the possible card's values.
     */
    public static enum Value 
    {
        ACE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);
        
        int value;
        
        private Value(int value)
        {
            this.value = value;
        }
        
        public int getValue()
        {
            return this.value;
        }
    }
    
    /**
     * The card's Suit.
     */
    private final Suit suit;

    /**
     * The card's Value.
     */
    private final Value value;
    
    /**
     * @param value Card's Value.
     * @param suit Card's Suit.
     */
    public Card(Value value, Suit suit) 
    {
        this.value = value;
        this.suit = suit;
    }

    /**
     * @return card's Value.
     */
    public int getValue() 
    {
        // TODO implement here
        return this.value.getValue();
    }

    /**
     * @return Card's Suit.
     */
    public String getSuit() 
    {
        // TODO implement here
        return this.suit.getSuit();
    }
}