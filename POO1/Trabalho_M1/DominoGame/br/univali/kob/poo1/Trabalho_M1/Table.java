package br.univali.kob.poo1.Trabalho_M1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gabriel e Mauricio
 */
public class Table {
    
    /**
     * The tiles in the table
     */
    private final ArrayList <Tile> TableChain = new ArrayList<>();
    
    /**
     * The tiles in the Boneyard(if it's less than 4 players game)
     * It's also the tiles being distributed to the players
     */
    private final ArrayList <Tile> Boneyard = new ArrayList<>();
    
    /**
     * Constructor of the "Table"
     * Create the tiles on Boneyard and shuffle them
     */
    public Table(){
        for (int i=0; i<7; i++){
            for (int j=0; j<i+1; j++){
                Boneyard.add(new Tile(i, j));
            }
        }
        shuffleBoneyard();
    }
    

    /**
     * 
     * @return The array whith the tiles that composes the table
     */
    public ArrayList<Tile> getTableChain(){
        return TableChain;
    }
    
    /**
     * add a tile to the table:
     * @param tile - the tile to be added
     * @param begin - defines if the tile will be added in the end or begin of the TableChain
     */
    public void addToTableChain(Tile tile, boolean begin){
        if (begin){
            TableChain.add(0, tile);
        }else{
            TableChain.add(tile);
        }
    }
    
    /**
     * Shuffle the Boneyard tiles
     */
    private void shuffleBoneyard(){
        //Collections.shuffle(this.Boneyard);
        Collections.shuffle(Boneyard);
    }
    
    /**
     * Remove the first tile of Boneyard and
     * @return it 
     */
    public Tile getTile(){
        Tile tile = Boneyard.get(0);
        Boneyard.remove(0);
        return tile;
    }
    
    /**
     * Informs if Boneyard array is empty
     */
    public boolean isBoneyardEmpty()
    {
        return Boneyard.isEmpty();
    }
}
