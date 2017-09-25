package br.univali.kob.poo1.aula05;

/**
 *
 * @author Mauricio
 */
public class OutOfRangeException extends IllegalArgumentException {
    
    /**
     * Valor avaliado que está fora da faixa esperada
     */
    private final Object value;
    
    /**
     * Texto que descreve o valor
     */
    private final String valuelabel;
    
    /**
     * Valor minimo definido pela faixa
     */
    private final Object min;
    
    /**
     * Valor máximo definido pela faixa
     */
    private final Object max;
    
    /**
     * A mensagem é montada com o rótulo passado no parâmetro.
     * 
     * @param value o valor avaliado que está fora da faixa esperada
     * @param valuelabel o texto que descreve o valor
     * @param min o valor minimo aceitável pela faixa
     * @param max o valor máximo aceitável pela faixa
     */
    public OutOfRangeException(int value, String valuelabel, int min, int max)
    {
        super ("Value: " + value + " for " + valuelabel + " is out of range ["
        + min + ".." + max + "]");
        this.value = value;
        this.valuelabel = valuelabel;
        this.min = min;
        this.max = max;
    }
    
    /**
     * A mensagem é montada com o rótulo passado no parâmetro.
     * 
     * @param value o valor avaliado que está fora da faixa esperada
     * @param valuelabel o texto que descreve o valor
     * @param min o valor minimo aceitável pela faixa
     * @param max o valor máximo aceitável pela faixa
     */
    public OutOfRangeException(String value, String valuelabel, String min, String max)
    {
        super ("Value: " + value + " for " + valuelabel + " is out of range ["
        + min + ".." + max + "]");
        this.value = value;
        this.valuelabel = valuelabel;
        this.min = min;
        this.max = max;
    }
    
    /**
     * @return o valor avaliado que está fora da faixa esperada
     */
    public Object getValue()
    {
        if (value instanceof Integer)
            return (int)value;
        
        if (value instanceof String)
            return (String)value;
        
        return null;
    }
    
    /**
     * @return o texto que descreve o valor
     */
    public String getValueLabel()
    {
        return valuelabel;
    }
    
    /**
     * @return o valor minimo aceitável pela faixa
     */
    public Object getMin()
    {
        if (value instanceof Integer)
            return (int)value;
        
        if (value instanceof String)
            return (String)value;
        
        return null;
    }
    
    /**
     * @return o valor máximo aceitável pela faixa
     */
    public Object getMax()
    {
        if (value instanceof Integer)
            return (int)value;
        
        if (value instanceof String)
            return (String)value;
        
        return null;
    }
}