package ru.terra.l3db.shared.entity;

/**
 * Date: 15.06.15
 * Time: 10:50
 */
public interface Browser {
    public void go2page(String page);

    public void input2txtBox(String boxPath, String text);

    public void pressSubmit(String submitXpath, String text);

    public String getData(String... args);
}
