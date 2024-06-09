package principal;
/*Clase 2 - SegmentoRecta:
Atributos:
    Dos objetos de la Clase 1 que guardarán los puntos extremos de la recta.
    Los coeficientes de la recta a, b y c (double).
    La pendiente m de la recta (double).
    La orientación y la ecuación (String).
Métodos:
    1 Constructor que recibirá como parámetros dos objetos de la Clase 1.
    2 Método que permita calcular la pendiente, los coeficientes de la recta y su orientación, actualizando cada uno de estos atributos.
    3 Método que arme la ecuación de la recta usando los coeficientes de la misma, actualizando el atributo que guarda la ecuación. Para los casos de rectas horizontales y verticales, se usarán los siguientes formatos respectivamente: Y + c = 0 y X + c = 0.
    4 Método que muestre los coeficientes de la recta, su pendiente, orientación y su ecuación, todo formateado según los requisitos. */

public class SegmentoRecta {
    /* Atributos */
    private Punto punto1; // Primer punto
    private Punto punto2; // Segundo punto
    private double a, b, c; // Coeficientes
    private double m; // Pendiente
    private String orientacion; // Orientación de la recta
    private String ecuacion; // Ecuación de la recta

    /* 1 Constructor */
    public SegmentoRecta(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
        calculos(); // Realiza los cálculos necesarios
        ecuacion(); // Genera la ecuación de la recta
    }

    /* 2 Método de Cálculo de Coeficientes */
    public void calculos() {
        // Cálculo de la pendiente (m)
        this.m = (this.punto2.getCoor_y() - this.punto1.getCoor_y())
                / (this.punto2.getCoor_x() - this.punto1.getCoor_x());
        if (Double.isInfinite(this.m)) {
            // Caso de pendiente infinita (línea vertical)
            this.a = 0;
            this.b = 1;
            this.c = -this.punto1.getCoor_x();
            this.orientacion = "Vertical";
        } else if (this.m == 0) {
            // Caso de pendiente cero (línea horizontal)
            this.a = 1;
            this.b = 0;
            this.c = -this.punto1.getCoor_y();
            this.orientacion = "Horizontal";
        } else {
            // Caso general
            this.a = 1;
            this.b = this.m;
            this.c = -(this.punto1.getCoor_y() + (this.m * this.punto1.getCoor_x()));
            if (c == -0)
                c = 0;
            if (this.m > 0) {
                this.orientacion = "Ascendente";
            } else {
                this.orientacion = "Descendente";
            }
        }
    }

    /* 3 Método de Generar la Ecuación */
    public void ecuacion() {
        this.ecuacion = "X";
        if (Double.isInfinite(this.m)) {
            if (this.c < 0) {
                this.ecuacion += this.c + "= 0"; // Si c es menor que 0, la ecuación será X + c = 0
            } else {
                this.ecuacion += "+" + this.c + "= 0"; // Si c no es menor que 0, la ecuación será X + c = 0
            }
        } else if (this.m == 0) {
            this.ecuacion = "Y";
            if (c < 0) {
                this.ecuacion += this.c + "= 0"; // Si c es menor que 0, la ecuación será Y + c = 0
            } else {
                this.ecuacion += this.c + "= 0"; // Si c no es menor que 0, la ecuación será Y + c = 0
            }
        } else {
            this.ecuacion = "Y";
            if (b > 0) {
                this.ecuacion += "-" + (Math.rint(b * 100 / 100)) + "X"; // Si b es mayor que 0, se resta b*X a la
                                                                         // ecuación
            } else {
                this.ecuacion += (Math.rint(b * 100 / 100)) + "X"; // Si b no es mayor que 0, se suma b*X a la ecuación
            }
            if (c < 0) {
                this.ecuacion += (Math.rint(c * 100 / 100)) + "= 0"; // Si c es menor que 0, se suma c a la ecuación
            } else {
                ecuacion += "-" + (Math.rint(c * 100 / 100)) + "= 0"; // Si c no es menor que 0, se resta c a la
                                                                      // ecuación
            }
        }
    }

    /* 4 Metodo de Mostrar */
    public void mostrar() {
        // Imprime los valores de a, b y c con un ancho de campo de 5 caracteres y 2
        // decimales
        System.out.printf("%5.2f %5.2f %6.2f", this.a, this.b, this.c);

        // Verifica si m es infinito y muestra "infinita" si es el caso, de lo contrario
        // muestra el valor de m con un ancho de campo de 9 caracteres y 2 decimales
        if (Double.isInfinite(this.m)) {
            System.out.printf("%9s ", "infinita");
        } else {
            System.out.printf("%9.2f ", this.m);
        }

        // Muestra la orientación y la ecuación con formato específico
        System.out.printf("%-14s %-13s\n", this.orientacion, this.ecuacion);
    }

}
