package degreesOfNumber;

import javax.swing.*;

public class OperationController {
   private int b1, q, n;
    public OperationController(int b1, int q, int n) {
        this.b1 = b1;
        this.q = q;
        this.n = n;

    }
    public String result(JTextArea textArea) {
         double bn;
        for (int i = 1; i <= n; i++) {
            bn = b1 * Math.pow(q, i - 1);
            textArea.append(i + "        " + (int) bn+ "\n");
        }
        return textArea.getText();

    }


}

