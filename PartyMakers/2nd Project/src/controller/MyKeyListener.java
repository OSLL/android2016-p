package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by user on 6/3/2016.
 */
public class MyKeyListener implements KeyListener, Observable {
    private Observer observer;
    @Override
    public void keyTyped(KeyEvent e) {
        notifyObservers(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        notifyObservers(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void addObserver(Observer o) {
        observer = o;
    }

    public void notifyObservers(KeyEvent e) {
        observer.update(e);
    }
}
