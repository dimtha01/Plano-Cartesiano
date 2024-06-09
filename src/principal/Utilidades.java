package principal;
/*Clase 3 - Utilidades:
Métodos estáticos:
    Método que lea el archivo “Puntos.txt” y lo cargue en un ArrayList del tipo de la Clase 2 que se pasará como parámetro.
    Método que reciba como parámetro un ArrayList del tipo de la Clase 2 y muestre su contenido. */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Utilidades {
    public static void leerPuntos(ArrayList<SegmentoRecta> lista) throws IOException {
        // Abrir el archivo "Puntos.txt" para lectura
        Scanner leerCoor = new Scanner(new File("Puntos.txt"));
        double x, y, x1, y1;
        Punto punto1, punto2;
        SegmentoRecta recta;
        String registro;

        // Leer el archivo línea por línea
        while (leerCoor.hasNextLine()) {
            registro = leerCoor.nextLine();
            Scanner campos = new Scanner(registro);
            campos.useDelimiter(",");
            campos.useLocale(Locale.US);
            x = campos.nextDouble();
            y = campos.nextDouble();
            x1 = campos.nextDouble();
            y1 = campos.nextDouble();

            // Crear objetos Clase1 y Clase2 con las coordenadas leídas y agregarlos a la
            // lista
            punto1 = new Punto(x, y);
            punto2 = new Punto(x1, y1);
            recta = new SegmentoRecta(punto1, punto2);
            lista.add(recta);
        }

        // Cerrar el lector de archivo
        leerCoor.close();
    }

    public static void mostrar(ArrayList<SegmentoRecta> lista) {
        // Imprime el encabezado para mostrar las rectas en el plano cartesiano
        System.out.println("/t/tRectas En El Plano Cateciano");
        System.out.println("   A    B     C     M     Orientacion       Ecuacion");
        // Itera a través de la lista y muestra cada elemento
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostrar(); // Llama al método mostrar de cada elemento de la lista
        }
        System.out.println("\n\n"); // Imprime líneas en blanco para separar la salida
    }

}
