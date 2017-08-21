package br.univali.kob.poo1.Ex_12;

import java.util.Random;

/**
 * @author Mauricio
 * Represents the Guessing Game.
 */
public class GuessGame {
    
    /**
     * Player of the game.
     */
    private final Player player;
    
    /**
     * Deck of the game.
     */
    private final Deck deck = new Deck();
    
    /**
     * Constructor: Sets the player.
     * @param player Player
     */
    public GuessGame(Player player)
    {
        this.player = player;
    }
    
    /**
     * Gets a random card.
     * @return Random card.
     */
    public Card getRandomCard()
    {
        return deck.getCard(new Random().nextInt(51));
    }
}