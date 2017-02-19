package Modelo;

import java.util.Iterator;

/**
 * Clase de modelo de contenedor de aristas.
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class ContenedorAristas implements Contenedor{

    private final Arista[] aristas;
    private int nAristas;

    /**
     * @param nNodos
     */
    public ContenedorAristas(int nNodos) {
        this.nAristas = 0;
        this.aristas = new Arista[nNodos * nNodos];
    }

    /**
     * @param aristas
     */
    public ContenedorAristas(Arista[] aristas) {
        nAristas = aristas.length;
        this.aristas = aristas;
    }

    /**
     * @param matAdyacencia matriz de adyacencia
     */
    public ContenedorAristas(int[][] matAdyacencia) {

        Arista[] aux = new Arista[matAdyacencia.length * matAdyacencia.length];
        int cont = 0;
        for (int i = 0; i < matAdyacencia.length; i++) {
            for (int j = 0; j < matAdyacencia[i].length; j++) {
                if (matAdyacencia[i][j] != -1) { // -1: no hay arista.
                    aux[cont++] = new Arista(i, j, matAdyacencia[i][j]);
                }
            }
        }

        this.aristas = new Arista[cont];
        this.nAristas = cont;
        System.arraycopy(aux, 0, this.aristas, 0, cont);
    }

    /**
     *
     * @return Vector de aristas
     */
    public Arista[] getAristas() {
        return aristas;
    }

    @Override
    public int tamaño() {
        return nAristas;
    }

    @Override
    public boolean añadeArista(int origen, int destino, int peso) {
        if (nAristas < aristas.length) {
            aristas[nAristas++] = new Arista(origen, destino, peso);
            return true;
        }
        return false;
    }

    /**
     * @return Iterador del conjunto.
     */
    @Override
    public Iterator<Arista> iterator() {
        return new Iterator<Arista>() {

            int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < nAristas;
            }

            @Override
            public Arista next() {
                return aristas[pos++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return this.nAristas==0;
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        for (Arista a : this.aristas) {
            if (a.getOrigen()==origen && a.getDestino()==destino) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int origen, int destino) {
        int i;
        for (i = 0; i < nAristas; i++) {
            if (this.aristas[i].getOrigen()==origen &&
                    this.aristas[i].getDestino()==destino) {
                break;
            }
        }
        if (i==nAristas) {
            return false;
        }
        for (int j = i; j < nAristas - 1; j++) {
            aristas[j]=aristas[j+1];
        }
        nAristas--;
        return true;
    }

    @Override
    public void limpiar() {
        this.nAristas=0;
    }

}
