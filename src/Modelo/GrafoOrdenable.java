package Modelo;

import java.util.Collection;

/**
 * Clase de modelo de un grafo
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class GrafoOrdenable implements Grafo{

    private final Collection aristas;
    private final int nNodos; 

    /**
     * @param matAdyacencia matriz origen de datos del grafo
     */
    public GrafoOrdenable(int[][] matAdyacencia) {
        this.nNodos=matAdyacencia.length;
        this.aristas = new ContenedorAristas(matAdyacencia) {};
    }

    public Collection getContenedor() {
        return aristas;
    }

    @Override
    public int getnNodos() {
        return this.nNodos;
    }

    @Override
    public int getnAristas() {
        return this.aristas.size();
    }
}
