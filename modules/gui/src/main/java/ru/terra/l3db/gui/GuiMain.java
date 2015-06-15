package ru.terra.l3db.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.terra.l3db.gui.parts.StageHelper;
import ru.terra.l3db.gui.stages.GuiWindow;

/**
 * Date: 10.06.15
 * Time: 17:42
 */
public class GuiMain extends Application {
    private static GuiWindow guiWindow;

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        guiWindow = StageHelper.<GuiWindow>openWindow("w_main.fxml", "Tester", true).getValue();
    }

    public static GuiWindow getGuiWindow() {
        return guiWindow;
    }
}
