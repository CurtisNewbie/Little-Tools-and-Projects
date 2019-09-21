package com.curtisnewbie.clockwithjavafx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.shape.Line;
import javafx.event.*;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;

/**
 * A Pane with a defined "clock" in it.
 * 
 * By default, the width and height of clockPane are 250
 * 
 */
public class ClockPane extends Pane {

    /**
     * Default value of width and height of the ClockPane
     */
    private static final double DEFAULT_VALUE = 200;

    /**
     * Auto update the clock every second when it is set to true;
     */
    private boolean autoUpdate;

    /**
     * Width of the ClockPane
     */
    private double paneW;

    /**
     * Height of the ClockPane
     */
    private double paneH;

    /**
     * Hour
     */
    private int h;

    /**
     * Minute
     */
    private int m;

    /**
     * Second
     */
    private int s;

    /**
     * The Timeline animation for autoupdating the clock every second
     */
    private Timeline tl;

    /**
     * Initiate and paint the ClockPane based on the current time, Auto updating of
     * the clock (every second) is off by default.
     */
    public ClockPane() {
        this.paneW = DEFAULT_VALUE;
        this.paneH = DEFAULT_VALUE;
        this.autoUpdate = false;
        this.tl = null;
        this.secCurrentTime();
        this.paintClock();
    }

    /**
     * Initiate and paint the ClockPane based on the current time.
     */
    public ClockPane(boolean autoUpdate) {
        this.paneW = DEFAULT_VALUE;
        this.paneH = DEFAULT_VALUE;
        this.autoUpdate = autoUpdate;
        this.tl = null;
        this.secCurrentTime();
        this.paintClock();

        if (autoUpdate) {
            this.setUpAutoUpdate();
        }
    }

    /**
     * Initiate and paint the ClockPane based on the given time. Auto updating of
     * the clock (every second) is off by default.
     * 
     * @param h Hour
     * @param m Minute
     * @param s Second
     */
    public ClockPane(int h, int m, int s) {
        this.paneW = DEFAULT_VALUE;
        this.paneH = DEFAULT_VALUE;
        this.h = h;
        this.m = m;
        this.s = s;
        this.autoUpdate = false;
        this.paintClock();
    }

    /**
     * Set the time to the current time
     */
    private void secCurrentTime() {
        GregorianCalendar cal = new GregorianCalendar();
        this.h = cal.get(Calendar.HOUR_OF_DAY);
        this.m = cal.get(Calendar.MINUTE);
        this.s = cal.get(Calendar.SECOND);
    }

    /**
     * Paint the clock.
     */
    private void paintClock() {

        // radius, center x and y
        double r = Math.min(paneW, paneH) * 0.9 * 0.5;
        double centerX = paneW / 2;
        double centerY = paneH / 2;

        // the circle
        Circle c = new Circle(centerX, centerY, r);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);

        // the text on the clock (12, 9, 3, 6)
        Text t12 = new Text(centerX - 5, centerY - r + 12, "12");
        Text t9 = new Text(centerX - r + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + r - 10, centerY + 3, "3");
        Text t6 = new Text(centerX - 3, centerY + r - 3, "6");

        // the second hand
        double sLen = r * 0.8;
        double sLineEndX = centerX + sLen * Math.sin(this.s * (2 * Math.PI / 60));
        double sLineEndY = centerY - sLen * Math.cos(this.s * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, sLineEndX, sLineEndY);
        sLine.setStroke(Color.BLACK);

        // the min hand
        double mLen = r * 0.7;
        double mLineEndX = centerX + mLen * Math.sin(this.m * (2 * Math.PI / 60));
        double mLineEndY = centerY - mLen * Math.cos(this.m * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, mLineEndX, mLineEndY);
        mLine.setStroke(Color.BLACK);

        // the hour hand
        double hLen = r * 0.3;
        double hLineEndX = centerX + hLen * Math.sin((this.h % 12 + this.m / 60.0) * (2 * Math.PI / 12));
        double hLineEndY = centerY - hLen * Math.cos((this.h % 12 + this.m / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hLineEndX, hLineEndY);
        hLine.setStroke(Color.BLACK);
        hLine.setStrokeWidth(1.5);

        // remove and then add all (in order to repaint the clock)
        this.getChildren().clear();
        this.getChildren().addAll(c, t12, t9, t3, t6, sLine, mLine, hLine);
    }

    /**
     * Add EventHandler for auto updating the clock. If there is already an
     * EventHandler registered, this method will start the Timeline animation.
     */
    public void setUpAutoUpdate() {

        if (tl == null) {

            EventHandler<ActionEvent> onFinished = (ActionEvent e) -> {
                this.secCurrentTime();
                this.paintClock();
            };

            tl = new Timeline(new KeyFrame(Duration.millis(1000), onFinished));
            tl.setCycleCount(Timeline.INDEFINITE);
        }

        tl.play();
    }

    /**
     * stop pause the animation for autoupdating the clock
     */
    public void removeAutoUpdate() {
        this.tl.pause();
    }

    public int getH() {
        return this.h;
    }

    public int getM() {
        return this.m;
    }

    public int getS() {
        return this.s;
    }

    public double getPaneW() {
        return this.paneW;
    }

    public double getPaneH() {
        return this.paneH;
    }

    /**
     * @param h hour
     */
    public void setH(int h) {
        this.h = h;
        this.paintClock();
    }

    /**
     * @param m minute
     */
    public void setM(int m) {
        this.m = m;
        this.paintClock();
    }

    /**
     * @param s second
     */
    public void setS(int s) {
        this.s = s;
        this.paintClock();
    }

    /**
     * @param w width of the clockPane
     */
    public void setPaneW(double w) {
        this.paneW = w;
        this.paintClock();
    }

    /**
     * @param h height of the clockPane
     */
    public void setPaneH(double h) {
        this.paneH = h;
        this.paintClock();
    }

    /**
     * set the autoupdating of the clock to true or false and change the start or
     * stop the autoupdating functionality.
     * 
     * @param b autoupdating status
     */
    public void setAutoUpdate(boolean b) {
        if (this.autoUpdate != b) {
            this.autoUpdate = b;
            if (autoUpdate) {
                this.setUpAutoUpdate();
            } else {
                this.removeAutoUpdate();
            }
        }
    }
}
