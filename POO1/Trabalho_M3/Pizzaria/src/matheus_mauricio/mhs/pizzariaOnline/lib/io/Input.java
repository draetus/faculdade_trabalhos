package matheus_mauricio.mhs.pizzariaOnline.lib.io;

import matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade.Pizza;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade.Cliente;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade.ItemPedido;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade.Tamanho;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade.Pedido;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import matheus_mauricio.mhs.pizzariaOnline.persistencia.Repositorio;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.view.NaoVendido;
import matheus_mauricio.mhs.pizzariaOnline.pizzaria.view.Vendido;

/**
 * Gerencia os arquivos recebidos e controla o fluxo do sistema.
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class Input {

    /**
     * Repositorio de pedidos.
     */
    private final Repositorio<Pedido> repositorioDePedidos = new Repositorio<>();

    /**
     * Repositorio de clientes.
     */
    private final Repositorio<Cliente> repositorioDeClientes = new Repositorio<>();

    /**
     * Repositorio de pizzas.
     */
    private final Repositorio<Pizza> repositorioDePizzas = new Repositorio<>();
    
    /**
     * Repositorio de tamanhos
     */
    private final Repositorio<Tamanho> repositorioDeTamanho = new Repositorio<>();
    
    /**
     * Repositorio de Item Pedido
     */
    private final Repositorio<ItemPedido> repositorioDeItemPedido = new Repositorio<>();

    /**
     * Inicia o programa.
     */
    public void run() {
        geraMenu();
        geraClientes();
        geraPedidos();
        pizzasVendidas();
        pizzasNaoVendidas();
    }

    /**
     * Le o arquivo de menu e gera os objetos pizza.
     */
    private void geraMenu() {
        String nomeArquivo = "menu.txt";
        String nome, linha, tamanho;
        int quantidadeIngredientes, quantidadeTamanhos, quantidadePizzas;
        ArrayList<String> ingredientes;
        float valor;
        FileReader leitorDeArquivo;
        BufferedReader leitorDeBuffer;
        
        try 
        {
            leitorDeArquivo = new FileReader(nomeArquivo);
            leitorDeBuffer = new BufferedReader(leitorDeArquivo);
            
            
            // Le primeira linha, quantidade de tamanhos
            quantidadeTamanhos = Integer.parseInt(leitorDeBuffer.readLine());

            // Le tamanhos e quantidade de fatias
            for (int i = 0; i < quantidadeTamanhos; i++) {
                tamanho = leitorDeBuffer.readLine();
                repositorioDeTamanho.salva(new Tamanho(tamanho, Integer.parseInt(leitorDeBuffer.readLine())));
            }

            // Le quantidade de pizzas
            quantidadePizzas = Integer.parseInt(leitorDeBuffer.readLine());
            
            for (int i = 0; i < quantidadePizzas; i++) {
                // Le nome da pizza
                nome = leitorDeBuffer.readLine();

                // Le quantidade de ingredientes
                quantidadeIngredientes = Integer.parseInt(leitorDeBuffer.readLine());
                ingredientes = new ArrayList<>(quantidadeIngredientes);

                // Le ingredientes
                for (int j = 0; j < quantidadeIngredientes; j++) {
                    ingredientes.add(leitorDeBuffer.readLine());
                }

                // Le valores e cria pizzas
                repositorioDePizzas.salva(new Pizza(nome, ingredientes));
                
                for (int j = 0; j < quantidadeTamanhos; j++)
                {
                    repositorioDeItemPedido.salva(new ItemPedido(repositorioDePizzas.get(repositorioDePizzas.getAll().size()-1),
                            repositorioDeTamanho.get(j), new BigDecimal(leitorDeBuffer.readLine())));
                }
            }
            leitorDeBuffer.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Erro ao encontrar o arquivo '" + nomeArquivo + "'");
        }
        catch(IOException ex) {
            System.out.println("Erro ao ler o arquivo '" + nomeArquivo + "'");
        }
    }

    /**
     * Le o arquivo de clientes e gera os objetos cliente.
     */
    private void geraClientes() {
        String nomeArquivo = "clientes.txt";
        String nome, telefone, cpf, endereco, linha;
        int quantidadeClientes;
        
        try {
          FileReader leitorDeArquivo = new FileReader(nomeArquivo);
          BufferedReader leitorDeBuffer = new BufferedReader(leitorDeArquivo);
          
          // Le primeira linha, quantidade de clientes
          quantidadeClientes = Integer.parseInt(leitorDeBuffer.readLine());
          
          // Le cliente
          for (int i = 0; i < quantidadeClientes; i++) {
              nome = leitorDeBuffer.readLine();
              telefone = leitorDeBuffer.readLine();
              cpf = leitorDeBuffer.readLine();
              endereco = leitorDeBuffer.readLine();
              repositorioDeClientes.salva(new Cliente(nome, telefone, cpf, endereco));
          }
          leitorDeBuffer.close();         
        }
        
        catch(FileNotFoundException ex) {
          System.out.println("Erro ao encontrar o arquivo '" + nomeArquivo + "'");             
        }
         catch(IOException ex) {
          System.out.println("Erro ao ler o arquivo '" + nomeArquivo + "'");
        }
    }

    /**
     * Le o arquivo pedidos e gera os objetos pedido.
     */
    private void geraPedidos() {
        String nomeArquivo = "pedidos.txt";
        String cpf;
        boolean confirmacao;
        String nomePizza, tamanho;
        int quantidadePedidos, quantidadePizzas;
        ArrayList<ItemPedido> itensPedidos = new ArrayList<>();
        
        try {
          FileReader leitorDeArquivo = new FileReader(nomeArquivo);
          BufferedReader leitorDeBuffer = new BufferedReader(leitorDeArquivo);
          
          // Le primeira linha, quantidade de pedidos
          quantidadePedidos = Integer.parseInt(leitorDeBuffer.readLine());
          
          for (int i = 0; i < quantidadePedidos; i++) {
              // Le CPF do cliente que realizou o pedido
              cpf = leitorDeBuffer.readLine();
              
              // Le quantidade de pizzas pedidas
              quantidadePizzas = Integer.parseInt(leitorDeBuffer.readLine());
              
              // Le nome da pizza e tamanho
              for (int j = 0; j < quantidadePizzas; j++) {
                  nomePizza = leitorDeBuffer.readLine();
                  tamanho = leitorDeBuffer.readLine();
                  
                  // Checa se item pedido ja existe e faz o pedido apontar para o mesmo
                  for (int k = 0; k < repositorioDeItemPedido.getAll().size(); k++)
                  {
                      if (repositorioDeItemPedido.get(k).getPizza().getNome().equals(nomePizza) &&
                              repositorioDeItemPedido.get(k).getTamanho().getDescription().equals(tamanho))
                      {
                          itensPedidos.add(repositorioDeItemPedido.get(k));
                      }
                  }
              }

              // Le se pedido foi confirmado
              confirmacao = leitorDeBuffer.readLine().equals("Confirmado");
              
              repositorioDePedidos.salva(new Pedido(cpf, confirmacao, new ArrayList<>(itensPedidos)));
              itensPedidos.clear();
          }
          leitorDeBuffer.close();         
        }
        
        catch(FileNotFoundException ex) {
          System.out.println("Erro ao encontrar o arquivo '" + nomeArquivo + "'");             
        }
         catch(IOException ex) {
          System.out.println("Erro ao ler o arquivo '" + nomeArquivo + "'");
        }
    }

    /**
     * Seleciona as pizzas vendidas e invoca o relatorio.
     */
    private void pizzasVendidas() {
        Vendido relatorio = new Vendido("PIZZAS VENDIDAS", "FIM DO RELATORIO", "PizzasVendidas.txt", repositorioDePedidos);
        relatorio.run();
    }

    /**
     * Seleciona as pizzas nao vendidas e invoca o relatorio.
     */
    private void pizzasNaoVendidas() {
        NaoVendido relatorio = new NaoVendido("PIZZAS NAO VENDIDAS", "FIM DO RELATORIO", "PizzasNaoVendidas.txt", repositorioDePedidos);
        relatorio.run();
    }

}