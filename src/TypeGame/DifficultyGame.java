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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liuc5363
 */
public class DifficultyGame extends Canvas implements KeyListener, Runnable {

    private MoveWords pass;
    private BufferedImage back;
    private String input;
    private Boolean[] keys;
    private ArrayList<String> wordList;
    private int x = 1;
    private Score keeper;
    private int scorer;
    

    public DifficultyGame() {
        setBackground(Color.white);

        //instantiate words on screen
        keys = new Boolean[1];
        scorer = 0;
        keys[0] = false;
        keeper = new Score();
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
        pass = new MoveWords(wordList);
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
        graphToBack.setColor(Color.RED);
        graphToBack.drawString("Score: " + scorer, 720, 540);
        pass.moveAll();
        Boolean checker;
        pass.drawAll(graphToBack);
        if (keys[0] == true) {
            System.out.println("h");
            for (String b : wordList) {
                checker = User.getTruth(b);
                if (checker == true) {
                    pass.removeEntered(b);
                    break;
                }
            }
            keys[0] = false;
        }
        for (String b : wordList) {
            checker = User.getTruth(b);
            if (checker == true) {
                pass.removeEntered(b);
                scorer++;
                break;
            }
        }
        //sutbract score when last word passes
        if(pass.getBunch().get(pass.getBunch().size()-1).getX() > 740){
            scorer--;
        } 
        for (Words a : pass.getBunch()) {
            int i = 0;
            if (a.getX() > 740) {
                a.setX(0);
            }
        }
        
        
        if(pass.getBunch().size() == 0){
            try {
                keeper.EnterScore(scorer);
            } catch (IOException ex) {
                Logger.getLogger(DifficultyGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
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
                Thread.currentThread().sleep(10);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
