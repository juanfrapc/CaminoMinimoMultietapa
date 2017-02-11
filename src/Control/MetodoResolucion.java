package Control;

import Modelo.Grafo;

/**
 * Interfaz de metodo de rosolucion de problemas
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public interface MetodoResolucion {

    /**
     * @return Nombre del metodo
     */
    public String nombre();

    /**
     *
     * @param grafo
     * @param metodoOrd
     * @return Grafo Solucion
     * @throws Exception Grafo no conexo
     */
    public Grafo resuelve(Grafo grafo, MetodoOrdenacion metodoOrd) throws Exception;

}
