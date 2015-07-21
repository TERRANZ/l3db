package ru.terra.l3db;

import ru.terra.l3db.browser.impl.BrowserManagerImpl;
import ru.terra.l3db.filemanager.impl.FileManagerImpl;
import ru.terra.l3db.shared.MainContext;

/**
 * Date: 15.06.15
 * Time: 10:35
 */
public class Main {
    public static void main(String... args) {
        MainContext.getInstance().setBrowserManager(new BrowserManagerImpl());
        MainContext.getInstance().setFileManager(new FileManagerImpl());
        new L3DBMain().start(args);
    }
}
