package principal;
/*Clase 1 - Punto:
Atributos: Las coordenadas X e Y de un punto.
Métodos:
1 Constructor que recibirá como parámetros los atributos de la clase.
2 Métodos "get" para los atributos. */

public class Punto {
    /* Atributos */
    private double coor_x;  // Coordenada en el eje x
    private double coor_y;  // Coordenada en el eje y
    
    /* Constructor */
    public Punto(double coor_x, double coor_y){
        this.coor_x = coor_x;  // Asigna el valor de coor_x a la instancia actual
        this.coor_y = coor_y;  // Asigna el valor de coor_y a la instancia actual
    }
    
    /* Métodos Getter */
    public double getCoor_x() {
        return coor_x;  // Devuelve el valor de coor_x
    }

    public double getCoor_y() {
        return coor_y;  // Devuelve el valor de coor_y
    }
}