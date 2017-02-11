package Modelo;

/**
 * Clase modelo de arista
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class Arista {

    private final int origen;
    private final int destino;
    private final int peso;

    /**
     * @param origen
     * @param destino
     * @param peso
     */
    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * @return Nodo Origen
     */
    public int getOrigen() {
        return origen;
    }

    /**
     * @return Nodo destino
     */
    public int getDestino() {
        return destino;
    }

    /**
     * @return Peso de la arista
     */
    public int getPeso() {
        return peso;
    }

}
