package ru.terra.l3db.shared.parts;

import ru.terra.l3db.shared.entity.Browser;
import ru.terra.l3db.shared.entity.BrowserConfiguration;

/**
 * Date: 15.06.15
 * Time: 10:40
 */
public interface BrowserManager {
    public Browser createBrowser(BrowserConfiguration configuration);
}
