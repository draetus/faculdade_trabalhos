package br.univali.kob.poo1.Trabalho_M1;

import java.util.ArrayList;

/**
 *
 * @author Gabriel e Mauricio
 */
public class Player {
    
    /**
     * The player name
     */
    private final String name;
    
    /**
     * The player hand
     */    
    private final ArrayList<Tile> hand = new ArrayList<>();
    
    /**
     * The player bought tiles
     */    
    private final ArrayList<Tile> boughtTiles = new ArrayList<>();
    
    /**
     * True if the player is a human
     */
    private final boolean human;
    
    /**
     * Setting to player
     * @param name
     * @param human 
     */
    public Player(String name, boolean human){
        this.name = name;
        this.human = human;
    }
    
    /**
     * 
     * @return the player hand array 
     */
    public ArrayList<Tile> getHand(){
        return hand;
    }
    
    /**
     * 
     * @return  the bought tiles by the player
     */
    public ArrayList<Tile> getBoughtTiles(){
        return boughtTiles;
    }
    
    /**
     * Get a especifc tile on the player hand
     * @param index - The tile position
     * @return the indexed tile
     */
    public Tile getTile(int index){
        return hand.get(index);
    }
    
    
    /**
     * Remove a especifc tile on the player hand
     * @param index - tile addres
     */
    public void removeFromHand(int index)
    {
        hand.remove(index);
    }
    
    /**
     * Add a tile to te current player hand and to the boughtTiles
     * @param tile 
     */
    public void addToHand(Tile tile){
        hand.add(tile);
        boughtTiles.add(tile);
    }
    
    /**
     * 
     * @return the player name
     */
    public String getName(){
        return name;
    }
    
    /**
     * 
     * @return informs if its a human player
     */
    public boolean isHuman(){
        return human;
    }
    
    /**
     * Clear the bought tiles array
     */
    public void clearBoughtTiles()
    {
        boughtTiles.clear();
    }
}