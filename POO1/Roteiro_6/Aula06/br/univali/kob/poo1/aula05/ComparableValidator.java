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
        
    /**
     * Formato da data
     */
    private static DateTimeFormatter dateFormat;
    
    /**
     * Construtor sem parametros
     */
    public ComparableValidator()
    {
        dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    /**
     * Construtor com parametros
     * @param format Formato da data
     */
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
    
    /**
     * Verifica se um valor Comparable é menor ou igual ao outro valor.
     * 
     * @param value o valor a ser validado
     * @param valueLabel o texto referente ao valor que será utilizado na exceção
     * @param otherValue o valor a ser comparado
     * 
     * @throws NullPointerException se um dos valores for null
     * @throws IllegalArgumentException se value não for menor ou igual ao outro valor
     */
    public final void lessOrEquals(Type value, String valueLabel, Type otherValue)
    {
        notNull(value, valueLabel);
        notNull(otherValue, "Other Value");
        if (value.compareTo(otherValue) > 0)
        {
            throw new IllegalArgumentException(valueLabel + " (" + value.toString()
                    + ") must be less than or equals to " + otherValue);
        }
    }
}