package br.univali.kob.poo1.Ex_12;

import br.univali.kob.poo1.Ex_12.Card.Suit;
import br.univali.kob.poo1.Ex_12.Card.Value;
import java.util.Scanner;

/**
 * @author Mauricio
 * Interface used to play the game.
 */
public class UserInterface {
    
    /**
     * The game.
     */
    private GuessGame game;
    
    /**
     * The player
     */
    private Player player;
    
    /**
     * Runs the main interface.
     */
    public void run()
    {
        this.printHeader();
        this.createPlayer();
    }
    
    /**
     * Prints the header of the game.
     */
    private void printHeader()
    {
        System.out.println("\n--------------------------------");
        System.out.println("             Guess Game           ");
        System.out.println("--------------------------------");
    }
    
    /**
     * Read a string.
     * @param question Question.
     * @return User input.
     */
    private String readString(String question)
    {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    
    /**
     * Read an int.
     * @param question Question.
     * @return User input.
     */
    public int readInt(String question)
    {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    /**
     * Creates the player.
     */
    private void createPlayer()
    {
        String name = this.readString("Inform your name: ");
        this.player = new Player(name);
    }
    
    /**
     * Converts the user entry to the Card suit enum format.
     * @param i user entry.
     * @return Card suit enum format.
     */
    public Suit chooseSuit(int i)
    {
        switch(i)
        {
            case 1:
                return Card.Suit.DIAMONDS;
                
            case 2:
                return Card.Suit.SPADES;
                
            case 3:
                return Card.Suit.HEARTS;
                
            case 4:
                return Card.Suit.CLUBS;
                
            default:
                System.out.println("Valor invalido");
                return null;
        }
    }
    
    /**
     * Converts the user entry to the Card value enum format.
     * @param i User entry.
     * @return Card value enum format.
     */
    public Value chooseValue(int i)
    {
        switch(i)
        {
            case 1:
                return Card.Value.ACE;
                
            case 2:
                return Card.Value.TWO;
                
            case 3:
                return Card.Value.THREE;
                
            case 4:
                return Card.Value.FOUR;
                
            case 5:
                return Card.Value.FIVE;
                
            case 6:
                return Card.Value.SIX;
                
            case 7:
                return Card.Value.SEVEN;
                
            case 8:
                return Card.Value.EIGHT;
                
            case 9:
                return Card.Value.NINE;
                
            case 10:
                return Card.Value.JACK;
                
            case 11:
                return Card.Value.QUEEN;
                
            case 12:
                return Card.Value.KING;
                
            default:
                System.out.println("Valor invalido");
                return null;
        }
    }
    
    /**
     * Starts the game mechanics.
     */
    public void startGame()
    {
        Card randomcard = this.game.getRandomCard();
    }
}