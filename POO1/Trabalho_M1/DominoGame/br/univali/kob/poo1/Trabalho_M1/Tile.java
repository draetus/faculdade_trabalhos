package br.univali.kob.poo1.Trabalho_M1;

/**
 *
 * @author Gabriel e Mauricio
 */

public class Tile {
    
    /**
     * The tile sides
     */
    private final int ends[] = new int [2];
    
    /**
     * Constructor
     * @param value1 first side
     * @param value2 second side
     */
    public Tile(int value1, int value2){
        this.ends[0] = value1;
        this.ends[1] = value2;
    }
    
    /**
     * @param index
     * @return one of the tile sides indexed with 0 or 1
     */
    public int getEnd(int index){
        return this.ends[index];
    }
    
    /**
     * @return a vector with the tile sides
     */
    public int[] getEnds(){
        return ends;
    }
    
    /**
     * Reverse the tile sides
     * useful for the comparation functions used in the future
     */
    public void flip(){
        int aux = this.ends[0];
        this.ends[0] = this.ends[1];
        this.ends[1] = aux;
    }
}