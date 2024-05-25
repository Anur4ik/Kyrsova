package quadratic;

import static java.lang.Math.sqrt;

public class OperationController {
    private double x1, x2, x3;
    private double res_x1, res_x2;
    private boolean d_minus = false;

    public boolean isD_minus() {
        return d_minus;
    }

    public OperationController(double x1, double x2, double x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    public double getRes_x1() {
        return res_x1;
    }

    public double getRes_x2() {
        return res_x2;
    }

    public void resultat() {
        double D = Math.pow(x2, 2) - (4 * x1 * x3);
        if (D > 0) {
            res_x1 = (-1 * (x2) + sqrt(D)) / (x1 * 2);
            res_x2 = (-1 * (x2) - sqrt(D)) / (x1 * 2);
            res_x1 = Math.round(res_x1 * 100.0) / 100.0;
            res_x2 = Math.round(res_x2 * 100.0) / 100.0;
        } else if (D == 0) {
            res_x1 = (-1 * (x2)) / (x1 * 2);
            res_x1 = Math.round(res_x1 * 100.0) / 100.0;
        } else {
            D = -D;
            res_x1 = (-1 * (x2) + sqrt(D)) / (x1 * 2);
            res_x2 = (-1 * (x2) - sqrt(D)) / (x1 * 2);
            res_x1 = Math.round(res_x1 * 100.0) / 100.0;
            res_x2 = Math.round(res_x2 * 100.0) / 100.0;
            d_minus = true;
        }
    }
}

