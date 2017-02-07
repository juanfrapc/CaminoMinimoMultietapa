package kruskal;

import Modelo.Arista;
import Modelo.Grafo;

public class GrafoPrinter {
   
    public static void print(Grafo grafoito) {

        Arista[] aristas = grafoito.getConjuntoAristas().getAristas();

        System.out.println("A \t B \t Peso");
        for (Arista arista : aristas) {
            if (arista==null) {
                break;
            }
            System.out.println((arista.getOrigen() + 1) + "\t" + 
                    (arista.getDestino() + 1) + "\t" + arista.getPeso());
        }
    }

}
