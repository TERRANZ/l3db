package ru.terra.l3db.shared.entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Date: 15.06.15
 * Time: 10:50
 */
public interface Browser {
    public void openPage(String page);

    public boolean pressSubmit(String submitXpath, String text);

    public boolean inputData(String boxPath, String text);

    public boolean chooseDropBoxElement(String xpath, String text);

    public boolean isExistDropBoxElement(String xpath, String text);

    public String getElementText(String xpath);

    public ArrayList<HashMap<String, String>> getElementTable(String xpath);

    public boolean isTextExists(String text);

    public void alertClickButton(boolean ok);

    public boolean login();

    public ArrayList<HashMap<String, String>> loadL3DBConfig(String CKT);
}
