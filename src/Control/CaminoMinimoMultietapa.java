package Control;

import Modelo.ContenedorMatriz;
import Modelo.GrafoMultietapa;

public class CaminoMinimoMultietapa {

    private GrafoMultietapa grafo;
    private int cota = Integer.MAX_VALUE;

    private GrafoMultietapa solucion;
    private int destino;

    public int resuelve(GrafoMultietapa grafo, int origen, int destino, GrafoMultietapa solucion) {

        this.grafo = grafo;

        this.solucion = solucion;
        this.destino = destino;

        resuelve(origen, 0);
        return cota;
    }

    private int resuelve(int nodo, int costeAcumulado) {

        if(verifica(nodo, costeAcumulado)){
            return destino;
        }
        
        int mejorHijo = -1;
        System.out.println("NODO: " + nodo);
        int[] hijos = ((ContenedorMatriz) this.grafo.getContenedor()).getHijos(nodo);
        for (int hijo : hijos) {
            System.out.println("hijo " + hijo);
            int peso = grafo.getContenedor().getPeso(nodo, hijo);
            System.out.println("CA: " + (peso + costeAcumulado)+"\n");
            
            if (peso + costeAcumulado < cota && grafo.etapaNodo(nodo) < grafo.etapaNodo(hijo)) {
                if (resuelve(hijo, peso + costeAcumulado) != -1) {
                    System.out.println(nodo + "\t" + hijo + "\t" + cota);
                    solucion.getContenedor().añadeArista(nodo, hijo, peso);
                    mejorHijo = hijo;
                }
            }
        }
        return mejorHijo;
    }

    private boolean verifica(int nodo, int costeAcumulado) {
        if (nodo == destino && cota > costeAcumulado) {
            cota = costeAcumulado;
            solucion.getContenedor().limpiar();
            System.out.println("limpia");
            return true;
        }
        return false;
    }

}
