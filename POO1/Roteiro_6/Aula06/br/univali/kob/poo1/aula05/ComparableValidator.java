package br.univali.kob.poo1.aula05;

import java.time.format.DateTimeFormatter;

/**
 * Classe genérica para validação de dados comparáveis
 * 
 * @author Mauricio
 * 
 * @param <Type> qualquer classe que implemente Comparable
 */
public class ComparableValidator<Type extends Comparable> extends Validator {
        
    private static DateTimeFormatter dateFormat;
    
    public ComparableValidator()
    {
        dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    public ComparableValidator(DateTimeFormatter format)
    {
        dateFormat = format;
    }
    
    /**
     * Verifica se um valor Comparable está dentro de uma faixa específica.
     * 
     * @param value o valor a ser validado
     * @param valueLabel o texto referente ao valor que será utilizado na exceção
     * @param min o valor mínimo para a faixa (inclusive)
     * @param max o valor máximo para a faixa (inclusive)
     * 
     * @throws NullPointerException se o valor for null
     * @throws IllegalArgumentException se o valor estiver fora da faixa especificada
     */
    public final void range(Type value, String valueLabel, Type min, Type max)
    {
        notNull(value, valueLabel);
        
        if (min.compareTo(max) > 0)
        {
            throw new IllegalArgumentException(min.toString() + ", " + max.toString());
        }
        if (value.compareTo(min) < 0 || value.compareTo(max) > 0)
        {
            throw new OutOfRangeException(value.toString(),
                    value.getClass().getSimpleName() + "." + valueLabel, min.toString(), max.toString());
        }
    }
}
