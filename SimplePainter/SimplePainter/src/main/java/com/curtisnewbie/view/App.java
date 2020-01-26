package com.curtisnewbie.view;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    public static final String INTRO = "\n---------------------\n\nWelcome Using Simple Painter (by CurtisNewbie/Yongjie Zhuang):\n\n - Width and Height are optional, default will be used if none provided.\n - Arrow_Up and Arrow_Down keys allow you to increase/decrease stroke width.\n - Primary mouse key is used to draw (black).\n - Secondary mouse key is used to erase.\n\n---------------------\n";
    public static Scanner sc = new Scanner(System.in);
    private double width = -1;
    private double height = -1;

    @Override
    public void init() throws Exception {
        super.init();

        System.out.println(INTRO);
        System.out.println("Specify the width of the canvas (optional):");
        var wid = sc.nextLine();

        System.out.println("Specify the height of the canvas (optional):");
        var hei = sc.nextLine();
        try {
            if (wid != null) {
                this.width = Double.parseDouble(wid);
                this.height = Double.parseDouble(hei);
            }
        } catch (NumberFormatException | NullPointerException e) {
            // use default width and height
            System.out.println("Using default width and height");
        }
    }

    @Override
    public void start(Stage priStage) throws Exception {

        PaintBoard c;
        if (this.width > 0 && this.height > 0)
            c = new PaintBoard(this.width, this.height);
        else
            c = new PaintBoard();

        Scene s = new Scene(new StackPane(c));
        s.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.UP))
                c.increStrokeWidth(e);
            if (e.getCode().equals(KeyCode.DOWN))
                c.decreStrokeWidth(e);
        });

        priStage.setScene(s);
        priStage.setTitle("Simple Painter");
        priStage.setResizable(false);
        priStage.show();
    }
}