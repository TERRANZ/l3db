package ru.terra.l3db;

import ru.terra.l3db.browser.impl.BrowserManagerImpl;
import ru.terra.l3db.filemanager.impl.FileManagerImpl;
import ru.terra.l3db.petroubleshoot.PETesterImpl;
import ru.terra.l3db.shared.MainContext;
import ru.terra.l3db.shared.exception.L3DBException;

/**
 * Date: 15.06.15
 * Time: 10:35
 */
public class Main {
    public static void main(String... args) throws L3DBException {
        MainContext.getInstance().init(new BrowserManagerImpl(), new FileManagerImpl(), new PETesterImpl());
        new L3DBMain().start(args);
    }
}
