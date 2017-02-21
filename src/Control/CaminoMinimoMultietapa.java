package Control;

import Modelo.ContenedorMatriz;
import Modelo.GrafoMultietapa;

public class CaminoMinimoMultietapa {

    private GrafoMultietapa grafo;
    private int cota = Integer.MAX_VALUE;

    private GrafoMultietapa solucion;
    private int destino;

    public boolean resuelve(GrafoMultietapa grafo, int origen, int destino, GrafoMultietapa solucion) {

        this.grafo = grafo;

        this.solucion = solucion;
        this.destino = destino;

        return resuelve(origen, 0);
    }

    private boolean resuelve(int nodo, int costeAcumulado) {

        int[] hijos = ((ContenedorMatriz) this.grafo.getContenedor()).getHijos(nodo);
        for (int hijo : hijos) {
            int coste = grafo.getContenedor().getPeso(nodo, hijo);
            if (coste + costeAcumulado < cota) {
                if (resuelve(hijo, coste + costeAcumulado)) {
                    solucion.getContenedor().añadeArista(nodo, hijo, coste);
                }
            }
        }
        return verifica(nodo, costeAcumulado);
    }

    private boolean verifica(int nodo, int costeAcumulado) {
        if (nodo == destino) {
            if (cota > costeAcumulado) {
                cota = costeAcumulado;
                solucion.getContenedor().limpiar();
                return true;
            }
        }
        return false;
    }

}
