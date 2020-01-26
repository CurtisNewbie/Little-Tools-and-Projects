package com.curtisnewbie.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class PaintBoard extends Canvas {

    public static final int DEF_WID = 1024;
    public static final int DEF_HEI = 768;
    public static final int DEF_STROKE_WIDTH = 1;

    private int strokeWidth;

    public PaintBoard() {
        super();
        this.setHeight(DEF_HEI);
        this.setWidth(DEF_WID);
        this.strokeWidth = DEF_STROKE_WIDTH;

        this.setOnMouseDragged(e -> {
            if (e.isPrimaryButtonDown())
                drawToBlack(e.getSceneX(), e.getSceneY());
            else if (e.isSecondaryButtonDown())
                clear(e.getSceneX(), e.getSceneY());
        });
        this.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown())
                drawToBlack(e.getSceneX(), e.getSceneY());
            else if (e.isSecondaryButtonDown())
                clear(e.getSceneX(), e.getSceneY());
        });
    }

    public PaintBoard(double width, double height) {
        this();
        this.setHeight(height);
        this.setWidth(width);
    }

    private void drawToBlack(double x, double y) {
        var ctx = this.getGraphicsContext2D();
        ctx.setFill(Color.BLACK);
        var error = strokeWidth / 2;
        ctx.fillRect(x - error, y - error, strokeWidth, strokeWidth);
    }

    private void clear(double x, double y) {
        var ctx = this.getGraphicsContext2D();
        var error = strokeWidth / 2;
        ctx.clearRect(x - error, y - error, strokeWidth, strokeWidth);
    }

    public void increStrokeWidth(KeyEvent e) {
        if (strokeWidth < 1000) {
            if (strokeWidth < 30)
                strokeWidth++;
            else
                strokeWidth += 3;
            System.out.println("Increase stroke width. Width:" + strokeWidth);
        }
    }

    public void decreStrokeWidth(KeyEvent e) {
        if (strokeWidth > 1) {
            if (strokeWidth < 30)
                strokeWidth--;
            else
                strokeWidth -= 3;
            System.out.println("Decrease stroke width. Width:" + strokeWidth);
        }
    }

}