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
        this.startGame();
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
        System.out.print(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    
    /**
     * Read an int.
     * @param question Question.
     * @return User input.
     */
    private int readInt(String question)
    {
        System.out.print(question);
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
     * Starts the game mechanics.
     */
    private void startGame()
    {
        this.game = new GuessGame(this.player);
        while(true)
        {
            Card randomCard = this.game.getRandomCard();
            Card chosenCard = new Card(getValueOption(), getSuitOption());
            if (randomCard.getValue() == chosenCard.getValue() && randomCard.getSuit().equals(chosenCard.getSuit()))
            {
                System.out.println("WINNER!!!\n500 Points added to score");
                player.addToScore(500);
            }
            else
            {
                System.out.println("Tip-> Card's Suit: " + randomCard.getSuit());
                chosenCard = new Card(getValueOption(), getSuitOption());
                if (chosenCard.getValue() == randomCard.getValue() && chosenCard.getSuit().equals(randomCard.getSuit()))
                {
                    System.out.println("WINNER!!!\n200 Points added to score");
                    player.addToScore(200);
                }
                else
                {
                    if (randomCard.getValue() >= 7)
                    {
                        System.out.println("Tip-> The card's value is bigger or equal to 7");
                    }
                    else
                    {
                        System.out.println("Tip-> The card's value is smaller or equal to 7");
                    }
                    chosenCard = new Card(getValueOption(), getSuitOption());
                    if (chosenCard.getValue() == randomCard.getValue() && chosenCard.getSuit().equals(randomCard.getSuit()))
                    {
                        System.out.println("WINNER!!!\n50 Points added to the score");
                        player.addToScore(50);
                    }
                }
            }
            if (this.readString("Do you want to keep playing?(s/n): ").equals("s"))
            {
                System.out.println("Restarting game");
            }
            else
            {
                    System.out.println("Thank you for playing");
                    System.out.println("Player's name: " + player.getName());
                    System.out.println("Total Score: " + player.getScore());
                    break;
            }
        }
    }
    
    /**
     * Converts the user entry to the Card suit enum format.
     * @param i user entry.
     * @return Card suit enum format.
     */
    private Suit chooseSuit(int i)
    {
        switch(i)
        {
            case 1: return Card.Suit.DIAMONDS;
            case 2: return Card.Suit.SPADES;
            case 3: return Card.Suit.HEARTS;
            case 4: return Card.Suit.CLUBS;
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
    private Value chooseValue(int i)
    {
        switch(i)
        {
            case 1: return Card.Value.ACE;
            case 2: return Card.Value.TWO;
            case 3: return Card.Value.THREE;
            case 4: return Card.Value.FOUR;
            case 5: return Card.Value.FIVE;
            case 6: return Card.Value.SIX;
            case 7: return Card.Value.SEVEN;
            case 8: return Card.Value.EIGHT;
            case 9: return Card.Value.NINE;
            case 10: return Card.Value.TEN;
            case 11: return Card.Value.JACK;
            case 12: return Card.Value.QUEEN;
            case 13: return Card.Value.KING;
            default:
                System.out.println("Valor invalido");
                return null;
        }
    }
    
    private Value getValueOption()
    {
        System.out.println("1.Ace - 2.Two - 3.Three - 4.Four - 5.Five");
        System.out.println("6.Six - 7.Seven - 8.Eight - 9.Nine - 10.Ten");
        System.out.println("11.Jack - 12.Queen - 13.King");
        Value chosenValue = null;
        while (chosenValue == null)
        {
            chosenValue = this.chooseValue(this.readInt("Choose the value of your card: "));
        }
        return chosenValue;
    }
    
    private Suit getSuitOption()
    {
        System.out.println("1.Diamonds - 2.Spades - 3.Hearts - 4.Clubs");
        Suit chosenSuit = null;
        while (chosenSuit == null)
        {
            chosenSuit = this.chooseSuit(this.readInt("Choose the suit of your card: "));
        }
        return chosenSuit;
    }
}