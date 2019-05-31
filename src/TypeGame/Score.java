/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Cassidy Liu
 */
public class Score {
    private double sec;
    public void EnterScore(int a, int b) throws IOException {
        //stores to text file
        int wpm = (int) (User.getAmount()/(sec/60));
        System.out.print("" + User.getName1() + " has a score of " + a + " at a difficulty level of " + b + " and with a word amount of " + User.getAmount());
        System.out.println(". WPM is " + wpm + ".");
        System.out.println("Check txt file stored in the folder for stored score of all users.");
        BufferedWriter out;
        out = new BufferedWriter(new FileWriter("Scores.txt", true));
        out.append("" + User.getName1() + " has a score of " + a + " at a difficulty level of " + b + " and with a word count of " + User.getAmount());
        out.append(". WPM is " + wpm + ". ");
        out.newLine();
        out.close();
    }

    /**
     * @return the sec
     */
    public double getSec() {
        return sec;
    }

    /**
     * @param sec the sec to set
     */
    public void setSec(double sec) {
        this.sec = sec;
    }
    

}
