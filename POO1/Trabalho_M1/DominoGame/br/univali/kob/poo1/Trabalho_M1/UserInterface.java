package br.univali.kob.poo1.Trabalho_M1;

import java.util.Arrays;

/**
 *
 * @author Mauricio
 */
public class UserInterface {
    
    private DominoGame game;
    
    private boolean demonstration;
    
    public void run()
    {
        createGame();
        Player winner = null;
        System.out.println("PRESS ENTER TO PASS THE INFORMATION!!!");
        game.playFirstTile();
        printFirstPlayer();
        do
        {
            if (game.getCurrentPlayer().isHuman())
            {
                int option;
                boolean repeatTurn = true;
                while(repeatTurn)
                {
                    printPlayerOptions();
                    option = Console.readInt("Select your action: ");
                    switch(option)
                    {
                        case 1:
                            int tile = Console.readIntBetween("Choose the position of the Tile you want: ", 1, game.getCurrentPlayer().getHand().size());
                            if (game.playTile(tile-1))
                            {
                                repeatTurn = false;
                            }
                            else
                            {
                                System.out.println("\n\n\nYOU NEED TO SPECIFY A SUITABLE TILE!!!");
                            }
                            break;
                            
                        case 2:
                            if (game.drawTile())
                            {
                                repeatTurn = true;
                            }
                            else
                            {
                                System.out.println("\n\n\nYOU CANNOT DRAW A TILE!!!");
                            }
                            break;
                            
                        case 3:
                            if (game.pass())
                            {
                                repeatTurn = false;
                            }
                            else
                            {
                                System.out.println("\n\n\nYOU SHALL NOT PASS!!!");
                            }
                            break;
                            
                        default:
                            System.out.println("OPCAO INVALIDA");
                    }
                }
            }
            else
            {
                game.playBotTurn();
            }
            printEndTurnInfo();
            if (demonstration)
            {
                printBoneyard();
            }
            Console.WaitForEnter();
            winner = game.getWinner();
        }
        while (winner == null);
        
        System.out.println(winner.getName() + "  WON!!!!");
    }
    
    /**
     * Initialize the game and asks if the players wants to participate
     * in the game, if so it calls a different constructor of the game
     */
    private void createGame()
    {
        int numOfPlayer = Console.readIntBetween("How many players do you want in the game(maximum: 4): ", 2, 4);
        if (Console.ask("Do you want to participate of the game(Y/N)?: "))
        {
            game = new DominoGame(numOfPlayer, Console.readLine("Inform your name: "));
            demonstration = false;
        }
        else
        {
            game = new DominoGame(numOfPlayer);
            demonstration = true;
        }
    }
    
    /**
     * Prints the info of the last play and the state of table
     */
    private void printEndTurnInfo()
    {
        System.out.println("_________ENDED TURN___________");
        System.out.println("Turn: " + game.getTurnsPassed());
        System.out.println("Player: " + game.getPreviousPlayer().getName());
        System.out.print("Hand: ");
        for (Tile tile : game.getPreviousPlayer().getHand())
        {
            System.out.print(Arrays.toString(tile.getEnds()));
        }
        System.out.println();
        System.out.print("Bought Tiles: ");
        for (Tile boughtTile : game.getPreviousPlayer().getBoughtTiles()) 
        {
            System.out.print(Arrays.toString(boughtTile.getEnds()));
        }
        System.out.println();
        if (game.getLastUsedTile() != null)
        {
            System.out.println("Used Tile: " + Arrays.toString(game.getLastUsedTile().getEnds()));
        }
        System.out.print("Table: ");
        for (Tile tile : game.getTableChain())
        {
            System.out.print(Arrays.toString(tile.getEnds()));
        }
        System.out.println();
        System.out.println("_________ENDED TURN___________");
    }
    
    /**
     * Prints the current player info and the options
     * it is focused to be used by human players
     */
    private void printPlayerOptions()
    {
        System.out.println("Turn: " + (game.getTurnsPassed() + 1));
        System.out.println("Player: " + game.getCurrentPlayer().getName());
        System.out.print("Hand: ");
        for (Tile tile : game.getCurrentPlayer().getHand())
        {
            System.out.print(Arrays.toString(tile.getEnds()));
        }
        System.out.println();
        System.out.print("Table: ");
        for (Tile tile : game.getTableChain())
        {
            System.out.print(Arrays.toString(tile.getEnds()));
        }
        System.out.println();
        System.out.println("1. Play Tile      2. Draw Tile       3. Pass");
    }
    
    /**
     * Prints who is the first player and the state of the table
     */
    private void printFirstPlayer()
    {
        System.out.println("First Player: " + game.getPreviousPlayer().getName());
        System.out.print("Table: ");
        for (Tile tile : game.getTableChain())
        {
            System.out.print(Arrays.toString(tile.getEnds()));
        }
        System.out.println();
    }
    
    /**
     * Prints the boneyard
     */
    private void printBoneyard()
    {
        System.out.println("Boneyard: ");
        if (!game.getBoneyard().isEmpty())
        {
            for (Tile tile: game.getBoneyard())
            {
                System.out.print(Arrays.toString(tile.getEnds()));
            }
            System.out.println();
        }
        else
        {
            System.out.println("Boneyard is empty!!!");
        }
    }
}