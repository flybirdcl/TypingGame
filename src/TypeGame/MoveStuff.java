/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeGame;

/**
 *
 * @author liuc5363
 */
import java.awt.Color;
import java.awt.Graphics;

public abstract class MoveStuff implements Moving {

    private int xPos;
    private int yPos;

    public MoveStuff() {
        xPos = 10;
        yPos = 10;
    }

    public MoveStuff(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public abstract void draw(Graphics window);

    public String toString() {
        return getX() + " " + getY();
    }
}
