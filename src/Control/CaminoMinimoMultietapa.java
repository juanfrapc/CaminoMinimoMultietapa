package Control;

import Modelo.ContenedorMatriz;
import Modelo.GrafoMultietapa;

public class CaminoMinimoMultietapa {

    private GrafoMultietapa grafo;
    private int costeParcial = Integer.MAX_VALUE;
    
    private Pila pila;
    private GrafoMultietapa solucion;
    private int destino;


    private class Pila{

        private final int[] pila;
        private int nNodos=0;

        public Pila(int tamaño) {
            this.pila=new int[tamaño*(tamaño-1)];
        }

        public boolean push(int elemento){
            if(nNodos== pila.length) return false;
            pila[nNodos++] = elemento;
            return true;            
        }
        
        public int pop(){
            return (!vacia())?pila[--nNodos]:-1;
        }

        private boolean vacia() {
            return nNodos==0;
        }

        public int getnNodos() {
            return nNodos;
        }
        
    }
    
    public boolean resuelve(GrafoMultietapa grafo, int origen, int destino, GrafoMultietapa solucion){
        
        this.grafo=grafo;
        
        this.pila = new Pila(grafo.getnNodos());
        this.solucion=solucion;
        this.destino=destino;
        pila.push(origen);
        
        
        return true;
    }
    
    private boolean resuelve() {
        if (verifica(solucion, destino)) return true;
        
        while (pila.getnNodos() != 0){
            int nodo = pila.pop();
            int[] hijos = ((ContenedorMatriz)this.grafo.getContenedor()).getHijos(nodo);
            for (int hijo : hijos) {
                if (grafo.etapaNodo(hijo)>grafo.etapaNodo(nodo)) {
                    pila.push(hijo);
                }
            }
        }
        return true;
    }
    
    private boolean verifica(GrafoMultietapa solucion, int destino) {
        for (int i = 0; i < solucion.getnNodos(); i++) {
            if (grafo.getContenedor().existeArista(i, destino)){
                return true;
            }
        }
        return false;
    }
    
}
