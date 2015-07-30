package ru.terra.l3db.shared.entity;

/**
 * Date: 15.06.15
 * Time: 10:50
 */
public interface Browser {
    public void openPage(String page);

    public boolean login();

    public boolean pressSubmit(String submitXpath, String text);

    public boolean inputData(String boxPath, String text);

    public boolean chooseDropBoxElement(String xpath, String text);

    public boolean isExistDropBoxElement(String xpath, String text);

    public String getElementText(String xpath);

    public String[][] getElementTable(String xpath);

    public boolean isTextExists(String text);

    public void alertClickButton(boolean ok);
}
