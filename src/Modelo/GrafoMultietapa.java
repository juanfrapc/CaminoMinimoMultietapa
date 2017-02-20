package Modelo;

public class GrafoMultietapa implements Grafo {

    private final int[] etapas;
    private final ContenedorMatriz contenedorMatriz;

    public GrafoMultietapa(int[] etapas, int[][] matAdyacencia) {
        this.etapas = etapas;
        this.contenedorMatriz = new ContenedorMatriz(matAdyacencia);
    }

    @Override
    public int getnNodos() {
        return this.contenedorMatriz.getnNodos();
    }

    @Override
    public int getnAristas() {
        return this.contenedorMatriz.tamaño();
    }

    @Override
    public Contenedor getContenedor() {
        return contenedorMatriz;    
    }
    
    public int etapaNodo(int nodo) {
        return etapas[nodo];
    }

}
