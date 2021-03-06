package Aplicacion;

import Modelo.Grafo;
import Modelo.GrafoMultietapa;
import Modelo.GrafoOrdenable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Vista.GrafoReader;
import java.io.File;

public class FileGrafoReader implements GrafoReader {

    private String path = "";
    private final int tipo;

    /**
     * Constructor con la ruta del fichero
     *
     * @param path Ruta del fichero
     * @param tipo Tpo de grafo 0:ordenado, 1:Multietapa
     */
    public FileGrafoReader(String path, int tipo) {
        this.path = path;
        this.tipo = tipo;
    }

    @Override
    public Grafo read() throws Exception {

        try {
            BufferedReader reader
                    = new BufferedReader(new FileReader(new File(path)));

            int nNodos = Integer.parseInt(reader.readLine().split("=")[1].trim());
            int[][] matriz = new int[nNodos][nNodos];// matriz destino
            String fila;
            int i = 0, j = 0;
            while ((fila = reader.readLine()) != null && i < nNodos) {
                String[] parametros = fila.split("\\s+");
                for (String parametro : parametros) {
                    matriz[i][j++] = Integer.parseInt(parametro);
                }
                j = 0;
                i++;
            }
            int[] vectorEtapas = new int[nNodos];
            if (tipo == 1) {
                String[] parametros = fila.split("\\s+");
                for (int k = 0; k < parametros.length - 1; k++) {
                    vectorEtapas[k] = Integer.parseInt(parametros[k + 1]);
                }
            }
            return tipo == 0 ? new GrafoOrdenable(matriz) : new GrafoMultietapa(vectorEtapas, matriz);
        } catch (IOException ex) {
            // Ruta no válida
            throw new Exception("Fichero no válido", ex);
        }
    }

}
