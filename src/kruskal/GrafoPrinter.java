package kruskal;

import Modelo.Arista;
import Modelo.ContenedorAristas;
import Modelo.Grafo;

public class GrafoPrinter {

    public static void print(Grafo grafito) {

        ContenedorAristas aristas = grafito.getConjuntoAristas();

        System.out.println("A \t B \t Peso");

        for (Arista a : aristas) {
            System.out.println((a.getOrigen() + 1) + "\t"
                    + (a.getDestino() + 1) + "\t" + a.getPeso());
        }

    }

}
