package Modelo;

public class GrafoMultietapa implements Grafo {

    private final ContenedorMatriz contenedorMatriz;

    public GrafoMultietapa(int[][] matAdyacencia) {
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

}
