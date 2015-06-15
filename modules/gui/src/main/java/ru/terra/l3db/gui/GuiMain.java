package ru.terra.l3db.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.terra.l3db.gui.parts.StageHelper;

/**
 * Date: 10.06.15
 * Time: 17:42
 */
public class GuiMain extends Application {
    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageHelper.openWindow("w_main.fxml", "Tester", true);
    }
}
