package Modelo;

public class Grafo {
    private int nNodos;
    private ContenedorAristas aristas;

    public Grafo(int nNodos, ContenedorAristas contenedorAristas) {
        this.nNodos = nNodos;
        this.aristas = contenedorAristas;
    }

    public Grafo(int[][] matAdyacencia) {
        this.nNodos = matAdyacencia.length;
        this.aristas = new ContenedorAristas(matAdyacencia);
    }

    public int getnNodos() {
        return nNodos;
    }

    public ContenedorAristas getConjuntoAristas() {
        return aristas;
    }
}
