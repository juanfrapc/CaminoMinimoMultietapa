package Modelo;

/**
 * Clase de modelo de un grafo
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class Grafo {

    private final int nNodos;
    private final ContenedorAristas aristas;

    /**
     * @param nNodos
     * @param contenedorAristas 
     */
    public Grafo(int nNodos, ContenedorAristas contenedorAristas) {
        this.nNodos = nNodos;
        this.aristas = contenedorAristas;
    }

    /**
     * @param matAdyacencia matriz origen de datos del grafo
     */
    public Grafo(int[][] matAdyacencia) {
        this.nNodos = matAdyacencia.length;
        this.aristas = new ContenedorAristas(matAdyacencia);
    }

    /**
     * @return Número de nodos.
     */
    public int getnNodos() {
        return nNodos;
    }

    /**
     * @return Contenedor de aristas
     */
    public ContenedorAristas getConjuntoAristas() {
        return aristas;
    }
}
