package principal;

public class Clase2 {
    /* Atributos */
    private Clase1 punto1;
    private Clase1 punto2;
    private double a, b, c;
    private double m;
    private String orientacion;
    private String ecuacion;

    /* Contructor */
    public Clase2(Clase1 punto1, Clase1 punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
        calculos();
        ecuacion();
    }

    /* Metodo de Carculo de Coeficientes */
    public void calculos() {
        this.m = (this.punto2.getCoor_y() - this.punto1.getCoor_y()) / (this.punto2.getCoor_x() - this.punto1.getCoor_x());
        if (Double.isInfinite(this.m)) {
            this.a = 0;
            this.b = 1;
            this.c = -this.punto1.getCoor_x();
            this.orientacion = "Vertical";

        } else if (this.m == 0) {
            this.a = 1;
            this.b = 0;
            this.c = -this.punto1.getCoor_y();
            this.orientacion = "Horizontal";

        } else {
            this.a = 1;
            this.b = this.m;
            this.c = -(this.punto1.getCoor_y() + (this.m * this.punto1.getCoor_x()));
            if (c == -0)
                c = 0;
            if (this.m > 0) {
                this.orientacion = "Acendente";

            } else {
                this.orientacion = "Desendente";
            }

        }
    }

    /* Metodo de Hacer la Ecuacion */
    public void ecuacion() {
        this.ecuacion = "X";
        if (Double.isInfinite(this.m)) {
            if (this.c < 0) {
                this.ecuacion += this.c + "= 0";
            } else {
                this.ecuacion += "+" + this.c + "= 0";

            }

        } else if (this.m == 0) {
            this.ecuacion = "Y";
            if (c < 0) {
                this.ecuacion += this.c + "= 0";

            } else {
                this.ecuacion += this.c + "= 0";
            }

        } else {
            this.ecuacion = "Y";
            if (b > 0) {
                this.ecuacion += "-" + (Math.rint(b * 100 / 100)) + "X";

            } else {
                this.ecuacion += (Math.rint(b * 100 / 100)) + "X";
            }
            if (c < 0) {
                this.ecuacion += (Math.rint(c * 100 / 100)) + "= 0";

            } else {
                ecuacion += "-" + (Math.rint(c * 100 / 100)) + "= 0";
            }
        }
    }

    /* Metodo de Mostrar */
    public void mostrar() {
        System.out.printf("%5.2f %5.2f %6.2f", this.a, this.b, this.c);
        if (Double.isInfinite(this.m)) {
            System.out.printf("%9s ", "infinita");
            
        }else{
            System.out.printf("%9.2f " ,this.m);
        }
        System.out.printf("%-14s %-13s\n", this.orientacion, this.ecuacion);
    }

}
