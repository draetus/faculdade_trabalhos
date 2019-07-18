
package ia;


public class Game {
   
    public int ano_lancamento;
    public double valor;
    public String faixa_etaria;
    public String avaliacao;    
    public String tipo_visao;
    public String genero;
    public String tema;
    public String produtora;
    public String nome;
    public String online;
    public String assinatura;
    public String microtransacao;
    public double score;
    
    public Game(String nome, double valor, int ano, String visao, String genero, String tema, String online, String assinatura, String microtransacao, String produtora, String avaliacao, String faixa_etaria){
        
        this.ano_lancamento = ano;
        this.faixa_etaria = faixa_etaria;
        this.valor = valor;
        this.avaliacao = avaliacao;
        this.tipo_visao = visao;
        this.genero = genero;
        this.tema = tema;
        this.produtora = produtora;
        this.nome = nome;
        this.online = online;
        this.assinatura = assinatura;
        this.microtransacao = microtransacao;
        this.score = 0;
    }
    
}
