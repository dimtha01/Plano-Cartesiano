package principal;
/*
 * Con el método main en el cual se definirá el ArrayList y se invocaran los métodos definidos en
la Clase 3.
 */

import java.util.ArrayList;

public class Principal {
    public static ArrayList<SegmentoRecta> lista = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // Llamamos al método estático 'leerPuntos' de la clase Clase3 para leer puntos
        // y agregarlos a la lista
        Utilidades.leerPuntos(lista);
        // Llamamos al método estático 'mostrar' de la clase Clase3 para mostrar los
        // elementos de la lista
        Utilidades.mostrar(lista);
    }

}
