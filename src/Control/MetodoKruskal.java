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
    public Grafo resuelve(Grafo grafo, MetodoOrdenacion metodoOrd) {
        metodoOrd.ordena(grafo.getConjuntoAristas().getAristas(),
                grafo.getConjuntoAristas().getnAristas());
        int n = grafo.getnNodos();

        ContenedorAristas solucion = new ContenedorAristas(0);
        int contador = 0; // Tamaño de solución
        int[] conjunto = new int[n];
        initConjuntoNodos(conjunto, n);
        
        int indiceBusqueda=0; // ayuda para considerar aristas examinadas
        
        while(contador != n - 1){
            Arista arista = grafo.getConjuntoAristas().getAristas()[indiceBusqueda++];
            int uConjunto = buscar(arista.getOrigen(),arista.getDestino());
            
        }
               
        
        
        return null;
    }

    private void initConjuntoNodos(int[] conjunto, int n) {
        for (int i = 0; i < n; i++) {
            conjunto[i] = 0;
        }
    }

    private int buscar(int origen, int destino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
