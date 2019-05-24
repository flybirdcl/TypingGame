/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeGame;

import java.awt.Graphics;
import java.util.*;

/**
 *
 * @author liuc5363
 */
public class MoveWords {

    private List<Words> Bunch;

    public MoveWords(int speed, int size) {
        Bunch = new ArrayList<Words>();
        for (int i = 0; i < size; i++) {
            Bunch.add(new Words("SUP", -10, (int) (Math.random() * 450), speed));

        }
    }

    public MoveWords(int size) {
        Bunch = new ArrayList<Words>();
        for (int i = 0; i < size; i++) {
            Bunch.add(new Words("SUP", -10, (int) (Math.random() * 450) + 70, 1));
        }
    }

    public void add(Words al) {
        getBunch().add(al);
    }

    public void drawAll(Graphics window) {
        for (Words i : getBunch()) {
            i.draw(window);
        }
    }

    public void moveAll() {
        for (Words i : getBunch()) {
            i.move();
        }
    }

    public void removeEntered(String b) {
        int i = 0;
        for (Words e : Bunch) {
            String c = e.getStuff();
            if (b.equals(c)) {
                Bunch.remove(i);
                i--;
            }
            i++;
        }

    }

    public void removeAllWords() {
        getBunch().clear();
    }

    public String toString() {
        return "";
    }

    /**
     * @return the Bunch
     */
    public List<Words> getBunch() {
        return Bunch;
    }

    /**
     * @param Bunch the Bunch to set
     */
    public void setBunch(List<Words> Bunch) {
        this.Bunch = Bunch;
    }

}
