package Aplicacion;

import Modelo.Arista;
import Modelo.ContenedorAristas;
import Modelo.Grafo;

/**
 * Clase Singleton que muestra un grafo por la consola.
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class GrafoPrinter {
   
    private static GrafoPrinter printer = null;
    
    private GrafoPrinter(){
    }
    
    /**
     * @return Instancia de la Clase (Singleton)
     */
    public static GrafoPrinter getInstance(){
        if (printer == null) {
            printer = new GrafoPrinter();
        }
        return printer;
    }
    
    /**
     * Imprime un grafo por consola
     * @param grafo
     */
    public void print(Grafo grafo) {

        ContenedorAristas aristas = grafo.getConjuntoAristas();

        System.out.println("NodoA\tNodoB\tPeso");
        
        for (Arista a : aristas) {
            System.out.println((a.getOrigen() + 1) + "\t" + 
                (a.getDestino() + 1) + "\t" + a.getPeso());
        }
        
    }

}
