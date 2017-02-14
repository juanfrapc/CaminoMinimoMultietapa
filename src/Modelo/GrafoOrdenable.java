package Modelo;

/**
 * Clase de modelo de un grafo
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class GrafoOrdenable extends Grafo{

    private final ContenedorAristas aristas;

    /**
     * @param matAdyacencia matriz origen de datos del grafo
     */
    public GrafoOrdenable(int[][] matAdyacencia) {
        super(matAdyacencia.length);
        this.aristas = new ContenedorAristas(matAdyacencia);
    }

    /**
     * @return Contenedor de aristas
     */
    public ContenedorAristas getConjuntoAristas() {
        return aristas;
    }
}
