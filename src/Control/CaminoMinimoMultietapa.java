package Control;

import Modelo.ContenedorMatriz;
import Modelo.GrafoMultietapa;

public class CaminoMinimoMultietapa {

    private GrafoMultietapa grafo;
    
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
        
        Pila pila = new Pila(grafo.getnNodos());
        pila.push(origen);
        while (pila.getnNodos() != 0){
            int nodo = pila .pop();
            int[] hijos = ((ContenedorMatriz)this.grafo.getContenedor()).getHijos(nodo);
        }
        
    }
    
}
