package quadratic;

import static java.lang.Math.sqrt;

public class OperationController {
    private double a, b, c;
    private double res_x1, res_x2;
    private double discriminant;

    public double getDiscriminant() {
        return discriminant;
    }

    public OperationController(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getRes_x1() {
        return res_x1;
    }

    public double getRes_x2() {
        return res_x2;
    }

    public void resultat() {
        discriminant = Math.pow(b, 2) - (4 * a * c);
        if (discriminant > 0) {
            res_x1 = (-1 * (b) + sqrt(discriminant)) / (a * 2);
            res_x2 = (-1 * (b) - sqrt(discriminant)) / (a * 2);
            res_x1 = Math.round(res_x1 * 100.0) / 100.0;
            res_x2 = Math.round(res_x2 * 100.0) / 100.0;
        } else if (discriminant == 0) {
            res_x1 = (-1 * (b)) / (a * 2);
            res_x1 = Math.round(res_x1 * 100.0) / 100.0;
        } else {
            double complex_disc = -discriminant;
            res_x1 = (-1 * (b) + sqrt(complex_disc)) / (a * 2);
            res_x2 = (-1 * (b) - sqrt(complex_disc)) / (a * 2);
            res_x1 = Math.round(res_x1 * 100.0) / 100.0;
            res_x2 = Math.round(res_x2 * 100.0) / 100.0;

        }
    }
}

