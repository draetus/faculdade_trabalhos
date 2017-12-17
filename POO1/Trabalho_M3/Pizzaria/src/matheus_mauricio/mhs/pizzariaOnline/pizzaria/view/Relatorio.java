package matheus_mauricio.mhs.pizzariaOnline.pizzaria.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import matheus_mauricio.mhs.pizzariaOnline.persistencia.Repositorio;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade.ItemPedido;

/**
 *  Classe base para relatorios de pizzas vendidas e nao vendidas
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public abstract class Relatorio {
    
    /**
     * Titulo do arquivo
     */
    private final String titulo;
    
    /**
     * Cabecalho a ser impresso no comeco do arquivo
     */
    private final String cabecalho;
    
    /**
     * Rodape a ser impresso no final do arquivo
     */
    private final String rodape;
    
    /**
     * Repositorio contendo os itens pedidos que serão impressos no arquivo
     */
    protected Repositorio<ItemPedido> itensPedidos = new Repositorio<>();
    
    /**
     * Construtor
     * @param cabecalho Cabecalho a ser impresso no comeco do arquivo
     * @param rodape Rodape a ser impresso no final do arquivo
     * @param titulo Titulo do arquivo
     */
    protected Relatorio(String cabecalho, String rodape, String titulo)
    {
        this.cabecalho = cabecalho;
        this.rodape = rodape;
        this.titulo = titulo;
    }
    
    /**
     * Executa a criação do arquivo txt
     */
    public void run()
    {
        try 
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(titulo));
            saveCabecalho(writer);
            saveCorpo(writer);
            saveRodape(writer);
            writer.close();
        }
        catch (IOException ex) 
        {
            System.out.println("Erro ao abrir o arquivo.");
        }
    }
    
    /**
     * Imprime o cabeçalho no arquivo
     * @param writer Arquivo em que será impresso o cabecalho
     * @throws IOException 
     */
    private void saveCabecalho(BufferedWriter writer) throws IOException
    {

        writer.write(cabecalho);
        writer.newLine();
    }
    
    /**
     * Imprime o rodapé no arquivo
     * @param writer Arquivo em que será impresso o rodapé
     * @throws IOException 
     */
    private void saveRodape(BufferedWriter writer) throws IOException
    {
        writer.write(rodape);
    }
    
    /**
     * Imprime o corpo no arquivo
     * @param writer Arquivo em que será impresso o corpo
     * @throws IOException 
     */
    private void saveCorpo(BufferedWriter writer) throws IOException
    {
        for (int i=0; i<itensPedidos.getAll().size(); i++)
        {
            writer.write(itensPedidos.get(i).getPizza().getNome());
            writer.newLine();
            writer.write(itensPedidos.get(i).getTamanho().getDescription());
            writer.newLine();
            writer.write(Integer.toString(itensPedidos.get(i).getTamanho().getTamanho()));
            writer.newLine();
            writer.write(itensPedidos.get(i).getPreco().toString());
            writer.newLine();
        }
    }
}
