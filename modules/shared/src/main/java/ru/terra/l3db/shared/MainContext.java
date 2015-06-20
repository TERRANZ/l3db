package ru.terra.l3db.shared;

import ru.terra.l3db.shared.exception.L3DBException;
import ru.terra.l3db.shared.parts.BrowserManager;
import ru.terra.l3db.shared.parts.FileManager;

/**
 * Date: 15.06.15
 * Time: 10:31
 */
public class MainContext {
    private static MainContext instance = new MainContext();
    private FileManager fileManager;
    private BrowserManager browserManager;

    private MainContext() {
    }

    public static MainContext getInstance() {
        return instance;
    }

    public void init() throws L3DBException {
    }

    public void gotoL3_DB_Page(String page) {
    }

    public void inputCKT_ID(String id) {
    }

    public void pressSubmit() {
    }

    public void requestInfo(String... args) {
    }
}
