package kruskal;

import Modelo.Grafo;
import Vista.GrafoReader;

/**
 *
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class Prueba {

    public static void main(String[] args) {
        String path = "EjemploGrafo.txt";
        GrafoReader reader = new FileGrafoReader(path);
        Grafo grafito = reader.read();
        GrafoPrinter.print(grafito);
        
        RadixSort radixSort = new RadixSort();
        radixSort.ordena(grafito.getConjuntoAristas());
        GrafoPrinter.print(grafito);
        
    }
    
}
