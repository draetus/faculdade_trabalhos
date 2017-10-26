package br.univali.kob.poo1.aula07;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class AppConfig {
    
    /**
     * Nome da aplicação
     */
    public static final String APP_NAME;
    
    /**
     * Versão da aplicação
     */
    public static final String APP_VERSION;
    
    /**
     * Constante com formato brasileiro de data
     */
    public static final DateTimeFormatter DATE_FORMAT;
    
    /**
     * Constante com formato de quebra de linha, conforme sistema operacional usado
     */
    public static final String NEW_LINE;
    
    /**
     * Armazenar as configurações lidas de alguma fonte
     */
    public static final ArrayList<Object> SETTINGS = new ArrayList<>();
    
    /**
     * Um bloco static é um bloco normal de codigo cercado por chaves
     * Uma classe pode ter vários bloco static, os quais podem aparecer em qualquer
     * local do corpo da classe. O sistema de execução JVM garante que a inicialização
     * feita nestes blocos seja feita na ordem em que eles aparecem no código
     * Os atributos static final devem ser inicializados aqui
     */
    static
    {
        loadSettings();
        APP_NAME = (String)SETTINGS.get(0);
        APP_VERSION = (String)SETTINGS.get(1);
        DATE_FORMAT = (DateTimeFormatter)SETTINGS.get(2);
        NEW_LINE = (String)SETTINGS.get(3);
    }
    
    /**
     * Carrega as configurações de alguma fonte como, por exemplo, um
     * arquiv XML ou de propriedades do sistema
     */
    private static void loadSettings()
    {
        // Inserir aqui o codigo para carregar preencher settings a
        // partir de alguma fonte
        SETTINGS.add("Sistema Academico");
        SETTINGS.add("1.0");
        SETTINGS.add(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        SETTINGS.add(System.getProperty("line.separator"));
    }
}
