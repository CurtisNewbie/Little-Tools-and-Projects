package com.curtisnewbie.bouncingball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class BouncingBall extends Application {

    @Override
    public void start(Stage priStage) {

        var ballPane = new PaneWithBall();
        var scene = new Scene(ballPane, 500, 500);

        // setup controls of the animation
        scene.setOnKeyPressed((KeyEvent e) -> {
            var c = e.getCode();
            if (c == KeyCode.UP) {
                System.out.println("Faster!");
                ballPane.increaseSpeed();
            } else if (c == KeyCode.DOWN) {
                System.out.println("Slower!");
                ballPane.decreaseSpeed();
            } else if (c == KeyCode.SPACE) {
                if (ballPane.isPlaying()) {
                    System.out.println("Stop!");
                    ballPane.pause();
                } else {
                    System.out.println("Play!");
                    ballPane.play();
                }
            }
        });

        priStage.setScene(scene);
        priStage.setTitle("Bouncing Ball");
        priStage.show();
    }
}