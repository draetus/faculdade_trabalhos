package ia;

import java.util.ArrayList;
import java.util.List;

public class IA {

    List<Game> games = new ArrayList();
    List<Game> gamesOrdenadorPorScore = new ArrayList();
    public void run() {
        addCaso("Assassins Creed", 100, 2015, "TPS", "Acao", "Simulacao", "Offline", "Sem Assinatura", "Sem Microtransacao", "Ubisoft", "Muito Positiva", "12");
        addCaso("Far cry 4", 80, 2018, "FPS", "FPS", "Tiro", "Offline", "Sem Assinatura", "Sem Microtransacao", "Ubisoft", "Muito Positiva", "18");
        addCaso("Skyrim", 75, 2012, "TPS", "RPG", "Mundo Aberto", "Offline", "Sem Assinatura", "Sem Microtransacao", "Bethesda", "Extremamente Positiva", "18");
        addCaso("Terraria", 30, 2005, "Rolagem", "Aventura", "Fantasia", "Online", "Sem Assinatura", "Sem Microtransacao", "Indie", "Extremamente Positiva", "16");
        addCaso("Minecraft", 40, 2000, "FPS", "Aventura", "Mundo Aberto", "Online", "Sem Assinatura", "Com Microtransacao", "Microsoft", "Positiva", "14");
        addCaso("Fortnite", 0, 2016, "TPS", "FPS", "Tiro", "Online", "Sem Assinatura", "Com Microtransacao", "Indie", "Muito Negativa", "Livre");

    }

    public void addCaso(String nome, double valor, int ano, String visao, String genero, String tema, String online, String assinatura, String microtransacao, String produtora, String avaliacao, String faixa_etaria) {
        Game game = new Game(nome, valor, ano, visao, genero, tema, online, assinatura, microtransacao, produtora, avaliacao, faixa_etaria);
        games.add(game);
    }

    public void criaScore(String visao, String produtora, String faixaEtaria, String microtransacao, String assinatura, String online, String tema, String genero, String avaliacao, double valor, int ano) {
        
        Score score;
        score = new Score();
        
        for (Game jogo : games) {
            
            double scoreValue = 0;
            double valorVisao;
            double valorTema;
            double valorProdutora;
            double valorGenero;
            double valorAvaliacao;
            double valorFaixaEtaria;
            double valorMicroTransacao;
            double valorOnline;
            double valorAssinatura;
            double valorValor;
            double valorAno;
            valorVisao = score.tipo_visao_similaridade[score.converteVisao(visao)][score.converteVisao(jogo.tipo_visao)] * 0.9;
            valorTema = score.tema_similaridade[score.converteTema(tema)][score.converteTema(jogo.tema)] * 0.3;
            valorProdutora = score.produtora_similaridade[score.converteProdutora(produtora)][score.converteProdutora(jogo.produtora)] * 0.1;
            valorGenero = score.genero_similaridade[score.converteGenero(genero)][score.converteGenero(jogo.genero)];
            valorAvaliacao = score.avaliacao[score.converteAvaliacao(avaliacao)][score.converteAvaliacao(jogo.avaliacao)];
            valorFaixaEtaria = score.faixa_etaria[score.converteFaixaEtaria(faixaEtaria)][score.converteFaixaEtaria(jogo.faixa_etaria)] * 0.8;

            if (microtransacao.equals(jogo.microtransacao)) {
                valorMicroTransacao = 0.2 ;
            } else {
                valorMicroTransacao = 0.0;
            }
            if (online.equals(jogo.online)) {
                valorOnline = 0.9;
            } else {
                valorOnline = 0.0;
            }

            if (assinatura.equals(jogo.assinatura)) {
                valorAssinatura = 0.8;
            } else {
                valorAssinatura = 0.0;
            }
            if (jogo.valor + 20 > valor) {
                valorValor = 0.6;
            } else {
                valorValor = 0.0;
            }
            if (jogo.ano_lancamento + 2 < ano || jogo.ano_lancamento - 2 > ano) {
                valorAno = 0.1;
            } else {
                valorAno = 0.0;
            }

            scoreValue = valorVisao + valorTema + valorProdutora + valorGenero + valorAvaliacao + valorFaixaEtaria + valorMicroTransacao + valorOnline + valorAssinatura + valorValor + valorAno;
            jogo.score = scoreValue;
            System.out.println("Score = " + jogo.score);
        }
    }

    public void scoreList() {
        
        while (!games.isEmpty()) {
            double maior = 0;
            Game maiorScore = games.get(0);
            for (Game jogo : games) {
                if(jogo.score > maior){
                    maior = jogo.score;
                    maiorScore = jogo;
                }
            }
            gamesOrdenadorPorScore.add(maiorScore);
            games.remove(maiorScore);
        }
        
    }
}
