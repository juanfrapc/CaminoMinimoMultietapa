package Kruskal;

import Control.MetodoKruskal;
import Modelo.Grafo;
import Vista.GrafoReader;

/**
 *
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class Prueba {

    public static void main(String[] args) {
        
        System.out.println("Prueba 1");
        String path = "EjemploGrafo.txt";
        prueba(path);
        
        System.out.println("Prueba 2");
        path = "EjemploGrafo2.txt";
        prueba(path);
        
    }

    private static void prueba(String path) {
        GrafoReader reader = new FileGrafoReader(path);
        Grafo grafito = reader.read();
        GrafoPrinter.print(grafito);

        MetodoKruskal kruskal = new MetodoKruskal();
        Grafo solucion;
        System.out.println("Arbol de expansión mínimo");
        try {
            solucion = kruskal.resuelve(grafito, new RadixSort());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
        GrafoPrinter.print(solucion);
        System.out.println("");
    }

}
