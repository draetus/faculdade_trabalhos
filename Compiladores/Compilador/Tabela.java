import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class Tabela {
    
    public String contexto;
    public int VT;
    public int VP;
    public int VIT;
    public int tipo;
    public int ponteiro;
    public boolean variavel_indexada;
    public PilhaDesvio pilha_desvios = new PilhaDesvio();
    public ArrayList<Simbolo> tabela_simbolos = new ArrayList<>();
    public ArrayList<Instrucao> area_instrucoes = new ArrayList<>();
    public Simbolo tupla;
    
    public String[] aux = new String[50];
    public ArrayList<Integer> lista_atributos = new ArrayList<>();
   
    public ArrayList<Integer> acao = new ArrayList<>();
    
    public Tabela()
    {
        this.VT = 0;
        this.VP = 0;
        this.VIT = 0;
        this.ponteiro = 1;
    }  
    
    public boolean ExisteIdentificar(String nome)
    {
        for (Simbolo s: tabela_simbolos)
        {
            if (s.nome.equals(nome))
            {
                return true;
            }
        }
        return false;
    }
    
    public int indexIdentificador(String nome)
    {
        int index = -1;
        for (Simbolo s: tabela_simbolos)
        {
            if (s.nome.equals(nome))
            {
                index++;
                return index;
            }
            else
            {
                index++;
            }
        }
        return -1;
    }
    
    
    
}
