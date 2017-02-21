package Aplicacion;

import Modelo.Arista;
import Modelo.Contenedor;
import Modelo.Grafo;
import Modelo.GrafoMultietapa;
import Vista.GrafoDisplay;

/**
 * Clase Singleton que muestra un grafo por la consola.
 *
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class GrafoPrinter implements GrafoDisplay {

    private static GrafoPrinter printer = null;

    private GrafoPrinter() {
    }

    /**
     * @return Instancia de la Clase (Singleton)
     */
    public static GrafoPrinter getInstance() {
        if (printer == null) {
            printer = new GrafoPrinter();
        }
        return printer;
    }

    @Override
    public void print(Grafo grafo) {

        Contenedor aristas = grafo.getContenedor();

        System.out.println("NodoA\tNodoB\tPeso");

        for (Arista a : aristas) {

            System.out.println((a.getOrigen() + 1) + "\t"
                    + (a.getDestino() + 1) + "\t" + a.getPeso());
        }
        if (grafo instanceof GrafoMultietapa) {
            System.out.print("\nNodo:\t");
            GrafoMultietapa grafoM = (GrafoMultietapa) grafo;
            for (int i = 0; i < grafo.getnNodos(); i++) {
                System.out.print((i+1) + " ");
            }
            System.out.print("\nEtapas:\t");
            for (int i = 0; i < grafo.getnNodos(); i++) {
                System.out.print(grafoM.etapaNodo(i) + " ");
            }
            System.out.println("\n");
        }

    }

}
