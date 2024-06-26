package com.game.hoppenhelm;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Playground {
    private int widthScreen ;
    private double widthRec;
    private int movingRectIndex;


    Playground(int widthScreen , int heightScreen , Group root) {       //the main class of playground
        this.widthRec = heightScreen / 10.0;

        for (int i = 0 ; i < this.widthRec ; i++){
            if ( i % 2 == 0){

                Rectangle rectangle = new Rectangle();      //making new play ground with playground classes
                rectangle.setFill(Color.BLACK);
                rectangle.setWidth(50);
                rectangle.setHeight(15);
                rectangle.setY(widthScreen - 15);
                rectangle.setX(heightScreen - (i * 50));
                root.getChildren().add(rectangle);

            }else {
                Rectangle rectangle = new Rectangle();      //making anew playground with playground classes
                rectangle.setFill(Color.BLUE);
                rectangle.setWidth(50);
                rectangle.setHeight(15);
                rectangle.setY(widthScreen - 15);
                rectangle.setX(heightScreen - (i * 50));
                root.getChildren().add(rectangle);
            }

        }
        root.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.E) {
                changeBlocksColor(root);
            }
        });

        root.requestFocus();
    }
    private void changeBlocksColor(Group root) {
        for (Node node : root.getChildren()) {
            if (node instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) node;
                Color currentColor = (Color) rectangle.getFill();

                if (currentColor == Color.BLACK) {
                    rectangle.setFill(Color.BLUE);
                } else if (currentColor == Color.BLUE) {
                    rectangle.setFill(Color.BLACK);
                }
            }
        }
    }

public void movePlayground(Group root){
        System.out.println(root.getChildren().get(0).getClass().getName() );

    }

}
