package Modelo;

import java.util.Iterator;

/**
 *
 * @author Granfran
 */
public class ContenedorMatriz implements Contenedor{

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

    @Override
    public int tamaño() {
        return nAristas;
    }

    @Override
    public boolean isEmpty() {
        return nAristas == 0;
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        return matriz[origen][destino] != -1;
    }

    @Override
    public Iterator<Arista> iterator() {
        return new Iterator<Arista>() {

            private int fila = 0;
            private int columna = 0;
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < nAristas;
            }

            @Override
            public Arista next() {
                pos++;
                while(matriz[fila][columna]==-1){
                    columna++;
                    if (columna == matriz.length) {
                        columna = 0;
                        fila++;
                    }
                }
                int sfila = fila;
                int scol = columna;
                int sol = matriz[fila][columna];
                columna++;
                if (columna == matriz.length) {
                    columna = 0;
                    fila++;
                }
                return new Arista(sfila, scol, sol);
            }
        };
    }

    @Override
    public boolean añadeArista(int origen, int destino, int peso) {
        if (this.matriz[origen][destino] == -1) {
            this.matriz[origen][destino] = peso;
            nAristas++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int origen, int destino) {
        if (this.existeArista(origen, destino)) {
            this.matriz[origen][destino] = -1;
            nAristas--;
            return true;
        }
        return false;
    }

    @Override
    public void limpiar() {
        nAristas=0;
    }

    public int[] getHijos(int nodo) {
        int contador = 0;
        for (int hijo: matriz[nodo]) {
            if (hijo != -1)contador++;
        }
        int[] hijos = new int[contador];
        contador = 0;
        for (int hijo: matriz[nodo]) {
            if (hijo != -1) hijos[contador++] = hijo;
        }
        return hijos;
    }
}
