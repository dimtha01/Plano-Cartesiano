package principal;

import java.util.ArrayList;

public class Principal {
    public static ArrayList<Clase2> lista = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Clase3.leerPuntos(lista);
        Clase3.mostrar(lista);
        
    }
}
