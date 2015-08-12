package ru.terra.l3db.shared;

import ru.terra.l3db.shared.entity.PETroubleshoot;
import ru.terra.l3db.shared.entity.config.Configuration;
import ru.terra.l3db.shared.exception.L3DBException;
import ru.terra.l3db.shared.parts.BrowserManager;
import ru.terra.l3db.shared.parts.FileManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Date: 15.06.15
 * Time: 10:31
 */
public class MainContext {
    private static MainContext instance = new MainContext();
    private FileManager fileManager;
    private BrowserManager browserManager;
    private Configuration configuration;
    private PETroubleshoot peTroubleshoot;

    private MainContext() {
    }

    public static MainContext getInstance() {
        return instance;
    }

    public void init(BrowserManager browserManager, FileManager fileManager, PETroubleshoot peTroubleshoot) throws L3DBException {
        this.browserManager = browserManager;
        this.fileManager = fileManager;
        this.peTroubleshoot = peTroubleshoot;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public BrowserManager getBrowserManager() {
        return browserManager;
    }

    public String getVersion() {
        String result = "";
        Properties prop = new Properties();
        String propFileName = "version.properties";

        InputStream inputStream = MainContext.class.getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result = prop.getProperty("version");
        return result;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void setBrowserManager(BrowserManager browserManager) {
        this.browserManager = browserManager;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public PETroubleshoot getPeTroubleshoot() {
        return peTroubleshoot;
    }

    public void setPeTroubleshoot(PETroubleshoot peTroubleshoot) {
        this.peTroubleshoot = peTroubleshoot;
    }


    public ArrayList<HashMap<String, String>> loadL3DBFullConfig(String CKT) {
        browserManager.setConfiguration(configuration);
        browserManager.createBrowser().login();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return browserManager.getBrowser().loadL3DBConfig(CKT);
    }

    public boolean runTest(String NetSelectOptionName, String PE_Name) {
        peTroubleshoot.setConfiguration(configuration);
        return true;
    }
}
