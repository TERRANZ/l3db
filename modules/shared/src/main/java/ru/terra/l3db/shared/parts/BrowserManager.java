package ru.terra.l3db.shared.parts;

import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.entity.Configuration;

/**
 * Date: 15.06.15
 * Time: 10:40
 */
public abstract class BrowserManager {
    protected Browser browser;

    public abstract Browser createBrowser(Configuration configuration);

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
}
