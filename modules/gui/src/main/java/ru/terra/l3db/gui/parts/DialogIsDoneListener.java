package ru.terra.l3db.gui.parts;

/**
 * Date: 08.07.14
 * Time: 12:11
 */
public interface DialogIsDoneListener<T> {
    public void dialogIsDone(T ret, String... strings);

    public void cancel();
}
