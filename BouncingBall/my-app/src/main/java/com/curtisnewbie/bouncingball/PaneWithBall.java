package com.curtisnewbie.bouncingball;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class PaneWithBall extends Pane {

    /**
     * The default value of the radius.
     */
    public static final double DEFAULT_RADIUS = 20;

    /**
     * Default value of x and y coordinates of the ball, i.e., (20 , 20);
     */
    public static final double DEFAULT_POSITION = 20;

    /**
     * Radius of the ball
     */
    private double ballR;

    /**
     * Center x of the ball
     */
    private double ballX;

    /**
     * Center y of the ball
     */
    private double ballY;

    /**
     * X direction
     */
    private double direcX;

    /**
     * Y direction
     */
    private double direcY;

    /**
     * The ball
     */
    private Circle c;

    /**
     * Bouncing animation
     */
    private Animation animationOfBall;

    public PaneWithBall() {
        // create the default ball
        c = createDefaultBall();
        c.setFill(Color.RED);
        this.getChildren().add(c);

        // setup default ball's moving direction
        this.direcX = 1;
        this.direcY = 1;

        // assign bouncing animation to the ball
        animationOfBall = createBouncingAnimation();
        animationOfBall.play();
    }

    /**
     * Create a new Circle (ball) based on the preset default values.
     * 
     * @return the Circle (ball)
     */
    private Circle createDefaultBall() {
        // set the ball to the default positions
        this.ballX = DEFAULT_POSITION;
        this.ballY = DEFAULT_POSITION;

        // set the default radius of the ball
        this.ballR = DEFAULT_RADIUS;
        return new Circle(ballX, ballY, ballR);
    }

    private Timeline createBouncingAnimation() {
        EventHandler<ActionEvent> onFinished = (ActionEvent e) -> moveBall();
        KeyFrame kf = new KeyFrame(Duration.millis(50), onFinished);
        Timeline bounceAnimation = new Timeline(kf);
        bounceAnimation.setCycleCount(Timeline.INDEFINITE);
        return bounceAnimation;
    }

    /**
     * Detects weather it is hiting the wall, when it hits the wall change the
     * ball's moving direction to the oppisite direction.
     */
    private void moveBall() {

        // Change to oppisite directions when hitting boundaries
        if (ballX < ballR || ballX > this.getWidth() - ballR) {
            this.direcX *= -1;
        }

        if (ballY < ballR || ballY > this.getHeight() - ballR) {
            this.direcY *= -1;
        }

        // moving the ball
        ballX += direcX;
        ballY += direcY;
        c.setCenterX(ballX);
        c.setCenterY(ballY);
    }

    /**
     * Play the bouncing ball animation
     */
    public void play() {
        this.animationOfBall.play();
    }

    /**
     * Pause the bouncing ball animation
     */
    public void pause() {
        this.animationOfBall.pause();
    }

    /**
     * Check whether the animation is playing
     * 
     * @return
     * 
     *         whether the animation is playing
     * 
     */
    public boolean isPlaying() {
        var status = animationOfBall.getStatus();

        if (status == Animation.Status.RUNNING) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increase the speed(rate) of the bouncing animation by 0.1
     */
    public void increaseSpeed() {
        animationOfBall.setRate(animationOfBall.getRate() + 0.1);
    }

    /**
     * Decrease the speed(rate) of the bouncing animation by 0.1
     */
    public void decreaseSpeed() {
        animationOfBall.setRate(animationOfBall.getRate() - 0.1);
    }
}