package matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade;

import java.math.BigDecimal;

/**
 * Gerencia a relação entre pizza e tamanho e o preço gerado através de tal relação
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class ItemPedido {

    /**
     * Pizza relacionada ao item pedido
     */
    private final Pizza pizza;
    
    /**
     * Tamanho da pizza
     */
    private final Tamanho tamanho;
    
    /**
     * preco da pizza relativo a seu sabor e seu tamanho
     */
    private final BigDecimal preco;
    
    /**
     * Construtor
     * @param pizza Pizza relacionada ao item pedido
     * @param tamanho Tamanho da pizza
     * @param preco Preco da pizza relativo a seu sabor e seu tamanho
     */
    public ItemPedido(Pizza pizza, Tamanho tamanho, BigDecimal preco) {
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.preco = preco;
    }
    
    /**
     * Getter
     * @return Pizza relacionada ao item pedido
     */
    public Pizza getPizza()
    {
        return pizza;
    }
    
    /**
     * Getter
     * @return Tamanho da pizza
     */
    public Tamanho getTamanho()
    {
        return tamanho;
    }
    
    /**
     * Getter
     * @return Preco da pizza relativo a seu sabor e seu tamanho
     */
    public BigDecimal getPreco()
    {
        return preco;
    }
}
