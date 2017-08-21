/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.Ex_12;

/**
 *
 * @author Mauricio
 */
public class DeckTest {
    
    private final Deck deck = new Deck();
    
    public void run()
    {
        System.out.println("Unshuffled Deck:");
        printUnshuffled();
        System.out.println();
        System.out.println("Shuffled Deck:");
        printShuffled();
    }
    
    public void printUnshuffled()
    {
        for (Card card : deck.getAll())
        {
            System.out.print(card.getValue() + " of " + card.getSuit() + " - ");
        }
    }
    
    public void printShuffled()
    {
        deck.shuffle();
        for (Card card : deck.getAll())
        {
            System.out.print(card.getValue() + " of " + card.getSuit() + " - ");
        }
    }
}
