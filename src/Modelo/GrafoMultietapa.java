package Modelo;

public class GrafoMultietapa implements Grafo, Cloneable {

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

    @Override
    public Object clone() {
        int[] etapasClon = new int[etapas.length];
        System.arraycopy(etapas, 0, etapasClon, 0, etapas.length);
        
        int[][] matAdyacencia = new int[etapas.length][etapas.length];
        for (int i = 0; i < etapas.length; i++) {
            for (int j = 0; j < etapas.length; j++) {
                matAdyacencia[i][j] = -1;
            }
        }
        for (Arista a : contenedorMatriz) {
            matAdyacencia[a.getOrigen()][a.getDestino()] = a.getPeso();
        }
        
        return new GrafoMultietapa(etapasClon, matAdyacencia);
    }

}
