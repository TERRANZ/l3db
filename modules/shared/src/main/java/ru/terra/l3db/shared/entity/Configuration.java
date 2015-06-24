package ru.terra.l3db.shared.entity;

/**
 * Date: 15.06.15
 * Time: 10:46
 */
public class Configuration {
    public class BrowserConfiguration {
        public String loginAddress, loginHeader, loginXpath, passwordXpath;
        public String goButtonXpath;
        public String loginSuccessAddress, loginSuccessHeader, loginSuccessTextXPath;
        public String login, password;
    }

    public class L3DBConfiguration {
        public String L3DBAddress, L3DBHeader, CKTInputXpath, SearchButtonXpath, DataTableXpath, DataTableHeaderXPath, DataTableInfoXPath, ListOfColumns, ColumnsQty;
    }

    public class PETroubleShootConfiguration {
    }

}
