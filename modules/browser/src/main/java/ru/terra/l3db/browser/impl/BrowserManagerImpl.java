package ru.terra.l3db.browser.impl;

import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.entity.Configuration;
import ru.terra.l3db.shared.parts.BrowserManager;

/**
 * Date: 15.06.15
 * Time: 10:52
 */
public class BrowserManagerImpl implements BrowserManager {
    @Override
    public Browser createBrowser(Configuration configuration) {
        return new BrowserImpl(configuration);
    }
}
