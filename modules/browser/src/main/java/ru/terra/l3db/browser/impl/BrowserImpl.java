package ru.terra.l3db.browser.impl;

import ru.terra.l3db.shared.entity.Browser;

/**
 * Date: 15.06.15
 * Time: 10:52
 */
public class BrowserImpl implements Browser {


    @Override
    public void go2page(String page) {

    }

    @Override
    public void login(String user, String pass, String userXpath, String passXpath) {

    }

    @Override
    public void inputData(String boxPath, String text) {

    }

    @Override
    public void chooseDropBoxElement(String xpath, String text) {

    }

    @Override
    public boolean isExistDropBoxElement(String xpath, String text) {
        return false;
    }

    @Override
    public String getElementText(String xpath) {
        return null;
    }

    @Override
    public String[][] getElementTable(String xpath) {
        return new String[0][];
    }

    @Override
    public void pressSubmit(String submitXpath, String text) {

    }
}
