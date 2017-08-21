package br.univali.kob.poo1.Ex_12;

/**
 * @author Mauricio
 * Represents the player.
 */
public class Player {
    
    /**
     * Score of player.
     */
    private int score;
    
    /**
     * Name of the player.
     */
    private String name;
    
    /**
     * Constructor: Sets score to 0 and sets the name.
     * @param name Name of the player.
     */
    public Player(String name)
    {
        this.setName(name);
        score = 0;
    }
    
    /**
     * Setter.
     * @param name Name of the player.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Getter.
     * @return Name of the player. 
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Getter.
     * @return Score of the player.
     */
    public int getScore()
    {
        return this.score;
    }
    
    /**
     * Add to the total score.
     * @param points Points to add.
     */
    public void addToScore(int points)
    {
        this.score += points;
    }
}