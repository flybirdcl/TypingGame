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
public interface Moving {

    public void setPos(int x, int y);

    public void setX(int x);

    public void setY(int y);

    public int getX();

    public int getY();

    public void setSpeed(int s);

    public int getSpeed();
}