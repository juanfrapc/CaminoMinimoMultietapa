package Control;

import Modelo.Grafo;

public interface MetodoResolucion {

    public String nombre();

    public Grafo resuelve(Grafo grafo, MetodoOrdenacion metodoOrd);

}
