package br.univali.kob.poo1.aula07;

/**
 * Validates the a String based in the number of words that it haa
 * @author Mauricio
 */
public class StringValidator extends Validator {
    
    /**
     * Check the minimum of words that the word must have
     * @param word Word that will be checked
     * @param min Minimum of words estabilished
     */
    public void minWordsCount(String word, int min)
    {
        if (countWords(word) < min)
        {
            throw new IllegalArgumentException("Invalid String, number of words must be "
                    + "greater or equal than: " + min);
        }
    }
    
    public void maxWordsCount(String word, int max)
    {
        if (countWords(word) > max)
        {
            throw new IllegalArgumentException("Invalid String, number of words must be "
                    + "less or equal than: " + max);
        }
        
    }
    
    public int countWords(String s)
    {
        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
