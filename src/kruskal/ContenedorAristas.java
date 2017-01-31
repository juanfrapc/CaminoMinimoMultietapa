package kruskal;
/**
 *
 * @author Entrar
 */
public class ContenedorAristas {
    private  Arista[] aristas;
    private int  nArcos;

    public ContenedorAristas(int nArcos) {
        this.nArcos = nArcos;
        this.aristas = new Arista[nArcos];
    }
    
    public ContenedorAristas(Arista[] aristas) {
        nArcos = aristas.length;
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
        this.nArcos = cont;
        System.arraycopy(aux, 0, this.aristas, 0, cont - 1);
    }

    public Arista[] getAristas() {
        return aristas;
    }

    public int getnArcos() {
        return nArcos;
    }
    
    public boolean añadeArista() {
    
    }
    
}
