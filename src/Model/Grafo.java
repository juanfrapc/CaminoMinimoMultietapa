package Model;

import Control.MetodoResolucion;

/**
 *
 * @author Entrar
 */
public class Grafo {
    private  int nNodos;
    private  ContenedorAristas aristas;

    
    public Grafo(int nNodos, Arista[] aristas) {
        this.nNodos = nNodos;
        this.aristas = new ContenedorAristas(aristas);
    }

    public Grafo(int[][] matAdyacencia) {
        this.nNodos = matAdyacencia.length;
        this.aristas = new ContenedorAristas(matAdyacencia);
    }

    public int getnNodos() {
        return nNodos;
    }

    public ContenedorAristas getAristas() {
        return aristas;
    }
        
    public Grafo arbolExpansionMinimo(MetodoResolucion metodo){
        return metodo.resuelve();
    }
}
