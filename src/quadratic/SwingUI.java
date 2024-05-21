package quadratic;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUI extends JFrame {
    public void MyFrame(){
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        JPanel panel3 =new JPanel(new FlowLayout(FlowLayout.LEFT, 50,5));

        JLabel margin_left = new JLabel();
        margin_left.setPreferredSize(new Dimension(45, 0));

        JButton button1 = new JButton("Calculate");
        JButton button2 = new JButton("Quit");
        JButton button3 = new JButton("Clear");

        JTextField textFieldx2 = new JTextField(3);
        JTextField textFieldx = new JTextField(3);
        JTextField textField = new JTextField(3);

        JTextField textFieldResx1 = new JTextField(5);
        JTextField textFieldResx2 = new JTextField(5);
        textFieldResx1.setEditable(false);
        textFieldResx2.setEditable(false);

        JLabel labelx2 = new JLabel("<html>x<sup>2</sup> +</html>");
        JLabel labelx = new JLabel("x +");
        JLabel label = new JLabel(" = 0");

        JLabel labelResultx1 = new JLabel("X1 =");
        JLabel labelResultx2 = new JLabel("     X2 =");



        labelx2.setBorder(BorderFactory.createEmptyBorder(-2, 0, 0, 0));
        labelx.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        Border matteBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        textFieldx2.setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));
        textFieldx.setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));
        textField.setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));
        textFieldResx1.setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));
        textFieldResx2.setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));

        panel1.add(textFieldx2);
        panel1.add(labelx2);
        panel1.add(textFieldx);
        panel1.add(labelx);
        panel1.add(textField);
        panel1.add(label);

        panel2.add(margin_left);
        panel2.add(labelResultx1);
        panel2.add(textFieldResx1);
        panel2.add(labelResultx2);
        panel2.add(textFieldResx2);


        labelx2.setFont(new Font("Comic Sans",Font.BOLD,26));
        labelx.setFont(new Font("Comic Sans",Font.BOLD,26));
        label.setFont(new Font("Comic Sans",Font.BOLD,26));

        labelResultx1.setFont(new Font("Comic Sans",Font.BOLD,20));
        labelResultx2.setFont(new Font("Comic Sans",Font.BOLD,20));

        textFieldx2.setFont(new Font("Comic Sans",Font.BOLD,20));
        textFieldx.setFont(new Font("Comic Sans",Font.BOLD,20));
        textField.setFont(new Font("Comic Sans",Font.BOLD,20));
        textFieldResx1.setFont(new Font("Comic Sans",Font.BOLD,14));
        textFieldResx2.setFont(new Font("Comic Sans",Font.BOLD,14));


        ///////////////////////////////////////////////////////////
        button1.setPreferredSize(new Dimension(150,40));
        button1.setFont(new Font("Comic Sans",Font.BOLD,20));
        button1.setFocusable(false);
        button1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button1.setForeground(Color.BLACK);
        panel3.add(button1);
       //////////////////////////////////////////////////
      

        button1.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          textFieldx2.setEditable(false);
                                          textFieldx.setEditable(false);
                                          textField.setEditable(false);

                                          try {
                                              double x1 = Double.parseDouble(textFieldx2.getText());
                                              double x2 = Double.parseDouble(textFieldx.getText());
                                              double x3 = Double.parseDouble(textField.getText());
                                              OperationController setting = new OperationController(x1, x2, x3);
                                              setting.resultat();
                                              if(setting.d_minus==false) {
                                                  textFieldResx1.setText(String.valueOf(setting.res_x1));
                                                  textFieldResx2.setText(String.valueOf(setting.res_x2));
                                              }
                                              else{
                                                  textFieldResx1.setText(setting.res_x1+"i");
                                                  textFieldResx2.setText(setting.res_x2+"i");

                                              }
                                          }
                                          catch (NumberFormatException ex){
                                              JOptionPane.showMessageDialog(SwingUI.this, "Введіть дані", "Error", JOptionPane.ERROR_MESSAGE);

                                          }
                                      }
                                  });

        button3.setPreferredSize(new Dimension(60,40));
        button3.setFont(new Font("Comic Sans",Font.BOLD,15));
        button3.setFocusable(false);
        button3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button3.setForeground(Color.BLACK);
        panel3.add(button3);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldx2.setText("");
                textFieldx.setText("");
                textField.setText("");
                textFieldResx1.setText("");
                textFieldResx2.setText("");
                textFieldx2.setEditable(true);
                textFieldx.setEditable(true);
                textField.setEditable(true);

            }
        });
        ///////////////////////////////////////////////////////////////
        button2.setPreferredSize(new Dimension(80,40));
        button2.setFont(new Font("Comic Sans",Font.BOLD,20));
        button2.setFocusable(false);
        button2.setForeground(Color.BLACK);
        button2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel3.add(button2);

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
             }
        });


        panel1.setPreferredSize(new Dimension(250, 60));
        panel2.setPreferredSize(new Dimension(250, 60));
        panel3.setPreferredSize(new Dimension(250, 70));

        this.setTitle("Квадратне рівняння");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 240);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);

        this.setVisible(true);



    }

}
