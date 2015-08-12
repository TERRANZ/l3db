package test;

import junit.framework.TestCase;
import ru.terra.l3db.browser.impl.BrowserManagerImpl;
import ru.terra.l3db.filemanager.impl.FileManagerImpl;
import ru.terra.l3db.petroubleshoot.PETesterImpl;
import ru.terra.l3db.shared.MainContext;
import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.exception.L3DBException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Date: 12.08.15
 * Time: 12:49
 */
public class BrowserImplTest extends TestCase {

    public BrowserImplTest() throws L3DBException {
        super("BrowserImplTest");
        MainContext.getInstance().init(new BrowserManagerImpl(), new FileManagerImpl(), new PETesterImpl());
    }

    public void testReadTable() throws Exception {
        Browser browser = MainContext.getInstance().getBrowserManager().getBrowser();
        browser.openPage("file:////home/terranz/projects/freelance/l3db/modules/l3db/l3db_bare_table.htm");
        ArrayList<HashMap<String, String>> table = browser.getElementTable("//*[@id=\"DataTable\"]");
    }
}
