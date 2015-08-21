package ru.terra.l3db.gui.stages;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import ru.terra.l3db.gui.parts.AbstractUIController;
import ru.terra.l3db.shared.MainContext;
import ru.terra.l3db.shared.util.TextUtil;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private ExecutorService executor = Executors.newFixedThreadPool(5);

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
            MainContext.getInstance().setConfiguration(MainContext.getInstance().getFileManager().loadMainConfiguration(configFile));
    }

    public void showFullConfig(ActionEvent actionEvent) {
        executor.submit(() -> {
            try {
                ArrayList<HashMap<String, String>> fullConfig = MainContext.getInstance().loadL3DBFullConfig(tfCKT.getText());
                logger.debug("Received rows: " + fullConfig.size());
                for (HashMap<String, String> cfg : fullConfig)
                    for (String k : cfg.keySet())
                        logger.debug(k + " = " + cfg.get(k));
                if (fullConfig.size() > 0 && fullConfig.get(0).size() > 0) {
                    HashMap<String, String> cfg = fullConfig.get(0);
                    Platform.runLater(() -> {
                        tfPEName.setText(TextUtil.getNonEmptyString(cfg.get("PE")));
                        tfConfigPEInterface.setText(TextUtil.getNonEmptyString(cfg.get("PE Interface")));
                        tfConfigVRF.setText(TextUtil.getNonEmptyString(cfg.get("VRF")));
                        tfConfigPEIPAddress.setText(MainContext.getInstance().getPureIpAddress(TextUtil.getNonEmptyString(cfg.get("PE")))[0]);
                        tfConfigCEIPADDRESS.setText(TextUtil.getNonEmptyString(cfg.get("CE IPv4 Addr")));
                        tfConfigPEVLAN.setText(TextUtil.getNonEmptyString(cfg.get("PE")));
                        tfConfigCEVLAN.setText(TextUtil.getNonEmptyString(cfg.get("CE DLCI, VPI/VCI, VLAN")));
                        tfPTVRF.setText(TextUtil.getNonEmptyString(cfg.get("VRF")));
                        tfPTCEIPAddress.setText(TextUtil.getNonEmptyString(cfg.get("CE IPv4 Addr")));
                        tfPECheckPEInterface.setText(TextUtil.getNonEmptyString(cfg.get("PE Interface")));
                        tfPEChecCEIPAddress.setText(TextUtil.getNonEmptyString(cfg.get("CE IPv4 Addr")));
                        tfPEChecVRF.setText(TextUtil.getNonEmptyString(cfg.get("VRF")));
                        tfPEChecAS.setText(TextUtil.getNonEmptyString(cfg.get("AS#")));
                    });
                }
            } catch (Exception e) {
                logger.error("Unable to serialize l3db full config", e);
            }
//            Platform.runLater(() -> parseL3DBConfig(fullConfig));
        });
    }

    public void sendEmail(ActionEvent actionEvent) {

    }

    public void configurationSavePreConfig(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("L3DB tester Configuration", "*.l3db"));
        fileChooser.setTitle("Save tester configuration file");
        final File configFile = fileChooser.showSaveDialog(currStage);
        if (configFile != null)
            MainContext.getInstance().getFileManager().saveMainConfiguration(MainContext.getInstance().getConfiguration(), configFile);
    }

    public void simplePingTest(ActionEvent actionEvent) {
        MainContext.getInstance().simplePingTest(tfPTVRF.getText(), tfPTCEIPAddress.getText(), tfPTPacketQTY.getText());
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

    public void testLogin(ActionEvent actionEvent) {
//        new Thread(() -> {
//            browser = MainContext.getInstance().getBrowserManager().createBrowser(configuration);
//            browser.login();
//        }).start();
    }

    public void parseL3DBConfig(String[][] config) {

    }
}
