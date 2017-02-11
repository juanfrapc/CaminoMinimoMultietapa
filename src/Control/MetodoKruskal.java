package Control;

import Modelo.Arista;
import Modelo.ContenedorAristas;
import Modelo.Grafo;

/**
 * Clase que contiene el método de resolcuón de árbol de expansión mínimo.
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class MetodoKruskal implements MetodoResolucion {

    @Override
    public String nombre() {
        return "Algoritmo de Kruskal";
    }

    @Override
    public Grafo resuelve(Grafo grafo, MetodoOrdenacion metodoOrd) throws Exception{
        metodoOrd.ordena(grafo.getConjuntoAristas());
        int n = grafo.getnNodos();

        ContenedorAristas solucion = new ContenedorAristas(n);
        int contador = 0; // Tamaño de solución
        int[] conjunto = new int[n];
        initConjuntoNodos(conjunto, n);
        /* Inicializamos el conjunto a -1. No podemos inicializar a 0 porque el 
        índice 0 corresponde al primer nodo.
        */
        int indiceBusqueda = 0; // Ayuda para considerar aristas examinadas

        while (contador != n - 1) {
            Arista arista;
            try{
            arista = grafo.getConjuntoAristas().getAristas()[indiceBusqueda++];
            }catch(IndexOutOfBoundsException e){
                // Si no hay más aristas, grafo no conexo.
                throw new Exception("Grafo no conexo", e);
            }
            // Buscamos los representantes, es decir, nodos raiz de los árboles
            int origenConjunto = buscar(conjunto, arista.getOrigen());
            int destinoConjunto = buscar(conjunto, arista.getDestino());
            if (origenConjunto != destinoConjunto) {
                fusionar(conjunto, n, origenConjunto, destinoConjunto);
                solucion.añadeArista(new Arista(arista.getOrigen(),
                        arista.getDestino(), arista.getPeso()));
                contador++;
            }
        }
        return new Grafo(grafo.getnNodos(), solucion);
    }

    private void initConjuntoNodos(int[] conjunto, int n) {
        for (int i = 0; i < n; i++) {
            conjunto[i] = -1;
        }
    }

    private int buscar(int[] conjunto, int nodo) {
        while (conjunto[nodo] > -1) {
            nodo = conjunto[nodo];
        }
        return nodo;
    }

    private void fusionar(int[] conjunto, int n, int nodoA, int nodoB) {
        if (conjunto[nodoA] == conjunto[nodoB]) {
            conjunto[nodoA] -= 1;
            conjunto[nodoB] = nodoA;
        } else if (conjunto[nodoA] < conjunto[nodoB]) {
            conjunto[nodoB] = nodoA;
        } else {
            conjunto[nodoA] = nodoB;
        }
    }
}
