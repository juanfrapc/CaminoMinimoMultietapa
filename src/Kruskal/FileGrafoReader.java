package Kruskal;

import Modelo.Grafo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Vista.GrafoReader;
import java.io.File;

public class FileGrafoReader implements GrafoReader {

    private String path = "";

    /**
     * Constructor con la ruta del fichero
     * @param path Ruta del fichero
     */
    public FileGrafoReader(String path) {
        this.path = path;
    }

    @Override
    public Grafo read() throws Exception{

        try {
            BufferedReader bufferedReader = 
                    new BufferedReader(new FileReader( new File(path)));
            
            int nNodos = Integer.parseInt(bufferedReader.readLine().split("=")[1].trim());
            int[][] matriz = new int[nNodos][nNodos];// matriz destino
            String arista;
            int i = 0, j = 0;
            while ((arista = bufferedReader.readLine()) != null) {
                String[] parametros = arista.split("\\s+");
                for (String parametro : parametros) {
                    matriz[i][j++] = Integer.parseInt(parametro);
                }
                j = 0;
                i++;
            }
            return new Grafo(matriz);

        } catch (IOException ex) {
            // Ruta no válida
            throw new Exception("Fichero no válido", ex);
        }
    }

}
