package degreesOfNumber;

import javax.swing.*;

public class OperationController {
   private int b, q, n;
    public OperationController(int b, int q, int n) {
        this.b = b;
        this.q = q;
        this.n = n;

    }
    public String result(JTextArea textArea) {
         double res_x1;
        for (int i = 1; i <= n; i++) {
            res_x1 = b * Math.pow(q, i - 1);
            textArea.append(i + "        " + (int) res_x1+ "\n");
        }
        return textArea.getText();

    }


}

