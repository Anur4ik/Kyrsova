package degreesOfNumber;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUI extends JFrame {
    public void MyFrame(){
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(Box.createVerticalStrut(20));

        JPanel in_panel1 = new JPanel();
        JPanel in_panel2 = new JPanel();
        JPanel in_panel3 = new JPanel();
        JPanel in_panel4 = new JPanel();
        JLabel l_firstNumber= new JLabel(" First number ");
        JLabel l_qNumber = new JLabel("Common ratio!");
        JLabel l_kNumber = new JLabel("Number of terms");
        JButton button1 = new JButton("Calculate");
        JTextField t_firstNumber = new JTextField(5);
        JTextField t_qNumber = new JTextField(5);
        JTextField t_kNumber = new JTextField(5);
        JTextArea textArea = new JTextArea(7, 12);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton button2 = new JButton("Quit");
        JButton button3 = new JButton("Clear");

        button1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button3.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        l_firstNumber.setFont(new Font("Comic Sans",Font.BOLD,20));
        l_qNumber.setFont(new Font("Comic Sans",Font.BOLD,20));
        l_kNumber.setFont(new Font("Comic Sans",Font.BOLD,16));

        textArea.setEditable(false);

        Border matteBorder = BorderFactory.createMatteBorder(1,  1, 1, 1, Color.black);
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        textArea.setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));
        textArea.setText("n        X"+"\n");
        textArea.append("-------------"+"\n");


        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setFont(new Font("Comic Sans",Font.BOLD,18));


        in_panel1.add(l_firstNumber);
        in_panel1.add(t_firstNumber);
        panel1.add(in_panel1);
        in_panel2.add(l_qNumber);
        in_panel2.add(t_qNumber);
        panel1.add(in_panel2);
        in_panel3.add(l_kNumber);
        in_panel3.add(t_kNumber);
        panel1.add(in_panel3);
        in_panel4.add(button1);
        in_panel4.add(button2);
        panel1.add(in_panel4);
        panel2.add(scrollPane );
        panel2.add(button3);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t_firstNumber.setEditable(false);
                t_qNumber.setEditable(false);
                t_kNumber.setEditable(false);
                button1.setEnabled(false);
                try {
                    int b = Integer.parseInt(t_firstNumber.getText());
                    int q = Integer.parseInt(t_qNumber.getText());
                    int n = Integer.parseInt(t_kNumber.getText());
                    OperationController setting = new OperationController(b, q, n);
                    textArea.setText(String.valueOf(setting.result(textArea)));
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(SwingUI.this, "Введіть дані", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t_firstNumber.setEditable(true);
                t_qNumber.setEditable(true);
                button1.setEnabled(true);
                t_kNumber.setEditable(true);
                t_firstNumber.setText("");
                t_qNumber.setText("");
                t_kNumber.setText("");
                textArea.setText("n        X"+"\n");
                textArea.append("-------------"+"\n");
            }
        });
        panel1.setPreferredSize(new Dimension(220, 60));
        panel2.setPreferredSize(new Dimension(250, 60));

        this.setTitle("Геометрична прогресія");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.add(panel1, BorderLayout.WEST);
        this.add(panel2, BorderLayout.EAST);

        this.setVisible(true);



    }

}
