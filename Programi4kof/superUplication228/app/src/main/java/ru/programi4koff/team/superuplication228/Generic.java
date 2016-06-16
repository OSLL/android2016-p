package ru.programi4koff.team.superuplication228;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 6/16/2016.
 */
public class Generic {
    private float side;
    private int heightMyltiplyNumber;
    private ArrayList<Poligon> map = new ArrayList<>();

    private void sortMap(float windowWidth, float windowHeight){
        side = windowWidth/18;
        Random r = new Random();
        for (int i = 0; i < 18; i++) {
            heightMyltiplyNumber = r.nextInt(4) + 1;
            map.add(new Poligon(side, side*heightMyltiplyNumber, i*side, windowHeight-side*heightMyltiplyNumber));
        }


    }

    public ArrayList<Poligon> getMap(float windowWidth, float windowHeight) {
        sortMap(windowWidth,windowHeight);
        return map;

    }
}
