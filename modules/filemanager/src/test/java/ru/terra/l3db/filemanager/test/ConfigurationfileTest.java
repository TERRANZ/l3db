package ru.terra.l3db.filemanager.test;

import junit.framework.TestCase;
import ru.terra.l3db.filemanager.impl.FileManagerImpl;
import ru.terra.l3db.shared.entity.BrowserConfiguration;
import ru.terra.l3db.shared.entity.Configuration;
import ru.terra.l3db.shared.entity.L3DBConfiguration;

import java.io.File;

/**
 * Date: 21.07.15
 * Time: 20:33
 */
public class ConfigurationfileTest extends TestCase {
    public ConfigurationfileTest() {
        super("ConfigurationfileTest");
    }

    public void testConfig() throws Exception {
        Configuration configuration = new Configuration();
        BrowserConfiguration browserConfiguration = new BrowserConfiguration();
        browserConfiguration.loginAddress = "loginaddress";
        browserConfiguration.loginHeader = "loginHeader";
        browserConfiguration.loginXpath = "loginXpath";
        browserConfiguration.passwordXpath = "passwordXpath";
        browserConfiguration.goButtonXpath = "goButtonXpath";
        browserConfiguration.loginSuccessAddress = "loginSuccessAddress";
        browserConfiguration.loginSuccessHeader = "loginSuccessHeader";
        browserConfiguration.loginSuccessTextXPath = "loginSuccessTextXPath";
        browserConfiguration.login = "login";
        browserConfiguration.password = "password";
        configuration.browserConfiguration = browserConfiguration;
        L3DBConfiguration l3DBConfiguration = new L3DBConfiguration();
        l3DBConfiguration.L3DBAddress = "L3DBAddress =";
        l3DBConfiguration.L3DBHeader = "L3DBHeader";
        l3DBConfiguration.CKTInputXpath = "CKTInputXpath";
        l3DBConfiguration.SearchButtonXpath = "SearchButtonXpath";
        l3DBConfiguration.DataTableXpath = "DataTableXpath";
        l3DBConfiguration.DataTableHeaderXPath = "DataTableHeaderXPath";
        l3DBConfiguration.DataTableInfoXPath = "DataTableInfoXPath";
        l3DBConfiguration.ListOfColumns = "ListOfColumns";
        l3DBConfiguration.ColumnsQty = "ColumnsQty";


        new FileManagerImpl().saveMainConfiguration(configuration, new File("test.l3db"));
    }
}
