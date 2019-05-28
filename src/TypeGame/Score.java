/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Cassidy Liu
 */
public class Score {

    public void EnterScore(int a, int b) throws IOException {
        //stores to text file
        System.out.println("" + User.getName1() + " has a score of " + a + " at a difficulty level of " + b + " and with a word amount of " + User.getAmount());
        System.out.println("Check txt file stored in the folder for stored score of all users.");
        PrintWriter out = new PrintWriter("Scores.txt");
        
        out.println("" + User.getName1() + " has a score of " + a + " at a difficulty level of " + b + " and with a word count of " + User.getAmount());
        out.close();
    }

}
