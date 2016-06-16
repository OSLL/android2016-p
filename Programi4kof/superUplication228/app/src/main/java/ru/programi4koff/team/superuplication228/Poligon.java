package ru.programi4koff.team.superuplication228;

/**
 * Created by user on 6/16/2016.
 */
public class Poligon {
    private double width = 0;
    private double height = 0;
    private double xCoordinate = 0;
    private double yCoordinate = 0;

    public Poligon(double height, double width, double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getHeight() {
        return height;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

}
