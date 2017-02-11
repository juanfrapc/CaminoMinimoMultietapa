package Modelo;

import java.util.Iterator;

/**
 * Clase de modelo de contenedor de aristas.
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class ContenedorAristas implements Iterable<Arista> {

    private Arista[] aristas;
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

    /**
     *
     * @return Número de aristas
     */
    public int getnAristas() {
        return nAristas;
    }

    /**
     *
     * @param arista
     * @return true si la adición es correcta.
     */
    public boolean añadeArista(Arista arista) {
        if (nAristas < aristas.length) {
            aristas[nAristas++] = arista;
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

}
