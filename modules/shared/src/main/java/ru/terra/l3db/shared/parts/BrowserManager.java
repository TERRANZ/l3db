package ru.terra.l3db.shared.parts;

import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.entity.Configurable;

/**
 * Date: 15.06.15
 * Time: 10:40
 */
public abstract class BrowserManager extends Configurable {
    protected Browser browser;

    public abstract Browser createBrowser();

    public Browser getBrowser() {
        return browser != null ? browser : createBrowser();
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }
}
