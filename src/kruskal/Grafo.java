package kruskal;

/**
 *
 * @author Entrar
 */
public class Grafo {
    private  int nNodos;
    private  Arco[] aristas;
    private int  nArcos;

    
    public Grafo(int nNodos, Arco[] aristas) {
        this.nNodos = nNodos;
        this.aristas = aristas;
    }

    public Grafo(int nNodos, int[][] matAdyacencia) {
        int cont = 0;
        for (int i = 0; i < matAdyacencia.length; i++) {
            for (int j = 0; j < matAdyacencia[i].length; j++) {
                if (matAdyacencia[i][j] != -1) {
                    cont++;
                }
            }
        }
        Arco[] arcos = new Arco[cont];
        
        
    }
        
}
