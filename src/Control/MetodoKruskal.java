package Control;

import Modelo.Arista;
import Modelo.ContenedorAristas;
import Modelo.Grafo;

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

        int indiceBusqueda = 0; // ayuda para considerar aristas examinadas

        while (contador != n - 1) {
            Arista arista;
            try{
            arista = grafo.getConjuntoAristas().getAristas()[indiceBusqueda++];
            }catch(IndexOutOfBoundsException e){
                throw new Exception("Grafo no conexo", e);
            }
            int origenConjunto = buscar(conjunto, arista.getOrigen());
            int destinoConjunto = buscar(conjunto, arista.getDestino());
            if (origenConjunto != destinoConjunto) {
                fusionar(conjunto, n, origenConjunto, destinoConjunto);
                solucion.añadeArista(new Arista(arista.getOrigen(), arista.getDestino(), arista.getPeso()));
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
