package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    public JButton[] buttons = new JButton[9];

    JLabel textLabel = new JLabel();
    JLabel buttonLabel = new JLabel();

    int turno;

    TicTacToe(){
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}

        this.setSize(800,800);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("TIC-TAC-TOE");

        buttonLabel.setBounds(10,120,780,650);
        buttonLabel.setVisible(true);
        buttonLabel.setOpaque(true);
        buttonLabel.setBackground(Color.DARK_GRAY);
        buttonLabel.setLayout(new GridLayout(3,3,0,0));

        textLabel.setBounds(10,10,780,150);
        textLabel.setSize(780,150);
        textLabel.setVerticalTextPosition(JLabel.NORTH);
        textLabel.setHorizontalTextPosition(JLabel.CENTER);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setVisible(true);
        textLabel.setForeground(Color.WHITE);
        textLabel.setText("TIC-TAC-TOE");
        textLabel.setFont(new Font("LEMON MILK",Font.BOLD,30));
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setOpaque(true);

        for (int i =0; i<9; i++){
            buttons[i] = new JButton();
            buttonLabel.add(buttons[i]);
            buttons[i].setFont(new Font("LEMON MILK",Font.BOLD,70));
            buttons[i].setForeground(Color.red);
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        turno = randomTurn();

        if(turno==1){
            textLabel.setText("TURNO DI X: ");
        }
        else{
            textLabel.setText("TURNO DI O: ");
        }



        this.add(buttonLabel);
        this.add(textLabel,BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i<9;i++){

            if(checkWinX()) {
                for (int j = 0; j<9;j++){
                    buttons[j].setEnabled(false);
                }
                textLabel.setText("X HA vinto");
                break;

            }
            if(checkWinY()) {
                for (int j = 0; j<9;j++){
                    buttons[j].setEnabled(false);
                }
                textLabel.setText("O HA vinto");
                break;

            }

            if(checkDraw()){
                for (int j = 0; j<9;j++){
                    buttons[j].setEnabled(false);
                }
                textLabel.setText("PAREGGIO");
                break;
            }

            if(e.getSource()==buttons[i]&&checkSpace(buttons[i])){
                if(turno==1){
                    buttons[i].setText("X");
                }
                else{
                    buttons[i].setText("O");
                }


                if(turno == 1) turno =2;
                else turno=1;

                if(turno==1) textLabel.setText("TURNO DI X: ");
                else textLabel.setText("TURNO DI O: ");

            }


        }



    }

    public int randomTurn(){
        return new Random().nextInt(1,3);
    }

    public boolean checkSpace(JButton button){
        return !Objects.equals(button.getText(), "X") && !Objects.equals(button.getText(), "O");
    }

    public boolean checkWinX(){
        if(Objects.equals(buttons[0].getText(), "X") && buttons[1].getText().equals("X") && Objects.equals(buttons[2].getText(), "X")) return true;
        else if(Objects.equals(buttons[3].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[5].getText(), "X")) return true;
        else if(Objects.equals(buttons[6].getText(), "X") && Objects.equals(buttons[7].getText(), "X") && Objects.equals(buttons[8].getText(), "X")) return true;

        else if(Objects.equals(buttons[0].getText(), "X") && Objects.equals(buttons[3].getText(), "X") && Objects.equals(buttons[6].getText(), "X")) return true;
        else if(Objects.equals(buttons[1].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[7].getText(), "X")) return true;
        else if(Objects.equals(buttons[2].getText(), "X") && Objects.equals(buttons[5].getText(), "X") && Objects.equals(buttons[8].getText(), "X")) return true;

        else if(Objects.equals(buttons[0].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[8].getText(), "X")) return true;
        else if(Objects.equals(buttons[6].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[2].getText(), "X")) return true;

        return false;

    }

    public boolean checkWinY(){
        if(Objects.equals(buttons[0].getText(), "O") && buttons[1].getText().equals("O") && Objects.equals(buttons[2].getText(), "O")) return true;
        else if(Objects.equals(buttons[3].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[5].getText(), "O")) return true;
        else if(Objects.equals(buttons[6].getText(), "O") && Objects.equals(buttons[7].getText(), "O") && Objects.equals(buttons[8].getText(), "O")) return true;

        else if(Objects.equals(buttons[0].getText(), "O") && Objects.equals(buttons[3].getText(), "O") && Objects.equals(buttons[6].getText(), "O")) return true;
        else if(Objects.equals(buttons[1].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[7].getText(), "O")) return true;
        else if(Objects.equals(buttons[2].getText(), "O") && Objects.equals(buttons[5].getText(), "O") && Objects.equals(buttons[8].getText(), "O")) return true;

        else if(Objects.equals(buttons[0].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[8].getText(), "O")) return true;
        else if(Objects.equals(buttons[6].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[2].getText(), "O")) return true;

        else return false;

    }

    public boolean checkDraw(){
        int occupati=0;
        if(!checkWinX() && !checkWinY()){
            for (int i = 0; i<9;i++){
                if(!(Objects.equals(buttons[i].getText(), ""))) occupati++;
            }
        }

        if (occupati==9) return true;
        else return false;

    }


}
