package matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade;

import java.util.*;

/**
 * Gerencia o pedido feito por um Cliente associado a um conjunto de Pizzas.
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class Pedido {

    /**
     * @param cpf Cpf do cliente
     * @param confirmacao Indicando se o pedido foi confirmado ou nao
     * @param itensPedidos Itens contidos no pedido
     */
    public Pedido(String cpf, boolean confirmacao, ArrayList<ItemPedido> itensPedidos) {
        this.cpf = cpf;
        this.confirmacao = confirmacao;
        this.id = Pedido.nextId;
        Pedido.nextId++;
        this.itensPedidos = itensPedidos;
    }
    
    /**
     * ID da classe Pedido.
     */
    private static int nextId = 1;

    /**
     * ID do objeto pedido.
     */
    private final int id;

    /**
     * Cpf do cliente
     */
    private final String cpf;

    /**
     * Itens contidos no pedido
     */
    private final ArrayList<ItemPedido> itensPedidos;
    
    /**
     * Indicando se o pedido foi confirmado ou nao
     */
    private final boolean confirmacao;

    /**
     * Getter
     * @return Itens contidos no pedido
     */
    public ArrayList<ItemPedido> getItemPedidos()
    {
        return itensPedidos;
    }
    
    /**
     * Getter
     * @param i Indice do item desejado
     * @return Item desejado
     */
    public ItemPedido getItemPedido(int i)
    {
        return itensPedidos.get(i);
    }
    
    /**
     * Getter
     * @return Indicante se o pedido foi confirmado ou não
     */
    public boolean getConfirmacao()
    {
        return this.confirmacao;
    }
    
    /**
     * Getter
     * @return ID do pedido
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * Getter
     * @return Cpf do cliente autor do pedido
     */
    public String getCpf()
    {
        return this.cpf;
    }
}