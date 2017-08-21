package br.univali.kob.poo1.Ex_12;

/**
 * 
 */
public class Card {

    /**
     * Os naipes das cartas
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
     * Os valores das cartas
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
     * 
     */
    private final Suit suit;

    /**
     * 
     */
    private final Value value;
    
    /**
     * @param value Valor da carta
     * @param suit Naipe da carta
     */
    public Card(Value value, Suit suit) 
    {
        this.value = value;
        this.suit = suit;
    }

    /**
     * @return Valor da carta
     */
    public String getValue() 
    {
        // TODO implement here
        return this.value.getValue();
    }

    /**
     * @return
     */
    public String getSuit() 
    {
        // TODO implement here
        return this.suit.getSuit();
    }
}