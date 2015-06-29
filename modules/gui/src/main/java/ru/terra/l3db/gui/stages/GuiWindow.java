package ru.terra.l3db.gui.stages;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import ru.terra.l3db.gui.parts.AbstractUIController;
import ru.terra.l3db.shared.MainContext;
import ru.terra.l3db.shared.entity.Configuration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Date: 13.06.15
 * Time: 17:20
 */
public class GuiWindow extends AbstractUIController {
    private Configuration configuration;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadConfig(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("L3DB tester Configuration", "*.l3db"));
        fileChooser.setTitle("Open tester configuration file");
        final File configFile = fileChooser.showOpenDialog(currStage);
        if (configFile != null)
            configuration = MainContext.getInstance().getFileManager().loadMainConfiguration(configFile);
    }

    public void showFullConfig(ActionEvent actionEvent) {

    }

    public void sendEmail(ActionEvent actionEvent) {

    }

    public void configurationSavePreConfig(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("L3DB tester Configuration", "*.l3db"));
        fileChooser.setTitle("Save tester configuration file");
        final File configFile = fileChooser.showSaveDialog(currStage);
        if (configFile != null)
            MainContext.getInstance().getFileManager().saveMainConfiguration(configuration, configFile);
    }

    public void simplePingTest(ActionEvent actionEvent) {

    }

    public void runPingTest(ActionEvent actionEvent) {

    }

    public void pingSavePreConfig(ActionEvent actionEvent) {

    }

    public void checkInputQ(ActionEvent actionEvent) {

    }

    public void checkArp(ActionEvent actionEvent) {

    }

    public void checkBGP(ActionEvent actionEvent) {

    }
}
