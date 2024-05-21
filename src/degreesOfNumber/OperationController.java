package degreesOfNumber;

import javax.swing.*;

public class OperationController {
    double b, q, n;
    double res_x1;
    public OperationController(double b, double q, double n) {
        this.b = b;
        this.q = q;
        this.n = n;

    }
    public String result(JTextArea textArea) {
        for (int i = 1; i <= n; i++) {
            res_x1 = b * Math.pow(q, i - 1);
            textArea.append(i + "        " + Math.round(res_x1 * 100.0) / 100.0+ "\n");
        }
        return textArea.getText();

    }


}

