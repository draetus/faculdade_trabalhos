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
        ACE("Ace"),
        TWO("Two"),
        THREE("Three"),
        FOUR("Four"),
        FIVE("Five"),
        SIX("Six"),
        SEVEN("Seven"),
        EIGHT("Eight"),
        NINE("Nine"),
        TEN("Ten"),
        JACK("Jack"),
        QUEEN("Queen"),
        KING("King");
        
        String value;
        
        private Value(String value)
        {
            this.value = value;
        }
        
        public String getValue()
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
    public String getValue() 
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