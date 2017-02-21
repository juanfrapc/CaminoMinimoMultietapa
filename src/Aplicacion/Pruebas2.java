package Aplicacion;

import Control.CaminoMinimoMultietapa;
import Modelo.GrafoMultietapa;

public class Pruebas2 {

    public static void main(String[] args) {
        FileGrafoReader reader = new FileGrafoReader("EjemploGrafo.txt", 1);
        GrafoPrinter printer = GrafoPrinter.getInstance();
        GrafoMultietapa grafo = null;
        GrafoMultietapa sol = null;
        try {
            grafo = (GrafoMultietapa) reader.read();
            sol = (GrafoMultietapa) reader.read();
            sol.getContenedor().limpiar();
        } catch (Exception ex) {
            System.out.println("\n" + ex.getMessage() + "\n");
        }
        printer.print(grafo);

        CaminoMinimoMultietapa resol = new CaminoMinimoMultietapa();
        System.out.println("Coste óptimo: " + resol.resuelve(grafo, 0, 7, sol));
        printer.print(sol);
    }
}
