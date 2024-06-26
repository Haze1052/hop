package com.game.hoppenhelm;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Label;
import javafx.application.Platform;

public class Game extends Application {         //the main class of game
    protected int hp = 3;
    private int widthScreen, heightScreen;
//    static Timer timer= new Timer();
//    static TimerTask Task = new MyTimerTask();
    int contrl = 0;
    Random random = new Random();
    int temp = random.nextInt(10)+7;
    Enemy enemy;
    static Label barchasb_timer;
    static int first_time = 5;
    static int end_time;
    static Timer timer= new Timer();
    static TimerTask Task = new Timer_Task();

    static Stage my_stage;

    public static void main(String[] args) {
        launch();

    }
    @Override
    public void start(Stage stage) throws IOException {         //the start of the game
        my_stage = stage;
        this.widthScreen = 720;         //for screen size
        this.heightScreen = 1080;
        Player player = new Player(80 , 650 , 50); //player object and size
        enemy = new Enemy(90 , 110 , 1100 , 595 ); //enemy object and size
        Group root = new Group(player.getCircle() , enemy.getRectangle() );

        barchasb_timer = new Label("Time left: " + first_time);
        barchasb_timer.setTextFill(Color.BLACK);
        barchasb_timer.setStyle("-fx-font-size: 40px;");
        barchasb_timer.setLayoutX(0);
        barchasb_timer.setLayoutY(0);
        root.getChildren().add(barchasb_timer);
        end_time = 5;// time for end


        Scene scene = new Scene(root, this.heightScreen, this.widthScreen); // screen and dimension
        scene.setFill(Color.DARKCYAN);          //for theme color
        stage.setTitle("Hoppenhelm game"); //window title

        stage.setScene(scene); // set scene on stage

        Playground playground = new Playground(this.widthScreen, this.heightScreen , root);

        Task = new Timer_Task();
        timer.scheduleAtFixedRate(Task, 0, 1000);

//        Task = new MyTimerTask();
//        timer.schedule(Task, 10000);

        scene.setOnKeyPressed(e -> {

            if(e.getCode() == KeyCode.E){       //for control key for moving
                contrl++;
                if(root.getChildren().get(1).getClass().getName() == "javafx.scene.shape.Circle"){
                    System.out.println("yo");
                }
                if ( contrl == temp){        //  making new enemies
                    enemy.set(90 , 110 , 1100 , 595);
                    temp=random.nextInt(10)+7;
                    root.getChildren().set(1 , enemy.getRectangle());
                    contrl=0;
                }

                try{

                    playground.movePlayground(root);
                    enemy.moverectangle();

                    if(enemy.getCenterX() == 32 ){                  // for player hp
                        hp-=1; //decrease one hp
                        System.out.println(" -1 hp ");
                        if (hp == 0) {              // when your hp reach to 0
                            System.out.println("you died ");
                            root.getChildren().remove(0);


                            Alert alert = new Alert(  AlertType.INFORMATION);

                            alert.setHeaderText(null);      //the end of game when when you are died
                            alert.setContentText("Your life is over. you are dead :(");
                            alert.getButtonTypes().setAll(ButtonType.OK);
                            alert.showAndWait().ifPresent(response -> {
                                if(response == ButtonType.OK){
                                    stage.close();
                                }
                            });
                        }
                    }

                } catch (Exception InterruptedException){
                    System.out.println((InterruptedException.getMessage()));
                }
                if (Task != null) {
                    Task.cancel();
                }
//                Task = new MyTimerTask();
//                timer.schedule(Task, 10000);

            }
            if (e.getCode() == KeyCode.R){

                if (enemy.getCenterX() ==210) {         //for enemies attacking
                    System.out.println(" perfect you killed it  ");
                    root.getChildren().remove(1);
                    enemy.set(0 , 0 , 0 , 0);
                }
            }
        });


        stage.show();
    }

    private void recovery_timer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        end_time = first_time;
        barchasb_timer.setText("time = " + end_time);
        Task = new Timer_Task();
        timer.scheduleAtFixedRate(Task, 0, 100);

    }

    static class Timer_Task extends TimerTask {
        @Override
        public void run() {
            Platform.runLater( () -> {
                if (end_time > 0) {
                    end_time--;
                    barchasb_timer.setText("time = " + end_time);
                } else if (end_time == 0) {
                    end_time = -1;
                    my_stage.close ();


                }

            });
        }
    }


}
