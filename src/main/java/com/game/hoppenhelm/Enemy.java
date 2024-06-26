package com.game.hoppenhelm;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.shape.Circle;

public class Enemy {
    private double heightScreen , widthScreen , CenterX , CenterY ;

    Rectangle rectangle ;
    public Enemy(int widthScreen, int heightScreen, int CenterX , int CenterY) {        //the main enemy class
        this.heightScreen = heightScreen;
        this.widthScreen = widthScreen;

        this.rectangle = new Rectangle();              //making a enemy with enemy class
        this.rectangle.setHeight(heightScreen);
        this.rectangle.setWidth(widthScreen);
        this.rectangle.setFill(Color.RED);
        this.rectangle.setY(CenterY);
        this.rectangle.setX(CenterX);
        this.CenterX = CenterX;
        this.CenterY = CenterY;

    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }

    double nowLocationX = 1100;

    public void moverectangle() throws InterruptedException {


        CenterX -=178;
        rectangle.setX(CenterX);
        System.out.println(CenterX);
    }

    public double getCenterX() {
        return CenterX;
    }

    public double getNowLocationX() {
        return nowLocationX;
    }



    public void  set(int widthScreen, int heightScreen, int CenterX , int CenterY) {
        this.heightScreen = heightScreen;
        this.widthScreen = widthScreen;

        this.rectangle = new Rectangle();
        this.rectangle.setHeight(heightScreen);
        this.rectangle.setWidth(widthScreen);
        this.rectangle.setFill(Color.RED);
        this.rectangle.setY(CenterY);
        this.rectangle.setX(CenterX);
        this.CenterX = CenterX;
        this.CenterY = CenterY;

    }
}
