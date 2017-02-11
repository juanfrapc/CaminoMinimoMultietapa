package Control;

import Modelo.ContenedorAristas;

/**
 * Interfaz de método de ordenación.
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public interface MetodoOrdenacion {

    /**
     * @return Nombre del método
     */
    public String nombre();

    /**
     * @param conjunto
     */
    public void ordena(ContenedorAristas conjunto);

}
