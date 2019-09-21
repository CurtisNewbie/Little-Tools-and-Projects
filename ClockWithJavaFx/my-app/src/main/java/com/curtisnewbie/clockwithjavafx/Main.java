package com.curtisnewbie.clockwithjavafx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

    @Override
    public void start(Stage priStage) {

        ClockPane cpane = new ClockPane();
        cpane.setAutoUpdate(true);
        Scene s = new Scene(cpane, 200, 200);
        priStage.setScene(s);
        priStage.setTitle("Clock");
        priStage.show();
    }
}
