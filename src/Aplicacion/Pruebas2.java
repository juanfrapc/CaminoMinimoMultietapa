package Aplicacion;

import Control.CaminoMinimoMultietapa;
import Modelo.Arista;
import Modelo.Grafo;
import Modelo.GrafoMultietapa;
import java.util.Scanner;

public class Pruebas2 {

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
            GrafoPrinter printer = GrafoPrinter.getInstance();
            Grafo grafo;
            GrafoMultietapa sol;
            int origen;
            int destino;
            switch (command) {
                case "1": // a través de fichero
                    System.out.print("\nIntroduzca la ruta absoluta del fichero de texto: ");
                    path = userInput.nextLine();
                    grafo = cargarGrafoMultietapa(path);
                    if (grafo == null) {
                        break;
                    }
                    printer.print(grafo);
                    System.out.print("Nodo origen: ");
                    origen = userInput.nextInt() - 1;
                    System.out.print("Nodo destino: ");
                    destino = userInput.nextInt() - 1;
                    System.out.println("\n---------------- Resolución ----------------");
                    try {
                        sol = resolverGrafo((GrafoMultietapa) grafo, origen, destino);
                        printer.print(sol);
                    } catch (Exception ex){
                        System.err.println("\n" + ex.getMessage() + "\n");
                    }
                    break;
                case "2": // Matriz por pantalla
                    System.out.print("\nNumero de nodos del grafo: ");
                    int nNodos = userInput.nextInt();
                    System.out.println("\n---------------- Creación de la Matriz de Adyacencia ----------------");
                    int[][] matAdyacencia = new int[nNodos][nNodos];
                    for (int i = 0; i < nNodos; i++) {
                        for (int j = 0; j < nNodos; j++) {
                            System.out.print("Peso arista de nodo " + (i + 1) + " a nodo " + (j + 1) + " : ");
                            matAdyacencia[i][j] = userInput.nextInt();
                        }
                    }
                    System.out.println("\n---------------- Especificación de las etapas ----------------");
                    int[] etapas = new int[nNodos];
                    for (int i = 0; i < nNodos; i++) {
                        System.out.print("Etapa nodo " + (i + 1) + ": ");
                        etapas[i] = userInput.nextInt();
                    }
                    System.out.print("Nodo origen: ");
                    origen = userInput.nextInt() - 1;
                    System.out.print("Nodo destino: ");
                    destino = userInput.nextInt() - 1;
                    System.out.println("\n---------------- Resolución ----------------");
                    grafo = new GrafoMultietapa(etapas, matAdyacencia);
                    try {
                        sol = resolverGrafo((GrafoMultietapa) grafo, origen, destino);
                        printer.print(sol);
                    } catch (Exception ex){
                        System.err.println("\n" + ex.getMessage() + "\n");
                    }
                    
                    break;
                case "3": // Pruebas por defecto
                    System.out.println("\n---------------- Pruebas ----------------");
                    System.out.print("-Prueba 1 - ");
                    path = "EjemploGrafo.txt";
                    grafo = cargarGrafoMultietapa(path);
                    path = "SolEjemploGrafo.txt";
                    GrafoMultietapa solEsperada = cargarGrafoMultietapa(path);
                    try {
                        sol = resolverGrafo((GrafoMultietapa) grafo, 0 , 7);
                        comprueba(sol, solEsperada);
                    } catch (Exception ex) {
                        System.out.println("Fallo: excepción no esperada");
                        System.err.println(ex.getMessage() + "\n");
                    }
                    
                    System.out.print("-Prueba 2 - ");
                    path = "EjemploGrafo2.txt";
                    grafo = cargarGrafoMultietapa(path);
                    path = "SolEjemploGrafo2.txt";
                    solEsperada = cargarGrafoMultietapa(path);
                    try {
                        sol = resolverGrafo((GrafoMultietapa) grafo, 0, 2);
                        comprueba(sol, solEsperada);
                    } catch (Exception ex) {
                        System.out.println("Fallo: excepción no esperada");
                        System.err.println(ex.getMessage() + "\n");
                    }
                    
                    System.out.print("-Prueba 3 - ");
                    path = "EjemploGrafo2.txt";
                    grafo = cargarGrafoMultietapa(path);
                    try {
                        resolverGrafo((GrafoMultietapa) grafo, 0, 4);
                        System.out.println("Fallo: no se produce excepción por no haber camino disponible hacia el Destino especificado.");
                    } catch (Exception ex) {
                        System.out.println("Éxito");
                    }
                    
                    System.out.print("-Prueba 4 - ");
                    path = "EjemploGrafo2.txt";
                    grafo = cargarGrafoMultietapa(path);
                    try {
                        resolverGrafo((GrafoMultietapa) grafo, 0, 3);
                        System.out.println("Fallo: no se produce excepción por pertenecer el Origen y el Destino a la misma etapa.");
                    } catch (Exception ex) {
                        System.out.println("Éxito");
                    }
                    break;
                case "q":
                    return;
                case "Q":
                    return;
                default:
                    System.err.println("\nError: Comando erróneo\n");
            }
        }
    }
    
    private static GrafoMultietapa cargarGrafoMultietapa (String path) {
        FileGrafoReader reader = new FileGrafoReader(path, 1);
        GrafoMultietapa grafo = null;
        try {
            grafo = (GrafoMultietapa) reader.read();
        } catch (Exception ex) {
            System.err.println("\n" + ex.getMessage() + "\n");
        }
        return grafo;
    }
    
    private static GrafoMultietapa resolverGrafo(GrafoMultietapa grafo, int origen, int destino) throws Exception{
        GrafoMultietapa sol = (GrafoMultietapa) grafo.clone();
        sol.getContenedor().limpiar();
        CaminoMinimoMultietapa resol = new CaminoMinimoMultietapa();
        resol.resuelve(grafo, origen, destino, sol);
        return sol;
    }

    private static void comprueba(GrafoMultietapa sol, GrafoMultietapa solEsperada) {
        if (sol.getnNodos() != solEsperada.getnNodos()) {
            System.out.println("Fallo: el nº de nodos no coincide con el esperado");
            return;
        } else if (sol.getnAristas() != solEsperada.getnAristas()){
            System.out.println("Fallo: el nº de aristas no coincide con el esperado");
            return;
        }
        for (int i = 0; i < sol.getnNodos(); i++) {
            if (sol.etapaNodo(i) != solEsperada.etapaNodo(i)) {
                System.out.println("Fallo: la etapa del nodo " + (i + 1) + " no coincide con la esperada");
            }
        }
        for (Arista a : sol.getContenedor()) {
            if (!solEsperada.getContenedor().existeArista(a.getOrigen(), a.getDestino())) {
                System.out.println("Fallo: existe una arista no esperada desde el nodo " 
                        + (a.getOrigen() + 1) + " hasta el nodo " + (a.getDestino() + 1));
                return;
            } else if (a.getPeso() != solEsperada.getContenedor().getPeso(a.getOrigen(), a.getDestino())) {
                System.out.println( "Fallo: el peso de la arista desde el nodo " 
                        + (a.getOrigen() + 1) + " hasta el nodo " 
                        + (a.getDestino() + 1) + " es " + a.getPeso() + " y se esperaba" 
                        + solEsperada.getContenedor().getPeso(a.getOrigen(), a.getDestino()) );
                return;
            }
        }
        System.out.println("Éxito");
    }
}
