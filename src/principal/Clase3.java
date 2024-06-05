package principal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Clase3 {
    public static void leerPuntos(ArrayList<Clase2> lista) throws IOException {
        Scanner leerCoor = new Scanner(new File("Puntos.txt"));
        double x, y, x1, y1;
        Clase1 punto1, punto2;
        Clase2 recta;
        String registro;
        while (leerCoor.hasNextLine()) {
            registro = leerCoor.nextLine();
            Scanner campos = new Scanner(registro);
            campos.useDelimiter(",");
            campos.useLocale(Locale.US);
            x = campos.nextDouble();
            y = campos.nextDouble();
            x1 = campos.nextDouble();
            y1 = campos.nextDouble();
            punto1 = new Clase1(x, y);
            punto2 = new Clase1(x1, y1);
            recta = new Clase2(punto1, punto2);
            lista.add(recta);

        }
        leerCoor.close();
    }
    public static void mostrar(ArrayList<Clase2> lista){
        System.out.println("/t/tRectas En El Plano Cateciano");
        System.out.println("   A    B     C     M     Orientacion       Ecuacion");
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostrar();
            
        }
        System.out.println("\n\n");
    }

}
