package TypeGame;

import java.awt.Component;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liuc5363
 */
public class User extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public User() {
        super("Typing Game");
        setSize(WIDTH, HEIGHT);

        DifficultyGame theGame = new DifficultyGame();
        ((Component) theGame).setFocusable(true);

        getContentPane().add(theGame);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // BUTTON STUFF
        //JFrame frame = new JFrame();
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new FlowLayout());

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 25));

        JLabel label = new JLabel("");

        JButton okButton = new JButton("Enter");
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                System.out.println("Input: " + input);

                //label.setText(input);
            }
        });

        container.add(textField);
        container.add(okButton);
        container.add(label);

        frame.setVisible(true);
        
    }

    public static void main(String args[]) {
        User run = new User();
        
    }
}
