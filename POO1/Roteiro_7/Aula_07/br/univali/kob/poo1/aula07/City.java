package br.univali.kob.poo1.aula07;

/**
 * Classe que representa uma cidade com um estado correspondente.
 * @author Mauricio
 */
public final class City {
    
    /**
     * Nome da cidade
     */
    private final String name;
    
    /**
     * Estado da cidade
     */
    private final State state;
    
    /**
     * Constructor
     * @param name Nome da cidade
     * @param state Estado relacionado a cidade
     */
    public City(String name, State state)
    {
        StringValidator val = new StringValidator();
        
        val.minWordsCount(name, 1);
        
        this.name = name;
        this.state = state;
    }
    
    /**
     * Getter
     * @return Nome da cidade
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Getter
     * @return Estado da cidade
     */
    public State getState()
    {
        return this.state;
    }
    
    /**
     * Método sobrescrito equals
     * @param obj Objeto a ser comparado
     * @return true se igual 
     *         false se diferente
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        City city = (City)obj;
        
        return
                name.equals(city.name) && state.equals(city.state);
    }

    /**
     * Método sobrescrito hashcode
     * @return Valor correspondente ao hashcode do objeto
     */
    @Override
    public int hashCode() {
        return (name.hashCode()) ^ (state.hashCode());
    }
    
    /**
     * Retorna uma string representando as informações da classe
     * @return String com informações da classe
     */
    @Override
    public String toString()
    {
        return "\nCidade:\nNome: " + name + state.toString() + "\n";
    }
    
}
