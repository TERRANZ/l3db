package ru.terra.l3db.gui.parts;

import javafx.event.ActionEvent;

/**
 * Date: 05.05.14
 * Time: 12:04
 */
public abstract class AbstractDialog<RetVal> extends AbstractUIController {
    protected DialogIsDoneListener<RetVal> dialogIsDoneListener;
    protected RetVal returnValue;

    public DialogIsDoneListener<RetVal> getDialogIsDoneListener() {
        return dialogIsDoneListener;
    }

    public void setDialogIsDoneListener(DialogIsDoneListener<RetVal> dialogIsDoneListener) {
        this.dialogIsDoneListener = dialogIsDoneListener;
    }

    public RetVal getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(RetVal returnValue) {
        this.returnValue = returnValue;
    }

    public abstract void ok(ActionEvent actionEvent);

    public void cancel(ActionEvent actionEvent) {
        currStage.close();
    }

    public abstract void loadExisting(RetVal value);

}
