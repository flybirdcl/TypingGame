/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author liuc5363
 */
//done with all
public class Words extends MoveStuff {

    private int speed;
    private String stuff;

    public Words(String b, int x, int y) {
        super(x - (int) (Math.random() * 100), y);
        stuff = b;
        speed = 1;
    }

    public Words(String b, int x, int y, int spd) {
        super(x - (int) (Math.random() * 200), y);
        stuff = b;
        speed = spd;
    }

    public void draw(Graphics window) {
        window.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        window.setColor(Color.BLACK);
        window.drawString(stuff, super.getX(), super.getY());

    }

    public void move() {
        super.setX(super.getX() + speed);

        //System.out.println(super.getX());
        System.out.println(super.getY());

    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the stuff
     */
    public String getStuff() {
        return stuff;
    }

    /**
     * @param stuff the stuff to set
     */
    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

}
