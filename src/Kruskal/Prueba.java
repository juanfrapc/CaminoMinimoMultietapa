package Kruskal;

import Control.MetodoKruskal;
import Modelo.Grafo;
import Vista.GrafoReader;
import java.util.Scanner;

/**
 * Clase principal con pruebas diversas.
 *
 * @author Juan Francisco Pérez Caballero && Gabriel García Buey
 */
public class Prueba {

    /**
     * Main class
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String command = "";
        
        while (true) { // bucle infinito.
            //Menú
            System.out.println("1. Introducir grafo mediante fichero de texto");
            System.out.println("2. Introducir grafo por consola [Matriz de adyacencia]");
            System.out.println("3. Ejecutar pruebas");
            System.out.println("[Pulse la tecla 'Q' para salir]");
            System.out.print("Comando a ejecutar: ");
            // Menú
            
            command = userInput.nextLine();
            String path;
            Grafo grafo;
            switch (command) {
                case "1": // a través de fichero
                    System.out.print("Introduzca la ruta absoluta del fichero de texto: ");
                    path = userInput.nextLine();
                    grafo = cargarGrafo(path);
                    if (grafo == null) {
                        break;
                    }
                    resolverGrafo(grafo);
                    break;
                case "2": // Matriz por pantalla
                    System.out.println("---------------- Creación de la Matriz de Adyacencia ----------------\n");
                    System.out.print("Numero de nodos del grafo: ");
                    int nNodos = userInput.nextInt();
                    int[][] matAdyacencia = new int[nNodos][nNodos];
                    for (int i = 0; i < nNodos; i++) {
                        for (int j = 0; j < nNodos; j++) {
                            System.out.print("Peso arista de nodo " + (i + 1) + " a nodo " + (j + 1) + " : ");
                            matAdyacencia[i][j] = userInput.nextInt();
                        }
                    }
                    System.out.println("---------------- Resolución ----------------\n");
                    grafo = new Grafo(matAdyacencia);
                    resolverGrafo(grafo);
                    break;
                case "3": // Pruebas por defecto
                    System.out.println("\n---------------- Prueba 1 ----------------\n");
                    path = "EjemploGrafo.txt";
                    grafo = cargarGrafo(path);
                    resolverGrafo(grafo);
                    
                    System.out.println("---------------- Prueba 2 ----------------\n");
                    path = "EjemploGrafo2.txt";
                    grafo = cargarGrafo(path);
                    resolverGrafo(grafo);
                    break;
                case "q":
                    return;
                case "Q":
                    return;
                default:
                    System.out.println("\nError: Comando erróneo\n");
            }
        }
    }

    private static Grafo cargarGrafo(String path) {
        GrafoReader reader = new FileGrafoReader(path);
        Grafo grafo = null;
        try {
            grafo = reader.read();
        } catch (Exception ex) {
            System.err.println("");
            System.err.println(ex.getMessage());
            System.err.println("");
        }
        return grafo;
    }

    private static void resolverGrafo(Grafo grafo) {
        System.out.println("- Matriz de Adyacencia del grafo -");
        GrafoPrinter printer = GrafoPrinter.getInstance();
        printer.print(grafo);

        MetodoKruskal kruskal = new MetodoKruskal();
        Grafo solucion;
        System.out.println("\n- Arbol de expansión mínimo -");
        try {
            solucion = kruskal.resuelve(grafo, new RadixSort());
        } catch (Exception ex) {
            System.err.println("");
            System.err.println(ex.getMessage());
            System.err.println("");
            return;
        }
        printer.print(solucion);
        System.out.println("");
    }
}
