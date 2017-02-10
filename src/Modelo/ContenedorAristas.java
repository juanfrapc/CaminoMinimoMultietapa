package Modelo;

import java.util.Iterator;

public class ContenedorAristas implements Iterable<Arista> {

    private final Arista[] aristas;
    private int nAristas;

    public ContenedorAristas(int nNodos) {
        this.nAristas = 0;
        this.aristas = new Arista[nNodos * nNodos];
    }

    public ContenedorAristas(Arista[] aristas) {
        nAristas = aristas.length;
        this.aristas = aristas;
    }

    public ContenedorAristas(int[][] matAdyacencia) {

        Arista[] aux = new Arista[matAdyacencia.length * matAdyacencia.length];
        int cont = 0;
        for (int i = 0; i < matAdyacencia.length; i++) {
            for (int j = 0; j < matAdyacencia[i].length; j++) {
                if (matAdyacencia[i][j] != -1) {
                    aux[cont++] = new Arista(i, j, matAdyacencia[i][j]);
                }
            }
        }

        this.aristas = new Arista[cont];
        this.nAristas = cont;
        System.arraycopy(aux, 0, this.aristas, 0, cont);
    }

    public Arista[] getAristas() {
        return aristas;
    }

    public int getnAristas() {
        return nAristas;
    }

    public boolean añadeArista(Arista arista) {
        if (nAristas < aristas.length) {
            aristas[nAristas++] = arista;
            return true;
        }
        return false;
    }

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
