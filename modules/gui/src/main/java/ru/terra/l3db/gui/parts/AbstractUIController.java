package ru.terra.l3db.gui.parts;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date: 07.05.14
 * Time: 17:22
 */
public abstract class AbstractUIController implements Initializable {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Stage currStage;

    public static void showErrorDialog(final String title, final String message, final Stage stage, final Throwable e) {
        Platform.runLater(() -> Dialogs.create().title(title).owner(stage).masthead(message).showException(e));
    }

    public Stage getCurrStage() {
        return currStage;
    }

    public void setCurrStage(Stage currStage) {
        this.currStage = currStage;
    }


    public void createProgressDialog(final Service<?> service, boolean indeterminate) {
        Dialogs.create().actions(Dialog.ACTION_CANCEL).owner(currStage).showWorkerProgress(service);
    }

}
