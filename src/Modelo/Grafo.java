package Modelo;

/**
 * Clase de modelo de un grafo
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class Grafo {

    private final int[][] matAdyacencia;

    /**
     * @param nNodos
     */
    public Grafo(int nNodos) {
        this.matAdyacencia = new int[nNodos][nNodos];
        for (int[] fila : matAdyacencia) {
            for (int j = 0; j < fila.length; j++) {
                fila[j] = -1;
            }
        }
    }

    /**
     * @param matAdyacencia matriz origen de datos del grafo
     */
    public Grafo(int[][] matAdyacencia) {
        this.matAdyacencia = matAdyacencia;
    }

    /**
     * @return Número de nodos.
     */
    public int getnNodos() {
        return matAdyacencia.length;
    }

}
