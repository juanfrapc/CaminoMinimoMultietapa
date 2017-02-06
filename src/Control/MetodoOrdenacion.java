package Control;

import Modelo.Arista;

public interface MetodoOrdenacion {

    public String nombre();
    public void ordena(Arista[] aristas, int nAristas);
    
}
