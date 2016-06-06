package model;

import controller.Observer;

import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

/**
 * Created by user on 6/3/2016.
 */
public class Human implements Observer {
    int x;
    int y;
    int size;

    int acc = 10;

    public Human(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void moveLeft(){
        x = x - 1*acc;
    }

    public void moveRight(){
        x = x + 1*acc;
    }

    public void moveUp(){
        y = y + 1*acc;
    }

    public void moveDown(){
        y = y - 1*acc;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    //этот код поменяется, когда будем делать Activity
    public void update(KeyEvent key) {
        int direction = key.getKeyCode(); //берем код клавиши, который был нажат
        switch (direction){
            case KeyEvent.VK_D:
                moveRight();
                System.out.println("x : " + getX());
                break;
            case KeyEvent.VK_A:
                moveLeft();
                System.out.println("x : " + getX());
                break;
            case KeyEvent.VK_W:
                moveDown();
                System.out.println("y : " + getY());
                break;
            case KeyEvent.VK_S:
                moveUp();
                System.out.println("y : " + getY());
                break;
        }
    }
}
