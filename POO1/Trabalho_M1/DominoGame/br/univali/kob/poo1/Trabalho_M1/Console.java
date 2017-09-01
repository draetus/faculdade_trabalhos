package br.univali.kob.poo1.Trabalho_M1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mauricio
 */
public class Console {
    /**
     * Integgers datas to be asked and printed 
     * @param question
     * @return 
     */
    public static int readInt(String question)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        int answer;
        while (true)
        {
            try
            {
                answer = scanner.nextInt();
                break;
            }
            catch  (InputMismatchException e)
            {
                scanner.nextLine();
                System.out.println("You must enter a number");
            }
        }
        return answer;
    }
    
    /**
     * Read a value between the begin(2) and te end(4)
     * To set the players number
     * @param question
     * @param begin
     * @param end
     * @return 
     */
    public static int readIntBetween(String question, int begin, int end)
    {
        Scanner scanner = new Scanner(System.in);
        int answer;
        System.out.print(question);
                while (true)
        {
            try
            {
                do
                {
                    answer = scanner.nextInt();
                }
                while (answer<begin || answer>end);
                break;
            }
            catch  (InputMismatchException e)
            {
                scanner.nextLine();
                System.out.println("You must enter a number");
            }
        }
        return answer;
    }
    
    /**
     * Asks if the player wanna play the game or if he wanna a demostration game
     * (only bots)
     * @param question
     * @return 
     */
    public static boolean ask(String question)
    {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do
        {
            System.out.print(question);
            answer = scanner.next();
        }
        while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n"));
        return answer.toLowerCase().equals("y");
    }
    
    /**
     * 
     * @param question
     * @return 
     */
    public static String readLine(String question)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();
    }
    
    /**
     * Waits for Enter
     */
    public static void WaitForEnter()
    {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}