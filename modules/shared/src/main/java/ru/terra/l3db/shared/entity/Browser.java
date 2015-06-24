package ru.terra.l3db.shared.entity;

/**
 * Date: 15.06.15
 * Time: 10:50
 */
public interface Browser {
    public void go2page(String page);

    public void login(String user, String pass, String userXpath, String passXpath);

    public void pressSubmit(String submitXpath, String text);

    public void inputData(String boxPath, String text);

    public void chooseDropBoxElement(String xpath, String text);

    public boolean isExistDropBoxElement(String xpath, String text);

    public String getElementText(String xpath);

    public String[][] getElementTable(String xpath);
}
