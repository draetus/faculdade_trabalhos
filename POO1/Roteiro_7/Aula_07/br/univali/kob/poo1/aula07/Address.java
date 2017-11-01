package br.univali.kob.poo1.aula07;

/**
 * Classe representando endereço de uma cidade
 * @author Mauricio
 */
public final class Address {
    
    /**
     * Endereço principal, Nome da rua, Numero da casa, etc
     */
    private final String streetLine1;
    
    /**
     * Complemento de endereço
     */
    private final String streetLine2;
    
    /**
     * CEP
     */
    private final String zipCode;
    
    /**
     * Cidade do endereço
     */
    private final City city;
    
    /**
     * Constructor
     * @param streetLine1 Endereço principal, Nome da rua, Numero da casa, etc
     * @param streetLine2 Complemento de endereço
     * @param city Cidade do endereço
     * @param zipCode CEP
     */
    public Address(String streetLine1, String streetLine2, City city, String zipCode)
    {
        StringValidator val = new StringValidator();
        
        val.minWordsCount(streetLine1, 1);
        val.maxWordsCount(zipCode, 1);
        
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.zipCode = zipCode;
        this.city = city;
    }
    
    /**
     * Getter
     * @return Endereço principal, Nome da rua, Numero da casa, etc
     */
    public String getStreetLine1()
    {
        return this.streetLine1;
    }
    
    /**
     * Getter
     * @return Complemento de endereço
     */
    public String getStreetLine2()
    {
        return this.streetLine2;
    }
    
    /**
     * Getter
     * @return Cidade do endereço
     */
    public City getCity()
    {
        return this.city;
    }
    
    /**
     * Getter
     * @return CEP
     */
    public String getZipCode()
    {
        return this.zipCode;
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
        Address address = (Address)obj;
        
        return
                streetLine1.equals(address.streetLine1) &&
                streetLine2.equals(address.streetLine2) &&
                zipCode.equals(address.zipCode) &&
                city.equals(address.city);
    }

    /**
     * Método sobrescrito hashcode
     * @return Valor correspondente ao hashcode do objeto
     */
    @Override
    public int hashCode() {
        return (streetLine1.hashCode()) ^
               (streetLine2.hashCode()) ^
               (zipCode.hashCode()) ^
               (city.hashCode());
    }
    
    /**
     * Retorna uma string representando as informações da classe
     * @return String com informações da classe
     */
    @Override
    public String toString()
    {
        return "\nEndereço: " + streetLine1 + 
                "\nComplemento: " + streetLine2 +
                "\nCEP: " + zipCode +
                city.toString();
    }
}
