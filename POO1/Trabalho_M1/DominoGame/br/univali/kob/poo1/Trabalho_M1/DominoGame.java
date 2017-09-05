package br.univali.kob.poo1.Trabalho_M1;

import java.util.ArrayList;

/**
 *
 * @author Gabriel e Mauricio
 */
public class DominoGame {
    
    /**
     * Players list
     */
    private final ArrayList<Player> players = new ArrayList<>();
    
    /**
     * The current game table
     */
    private final Table table = new Table();
    
    /**
     * Number of players
     */
    private final int numOfPlayers;
    
    /**
     * Current turn on the game
     * Used for inform the player
     */
    private int turnsPassed;
    
    /**
     * Current player 
     * Used for ifoms the player on user interface
     */
    private Player currentPlayer;
    
    /**
     * Last tile played
     * Used for user interface to infom the player
     */
    private Tile lastUsedTile;
    
    /**
     * Constructor used for a demonstration game
     * Without a parametrized player name
     * @param numOfPlayers - array with the number of players
     */
    public DominoGame (int numOfPlayers)
    {
        String[] names = {"Roy Batty", "Leon Kowalski", "Pris Stratton", "Zhora Salome"};
        this.numOfPlayers = numOfPlayers;
        for (int i=0;i<numOfPlayers;i++)
        {
            players.add(new Player(names[i], false));
            for (int j=0;j<7;j++)
            {
                players.get(i).addToHand(table.getTile());
            }
        }
        currentPlayer = Checker.checkFirstPlayer(table, players);
        turnsPassed = 0;
    }
    
    /**
     * Constructor used for a normal game with a human player
     * @param numOfPlayers
     * @param name 
     */
    public DominoGame (int numOfPlayers, String name)
    {
        String[] names = {"Roy Batty", "Leon Kowalski", "Pris Stratton", "Zhora Salome"};
        this.numOfPlayers = numOfPlayers;
        players.add(new Player(name, true));
        for (int j=0;j<7;j++)
        {
            players.get(0).addToHand(table.getTile());
        }
        for (int i=0;i<numOfPlayers-1;i++)
        {
            players.add(new Player(names[i], false));
            for (int j=0;j<7;j++)
            {
                players.get(i+1).addToHand(table.getTile());
            }
        }
        currentPlayer = Checker.checkFirstPlayer(table, players);
        turnsPassed = 0;
    }
    
    /**
     * 
     * @return the current player
     */
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    /**
     * The turns passed amount
     * @return 
     */
    public int getTurnsPassed()
    {
        return this.turnsPassed;
    }
    
    /**
     * 
     * @return Last played tile 
     */
    public Tile getLastUsedTile()
    {
        return this.lastUsedTile;
    }
    
    /**
     * 
     * @return Current array of tiles on the table 
     */
    public ArrayList<Tile> getTableChain()
    {
        return this.table.getTableChain();
    }
    
    /**
     * 
     * @return 
     */
    public Player getWinner()
    {
        return Checker.checkWinner(table, players);
    }
    
    /**
     * 
     * @return Previous player  - iseful on the user intercafe
     */
    public Player getPreviousPlayer()
    {
        if (players.indexOf(currentPlayer) == 0)
        {
           return players.get(players.size() - 1);
        }
        else
        {
            return players.get(players.indexOf(currentPlayer) - 1);
        }
    }
    
    public ArrayList<Tile> getBoneyard()
    {
        return this.table.getBoneyard();
    }
    
    /**
     * An automatic played by the bots
     * @return 
     */
    public boolean playBotTurn()
    {
        for (int i=0;i<currentPlayer.getHand().size();i++){
            if (playTile(i))
            {
                return true;
            }
        }
        if (Checker.checkDraw(currentPlayer, table))
        {
            drawTile();
            return true;
        }
        else if (Checker.checkPass(currentPlayer, table))
        {
            pass();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Using the checkTileAddiction logic, return true if its possible to place
     * the tile on the table
     * Also remove the tile on the player hand if its possible to play
     * @param index
     * @return 
     */
    public boolean playTile(int index)
    {
        switch (Checker.checkTileAddiction(currentPlayer.getTile(index), table))
        {
            case 1:
                table.addToTableChain(currentPlayer.getTile(index), true);
                lastUsedTile = currentPlayer.getTile(index);
                currentPlayer.removeFromHand(index);
                setNextCurrentPlayer();
                return true;
                
            case 2:
                table.addToTableChain(currentPlayer.getTile(index), false);
                lastUsedTile = currentPlayer.getTile(index);
                currentPlayer.removeFromHand(index);
                setNextCurrentPlayer();
                return true;
                
            default:
                return false;
        }
    }
    
    /**
     * Check if its possible to take a tile from the Boneyard
     * Also remove this tile from boneyars if its possible
     * @return 
     */
    public boolean drawTile()
    {
        if (Checker.checkDraw(currentPlayer, table))
        {
            Tile tile = table.getTile();
            currentPlayer.addToHand(tile);
            lastUsedTile = null;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Check if its possible to pass the turn
     * Also set the last tile played as null
     * @return 
     */
    public boolean pass()
    {
        if (Checker.checkPass(currentPlayer, table))
        {
            setNextCurrentPlayer();
            lastUsedTile = null;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * PLay de first tile on the table checking who is the first player
     */
    public void playFirstTile()
    {
        table.addToTableChain(currentPlayer.getTile(currentPlayer.getHand().size()-1), false);
        currentPlayer.removeFromHand(currentPlayer.getHand().size()-1);
        setNextCurrentPlayer();
    }
    
    /**
     * Defines who is the next current player
     */
    private void setNextCurrentPlayer()
    {
        if (players.indexOf(currentPlayer) == players.size()-1)
        {
            currentPlayer = players.get(0);
            currentPlayer.clearBoughtTiles();
        }
        else
        {
            currentPlayer = players.get(players.indexOf(currentPlayer)+1);
            currentPlayer.clearBoughtTiles();
        }
        turnsPassed++;
    }
}