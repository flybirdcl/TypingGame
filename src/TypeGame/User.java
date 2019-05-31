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
import javax.swing.JOptionPane;
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
    private static int Difficulty;
    private static int amount;

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

    /**
     * @return the Difficulty
     */
    public static int getDifficulty() {
        return Difficulty;
    }

    /**
     * @param aDifficulty the Difficulty to set
     */
    public static void setDifficulty(int aDifficulty) {
        Difficulty = aDifficulty;
    }

    /**
     * @return the amount
     */
    public static int getAmount() {
        return amount;
    }

    /**
     * @param aAmount the amount to set
     */
    public static void setAmount(int aAmount) {
        amount = aAmount;
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
        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //System.out.println("Enter username");
        Object[] options1 = {"Okay."};

        JOptionPane.showOptionDialog(null,
                "1. Just type the word displayed on the screen" + "\n2. Do not press spacebar/enter to enter the word in as this game does it automatically." + "\n3. And most importantly, have fun. - Cassidy Liu, Per 1",
                "Game Rules",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options1,
                null);
        String userName = JOptionPane.showInputDialog(null, "Enter your username:");
        String c = JOptionPane.showInputDialog(null, "Enter difficulty (Input numbers 1-5 with 1 being the easiest)");

        try {
            setDifficulty(Integer.parseInt(c));
        } catch (NumberFormatException ex) {
            System.out.println("Is not an integer! Please at least input only integers!");
            System.exit(0);
        }
        if (!(Difficulty >= 1 && Difficulty <= 5)) {
            System.out.println("PLEASE INPUT NUMBERS 1-5 ONLY");
            System.exit(0);
        }
        String d = JOptionPane.showInputDialog(null, "Enter the amount of words to be used (1-40)");

        try {
            setAmount(Integer.parseInt(d));
        } catch (NumberFormatException ex) {
            System.out.println("Is not an integer! Please at least input only integers!");
        }
        if (!(amount >= 1 && amount <= 40)) {
            System.out.println("PLEASE INPUT NUMBERS 1-40 ONLY");
            System.exit(0);
        }
        //String userName = myObj.nextLine();  // Read user input
        setName1(userName);
        User run = new User();

    }

}
