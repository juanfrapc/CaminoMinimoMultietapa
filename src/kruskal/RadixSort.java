package kruskal;

import Control.MetodoOrdenacion;
import Modelo.Arista;


public class RadixSort implements MetodoOrdenacion{

    private Arista[] aristas;
    private int nAristas;
    
    @Override
    public String nombre() {
        return "Radix Sort";
    }

    @Override
    public void ordena(Arista[] aristas, int nAristas) {
        this.aristas=aristas;
        this.nAristas=nAristas;
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
        for (i = 0; i < count.length; i++) count[i] = 0;
            
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
