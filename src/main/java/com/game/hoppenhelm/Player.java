package com.game.hoppenhelm;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle; // for use in earth of game
import javafx.util.Duration;

import java.lang.Thread;

public class Player extends Parent {

    private int CenterX , CenterY , Radius ;
    private AnimationTimer timer;
    private double targetY , currentY , deltaY;
    Circle circle;
    public Player(int CenterX , int CenterY , int Radius) {     //the main player class
        this.CenterX = CenterX ;
        this.CenterY = CenterY ;
        this.Radius = Radius ;

        this.circle = new Circle();         //making player
        this.circle.setCenterX(80);
        this.circle.setFill(Color.LIGHTGREEN);
        this.circle.setCenterY(650);
        this.circle.setRadius(50);

    }
    public Circle getCircle() {
        return circle;
    }

    public int getCenterX() {
        return CenterX;
    }

    public int getCenterY() {
        return CenterY;
    }

    public void moveCircle() throws InterruptedException {
        System.out.println("hello");
        double nowLocationY = circle.getCenterY();

        circle.setCenterY(nowLocationY -100 );

    }

}
