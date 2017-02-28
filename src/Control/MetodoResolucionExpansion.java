package Control;

import Modelo.Grafo;
import Modelo.GrafoOrdenable;

/**
 * Interfaz de metodo de resolucion de problemas
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public interface MetodoResolucionExpansion {

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
    public Grafo resuelve(GrafoOrdenable grafo, MetodoOrdenacion metodoOrd) throws Exception;

}
