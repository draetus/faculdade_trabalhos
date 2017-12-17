package matheus_mauricio.mhs.pizzariaOnline.pizzaria.view;

import matheus_mauricio.mhs.pizzariaOnline.persistencia.Repositorio;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade.Pedido;

/**
 *  Criador do relatorio de pizzas vendidas
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class Vendido extends Relatorio{

    /**
     * Construtor - Organiza Lista de itens pedidos de pedidos confirmados
     * @param cabecalho Cabeçalho a ser impresso no começo do arquivo
     * @param rodape Rodape a ser impresso no final do arquivo
     * @param titulo Titulo do arquivo
     * @param pedidos Pedidos que serão usados para a análise
     */
    public Vendido(String cabecalho, String rodape, String titulo,  Repositorio<Pedido> pedidos) {
        super(cabecalho, rodape, titulo);
        
        boolean nova;
        for (int i=0; i<pedidos.getAll().size(); i++)
        {
            if (pedidos.get(i).getConfirmacao())
            {
                for (int j=0; j<pedidos.get(i).getItemPedidos().size(); j++)
                {
                    nova = true;
                    for (int k=0; k<itensPedidos.getAll().size(); k++)
                    {
                        if (    
                                itensPedidos.get(k).getPizza().getNome().equals(
                                pedidos.get(i).getItemPedido(j).getPizza().getNome()) &&

                                itensPedidos.get(k).getTamanho().equals(
                                pedidos.get(i).getItemPedido(j).getTamanho())
                            )
                        {
                            nova = false;
                            break;
                        }
                    }
                    if (nova)
                    {
                        itensPedidos.salva(pedidos.get(i).getItemPedido(j));
                    }
                }
            }
        }
    }
    
}
