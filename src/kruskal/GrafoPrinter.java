package kruskal;

import Modelo.Arista;
import Modelo.ContenedorAristas;
import Modelo.Grafo;

public class GrafoPrinter {

    public static void print(Grafo grafoito) {

        ContenedorAristas aristas = grafoito.getConjuntoAristas();

        System.out.println("A \t B \t Peso");

        for (Object a : aristas) {
            Arista arista = (Arista) a;
            System.out.println((arista.getOrigen() + 1) + "\t"
                    + (arista.getDestino() + 1) + "\t" + arista.getPeso());
        }

//        for (Arista arista : aristas) {
//            if (arista==null) {
//                break;
//            }
//            System.out.println((arista.getOrigen() + 1) + "\t" + 
//                    (arista.getDestino() + 1) + "\t" + arista.getPeso());
//        }
    }

}
