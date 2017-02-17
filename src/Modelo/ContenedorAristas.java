package Modelo;

import java.util.Collection;
import java.util.Iterator;

/**
 * Clase de modelo de contenedor de aristas.
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class ContenedorAristas implements Iterable<Arista>, Collection<Arista>{

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
    public int size() {
        return nAristas;
    }

    @Override
    public boolean add(Arista arista) {
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

    @Override
    public boolean isEmpty() {
        return this.nAristas==0;
    }

    @Override
    public boolean contains(Object o) {
        for (Arista a : this.aristas) {
            if (a.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return this.aristas;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean remove(Object o) {
        Arista arista = (Arista) o;
        int i;
        for (i = 0; i < nAristas; i++) {
            if (this.aristas[i]==arista) {
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
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains((Arista) o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Arista> c) {
        for (Arista arista : c) {
            if (! this.add(arista)) return false;  
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if (! this.add((Arista) o)) return false;  
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        this.nAristas=0;
    }

}
