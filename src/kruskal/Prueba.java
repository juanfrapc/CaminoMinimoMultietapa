package kruskal;

import Control.MetodoKruskal;
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

        MetodoKruskal kruskal = new MetodoKruskal();
        Grafo solucion = kruskal.resuelve(grafito, new RadixSort());
        System.out.println(solucion.getConjuntoAristas().getnAristas());
        GrafoPrinter.print(solucion);
    }

}
