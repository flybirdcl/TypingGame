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
import java.util.Scanner;
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

    private static String name;
    //public static String inputer;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static JTextField textField;

    /**
     * @return the name
     */
    public static String getName1() {
        return name;
    }

    /**
     * @param aName the name to set
     */
    public static void setName1(String aName) {
        name = aName;
    }
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

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 25));

        JLabel label = new JLabel("");

        /*JButton okButton = new JButton("Enter");
         okButton.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
         String input = textField.getText();
         System.out.println("Input: " + input);

         //label.setText(input);
         }
         });*/
        //inputer = textField.getText();
        container.add(textField);
        //container.add(okButton);
        container.add(label);

        frame.setVisible(true);

    } 

    public static Boolean getTruth(String a) {

        //System.out.println(inputer);
        if (textField.getText().equals(a)) {
            textField.setText("");
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username");
        String userName = myObj.nextLine();  // Read user input
        setName1(userName);

        User run = new User();

    }

}
