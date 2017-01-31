package kruskal;

import java.util.Arrays;

/**
 *
 * @author Entrar
 */
public class ContenedorAristas {
    private  Arista[] aristas;
    private int  nAristas;

    public ContenedorAristas(int nArcos) {
        this.nAristas = nArcos;
        this.aristas = new Arista[nArcos];
    }
    
    public ContenedorAristas(Arista[] aristas) {
        nAristas = aristas.length;
        this.aristas = aristas;
    }

    public ContenedorAristas(int[][] matAdyacencia) {
        Arista[] aux = new Arista[matAdyacencia.length^2];
        int cont = 0;
        for (int i = 0; i < matAdyacencia.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matAdyacencia[i][j] != -1) {
                    aux[cont++] = new Arista(i, j, matAdyacencia[i][j]);
                }
            }
        }
        this.aristas = new Arista[cont];
        this.nAristas = cont;
        System.arraycopy(aux, 0, this.aristas, 0, cont - 1);
    }

    public Arista[] getAristas() {
        return aristas;
    }

    public int getnAristas() {
        return nAristas;
    }
    
    public boolean añadeArista(Arista arista) {
        if (nAristas < aristas.length) {
            aristas[nAristas++] = arista;
            return true;
        }
        return false;
    }
    
    public void ordena() {
        int m = maximo();
 
        for (int exp = 1; m/exp > 0; exp *= 10){
            ordenaDígito(exp);
        }
    }

    private int maximo() {
        int max = aristas[0].getPeso();
        for (int i = 1; i < nAristas; i++)
            if (aristas[i].getPeso() > max)
                max = aristas[i].getPeso();
        return max;
    }

    private void ordenaDígito(int exp) {
        Arista[] aux= new Arista[nAristas]; 
        int i;
        int[] count = new int[10];
        Arrays.fill(count,0);
 
        for (i = 0; i < nAristas; i++) count[(aristas[i].getPeso()/exp)%10]++;
 
        for (i = 1; i < 10; i++) count[i] += count[i - 1];
 
        for (i = nAristas - 1; i >= 0; i--)
        {
            aux[count[ (aristas[i].getPeso()/exp)%10 ] - 1] = aristas[i];
            count[(aristas[i].getPeso()/exp)%10 ]--;
        }
 
        for (i = 0; i < nAristas; i++) aristas[i] = aux[i];
    }
    
    
}
