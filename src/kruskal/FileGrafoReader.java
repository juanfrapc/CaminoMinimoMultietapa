package kruskal;

import Modelo.Grafo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import persistencia.GrafoReader;

public class FileGrafoReader implements GrafoReader {

    private String path = "";

    public FileGrafoReader(String path) {
        this.path = path;
    }

    @Override
    public Grafo read(){
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            int nNodos = Integer.parseInt(bufferedReader.readLine().split("=")[2]);
            int[][] mat = new int[nNodos][nNodos];
            String arista;
            int i = 0,j = 0;
            while ((arista=bufferedReader.readLine() )!= null){
                String[] parametros = arista.split("\\s");
                for (String parametro : parametros) {
                    mat[i][j++]=Integer.parseInt(parametro);
                }
                i++;                
            }
            
            return new Grafo(mat);
            
        } catch (IOException ex) {
            System.out.println("FICHERO NO VÁLIDO");
            return null;
        }
    }

}
