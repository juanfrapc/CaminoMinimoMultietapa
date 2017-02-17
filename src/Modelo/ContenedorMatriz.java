package Modelo;

import java.util.Iterator;

/**
 *
 * @author Granfran
 */
public class ContenedorMatriz {

    private final int[][] matriz;
    private int nAristas;

    ContenedorMatriz(int[][] matAdyacencia) {
        this.matriz = matAdyacencia;
        for (int[] fila : matAdyacencia) {
            for (int elemento : fila) {
                if (elemento != -1) {
                    this.nAristas++;
                }
            }
        }
    }

    public int getnNodos() {
        return this.matriz.length;
    }

    public int getnAristas() {
        return nAristas;
    }

    public boolean isEmpty() {
        return nAristas == 0;
    }

    public boolean existeArista(int origen, int destino) {
        return matriz[origen][destino] != -1;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int fila = 0;
            private int columna = 0;
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < nAristas;
            }

            @Override
            public Integer next() {
                pos++;
                while(matriz[fila][columna]==-1){
                    columna++;
                    if (columna == matriz.length) {
                        columna = 0;
                        fila++;
                    }
                }
                int sol = matriz[fila][columna];
                columna++;
                if (columna == matriz.length) {
                    columna = 0;
                    fila++;
                }
                return sol;
            }
        };
    }

    public boolean añadeArista(int origen, int destino, int peso) {
        if (this.matriz[origen][destino] == -1) {
            this.matriz[origen][destino] = peso;
            nAristas++;
            return true;
        }
        return false;
    }

    public boolean remove(int origen, int destino) {
        if (this.existeArista(origen, destino)) {
            this.matriz[origen][destino] = -1;
            nAristas--;
            return true;
        }
        return false;
    }

    public void limpiar() {
        nAristas=0;
    }
}
