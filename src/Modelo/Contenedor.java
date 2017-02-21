package Modelo;

public interface Contenedor extends Iterable<Arista>{

    public int tamaño();

    public boolean isEmpty();

    public boolean existeArista(int origen, int destino);

    public boolean añadeArista(int origen, int destino, int peso);

    public boolean remove(int origen, int destino);

    public void limpiar();

    public int getPeso(int nodoPadre, int nodo);

}
