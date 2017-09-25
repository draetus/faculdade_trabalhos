package br.univali.kob.poo1.aula05;

/**
 *
 * Base para a hierarquia de validadores. Nesta versão, foi implementado
 * apenas o comportamento default para verificar se um valor é null
 * @author Mauricio
 */
public class Validator {
    
    /**
     * Verifica se um valor é null
     * 
     * @param value o valor a ser validado
     * @param valueLabel o texto referente ao valor que será utilizado na exceção
     * 
     * @throws NullPointerException se value for null
     */
    public final void notNull(Object value, String valueLabel)
    {
        if (value == null)
        {
            throw new NullPointerException(valueLabel + " cannot be null");
        }
    }
    
}
