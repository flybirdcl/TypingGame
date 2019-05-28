/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author liuc5363
 */
public class DifficultyGame extends Canvas implements KeyListener, Runnable {

    private int difficulty;
    private MoveWords pass;
    private BufferedImage back;
    private String input;
    private Boolean[] keys;
    private ArrayList<String> wordList;
    private int x = 1;

    public DifficultyGame() {
        setBackground(Color.white);

        //instantiate words on screen
        keys = new Boolean[1];
        keys[0] = false;
        pass = new MoveWords(10);
        wordList = new ArrayList<String>();
        //input = new String("");
        try (BufferedReader br = new BufferedReader(new FileReader("WordList.txt"))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
              wordList.add(sCurrentLine);
            }
            
        } catch (IOException e) {
            System.out.println("CAN'T FIND FILE NAME OF WordList.txt. Make sure it's in the folder.");
        }
        this.addKeyListener(this);
        new Thread(this).start();

        setVisible(true);
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(0, 0, 800, 600);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("Typing Game", 25, 50);

        pass.moveAll();

        pass.drawAll(graphToBack);
        if (keys[0] == true) {
            for (String b : wordList) {
                Boolean checker = User.getTruth(b);
            }
            keys[0] = false;
        }
        twoDGraph.drawImage(back, null, 0, 0);

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            keys[0] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            keys[0] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        //no code needed here
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
