package br.univali.kob.poo1.Trabalho_M1;

import java.util.ArrayList;

/**
 *
 * @author Gabriel e Mauricio
 */
public class Checker {
    
    /**
     * Test if it's possible to play a tile in the table
     * if it's possible to play on the table chain begin, retunrs 1
     * if it's possible to play on the table chain end, returns 2
     * or, if it's not possible to play this tile, returns 3
     * @param tile - the tile tha will be added
     * @param table - the game table
     */
    public static int checkTileAddition(Tile tile, Table table){
        
        if (table.getTableChain().get(0).getEnd(0) == tile.getEnd(1)){
            return 1;
        }else{
            if(table.getTableChain().get(0).getEnd(0) == tile.getEnd(0)){
                tile.flip();
                return 1;
            }
            else{
                if (table.getTableChain().get(table.getTableChain().size()-1).getEnd(1) == tile.getEnd(0)){
                    return 2;
                }else{
                    if(table.getTableChain().get(table.getTableChain().size()-1).getEnd(1) == tile.getEnd(1)){
                    tile.flip();
                    return 2;
                    }
                    else{
                        return 3;
                    }
                }
            }
        }
    }
    
    /**
     * Defines who is the first player to play
     * @param table
     * @param players
     * @return the first player
     */
    public static Player checkFirstPlayer(Table table, ArrayList<Player> players){
        for (int k=6; k>-1; k--){
            for (int i=0; i<players.size(); i++){
                for (int j=0; j<7; j++){
                    if(players.get(i).getTile(j).getEnd(0) == k &&  players.get(i).getTile(j).getEnd(1) == k){
                        Tile tile = players.get(i).getTile(j);
                        players.get(i).removeFromHand(j);
                        players.get(i).addToHand(tile);
                        return players.get(i);
                    
                    }
                }
            }
        }
        for (int i=5; i>-1; i--){
            for (int j=6; j>i; j--){
                for (int z=0; z<players.size(); z++){
                    for (int w=0; w<7; w++){
                        if(players.get(z).getTile(w).getEnd(0) == i && players.get(z).getTile(w).getEnd(1) == j){
                            Tile tile = players.get(i).getTile(j);
                            players.get(i).removeFromHand(j);
                            players.get(i).addToHand(tile);
                            return players.get(z);

                        }
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Informs if it's possible to take a tile of the boneyard
     * Only if Boneyard isnt empty
     * @param player
     * @param table
     * @return a boolean if its possible
     */
    public static boolean checkDraw (Player player, Table table){
        if (table.isBoneyardEmpty())
        {
            return false;
        }
        for (int i=0; i<player.getHand().size(); i++){
            if (checkTileAddition(player.getTile(i), table) != 3){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Informs if it's possible to pass your turn (only if the boneyard is empty)
     * @param player
     * @param table
     * @return 
     */
    public static boolean checkPass(Player player, Table table){
        boolean cannot_play = true;
        
        for (int i=0; i<player.getHand().size(); i++){
            if (checkTileAddition(player.getTile(i), table) != 3){
                cannot_play = false;
            }
        }
        return cannot_play && table.isBoneyardEmpty();
    }
    
    /**
     * Check who's the winning player, if there are any.  
     * @param table
     * @param players
     * @return The winning player
     */
    public static Player checkWinner(Table table, ArrayList<Player> players){
        
        for (int i=0; i<players.size(); i++){
            if (players.get(i).getHand().isEmpty()){
                return players.get(i);
            }
        }
        
        boolean allPassed = true;
         for (int i=0; i<players.size(); i++){
             allPassed = allPassed && checkPass(players.get(i), table);
         }
        
         
         if (allPassed){
             ArrayList<Integer> sobras = new ArrayList();
             
             int somaDosLados;
             for (int i=0; i<players.size(); i++){
                 somaDosLados = 0;
                 for (int j=0; j<players.get(i).getHand().size(); j++){
                     somaDosLados += players.get(i).getTile(j).getEnd(0) + players.get(i).getTile(j).getEnd(1);
                 }
                 sobras.add(somaDosLados);
             }
             
             int index = 0;
             for (int i=1; i<players.size(); i++){
                 if (sobras.get(i)<sobras.get(index)){
                     index=i;
                 }
             }
             return players.get(index);
         }
         return null;       
    }
    
}