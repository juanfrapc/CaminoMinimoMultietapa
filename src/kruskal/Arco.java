package kruskal;

/**
 *
 * @author Entrar
 */
public class Arco {
    private final int origen;
    private final int destino;
    private final int peso;

    public Arco(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
    
}
