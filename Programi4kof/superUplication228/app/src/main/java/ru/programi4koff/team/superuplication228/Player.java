package ru.programi4koff.team.superuplication228;

/**
 * Created by user on 6/16/2016.
 */
public class Player {
    private float xPlayer;
    private float yPlayer;
    private float side;

    public Player(float xPlayer, float yPlayer, float side) {
        this.xPlayer = xPlayer;
        this.yPlayer = yPlayer;
        this.side = side;
    }

    public float getxPlayer() {
        return xPlayer;
    }

    public float getyPlayer() {
        return yPlayer;
    }

    public void setxPlayer(float xPlayer) {
        this.xPlayer = xPlayer;
    }

    public void setyPlayer(float yPlayer) {
        this.yPlayer = yPlayer;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }
}
