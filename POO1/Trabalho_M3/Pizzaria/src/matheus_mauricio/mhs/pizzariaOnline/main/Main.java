package matheus_mauricio.mhs.pizzariaOnline.main;

import matheus_mauricio.mhs.pizzariaOnline.lib.io.Input;

/**
 * Inicializa o programa.
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class Main {

    /**
     * Main method.
     * @param args Argumentos que podem ser passados ao metodo main
     */
    public static void main(String args[]) {
        new Main().run();
    }

    /**
     * Runs the program.
     */
    public void run() {
        new Input().run();
    }

}