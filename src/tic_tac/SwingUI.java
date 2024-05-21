package tic_tac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingUI extends JFrame {
    public int count=0;
    public void MyFrame(){
        JPanel panel1 = new JPanel(new GridLayout(3,3));
        int[][] matrix = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        JButton button1 = new JButton("");
        JButton button2 = new JButton("");
        JButton button3 = new JButton("");
        JButton button4 = new JButton("");
        JButton button5 = new JButton("");
        JButton button6 = new JButton("");
        JButton button7= new JButton("");
        JButton button8 = new JButton("");
        JButton button9 = new JButton("");
        JButton[] buttons = {button1,button2,button3,button4,button5,button6,button7,button8,button9};
        button1.setPreferredSize(new Dimension(150,40));

        button1.setFocusable(false);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[0][0]= tic_or_toe(button1);
                check(matrix,buttons);
                yes_draw(matrix,buttons);

            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[0][1]= tic_or_toe(button2);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[0][2]=tic_or_toe(button3);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[1][0]= tic_or_toe(button4);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[1][1]= tic_or_toe(button5);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[1][2]= tic_or_toe(button6);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[2][0]=  tic_or_toe(button7);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[2][1]=  tic_or_toe(button8);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                matrix[2][2]= tic_or_toe(button9);
                check(matrix,buttons);
                yes_draw(matrix,buttons);
            }
        });
        this.setTitle("TicTac");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(470, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(panel1, BorderLayout.WEST);
        this.setVisible(true);
    }

    public int tic_or_toe(JButton button) {
        if (count % 2 == 0) {
            button.setText("X");
            button.setFont(new Font("Comic Sans", Font.BOLD, 80));
            button.setEnabled(false); // Блокируем кнопку
            UIManager.getDefaults().put("Button.disabledText", Color.RED);
            count++;
            return 1;
        } else {
            button.setText("O");
            button.setFont(new Font("Comic Sans", Font.BOLD, 80));
            button.setForeground(Color.blue);
            button.setEnabled(false);
            UIManager.getDefaults().put("Button.disabledText", Color.BLUE);
            count++;
            return 0;
        }
    }
    void yes_draw(int[][] matrix, JButton[] buttons ){
        int max=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] != 2) {
                    max++;
                }
            }
        }
        if (max==9) {
            JOptionPane.showMessageDialog(null, "Нічия", "Перемога", JOptionPane.INFORMATION_MESSAGE);
            restart_game(buttons,matrix);
        }
    }

    public void check(int[][] matrix, JButton[] buttons ) {
        if (count % 2 == 0) {
            if (checkWinner(matrix, 0) == true) {
                JOptionPane.showMessageDialog(SwingUI.this, "Перемога Ноліков", "Перемога", JOptionPane.ERROR_MESSAGE);
                restart_game(buttons,matrix);
            }
        } else{
            if (checkWinner(matrix, 1) == true) {
                JOptionPane.showMessageDialog(SwingUI.this, "Перемога Хрестиков", "Перемога", JOptionPane.INFORMATION_MESSAGE);
                restart_game(buttons,matrix);
            }
        }
    }
    public boolean checkWinner(int[][] matrix, int player) {
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == player && matrix[i][1] == player && matrix[i][2] == player) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (matrix[0][i] == player && matrix[1][i] == player && matrix[2][i] == player) {
                return true;
            }
        }
        if (matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player) {
            return true;
        }
        if (matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player) {
            return true;
        }
        return false;
    }
    public void restart_game(JButton[] buttons,int[][] matrix){
        for(int i=0;i<buttons.length;i++){
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 2;
            }
        }
        count=0;

    }

}


