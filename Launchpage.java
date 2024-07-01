 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launchpage extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton myButton;
    JRadioButton rb1,rb2;
    JButton b;

    Launchpage() {
        rb1=new JRadioButton("Male");
        rb1.setBounds(100,50,100,30);
        rb2=new JRadioButton("Female");
        rb2.setBounds(100,100,100,30);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);bg.add(rb2);
        myButton=new JButton("click");
        myButton.setBounds(100,150,80,30);
        myButton.addActionListener(this);
        add(rb1);add(rb2);add(myButton);
        setSize(300,300);
        setLayout(null);
        setVisible(true);

        b.setBounds(100, 160, 200, 40);
            b.setFocusable(false);
            b.addActionListener(this);
            frame.add(b);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);
        }

        public void actionPerformed (ActionEvent e){
            if (e.getSource() == myButton) {
                if(rb1.isSelected()){
                    JOptionPane.showMessageDialog(this,"You are Male.");
                }
                if(rb2.isSelected()){
                    JOptionPane.showMessageDialog(this,"You are Female.");
                }

                frame.dispose();
                TicTacToeGame ticTacToeGame = new TicTacToeGame();
            }
        }
    }