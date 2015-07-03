package ru.terra.l3db.gui.stages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    @FXML
    public Label lblVersion;
    @FXML
    public TextField tfCKT;
    @FXML
    public TextField tfPEName;
    @FXML
    public TextField tfConfigPEInterface;
    @FXML
    public TextField tfConfigVRF;
    @FXML
    public TextField tfConfigPEIPAddress;
    @FXML
    public TextField tfConfigPEVLAN;
    @FXML
    public TextField tfConfigCEIPADDRESS;
    @FXML
    public TextField tfConfigCEVLAN;
    @FXML
    public TextField tfPTCEIPAddress;
    @FXML
    public TextField tfPTPacketSize;
    @FXML
    public TextField tfPTPacketQTY;
    @FXML
    public TextField tfPTPEType;
    @FXML
    public TextField tfPTVRF;
    @FXML
    public TextField tfPTPattern;
    @FXML
    public TextField tfPTTOS;
    @FXML
    public TextField tfPECheckPEInterface;
    @FXML
    public TextField tfPEChecCEIPAddress;
    @FXML
    public TextField tfPEChecVRF;
    @FXML
    public TextField tfPEChecAS;
    private Configuration configuration;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblVersion.setText("Version: " + MainContext.getInstance().getVersion());
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
