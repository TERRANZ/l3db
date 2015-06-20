package ru.terra.l3db.shared.parts;

import ru.terra.l3db.shared.entity.Configuration;
import ru.terra.l3db.shared.entity.PreconfTest;

/**
 * Date: 15.06.15
 * Time: 10:34
 */
public interface FileManager {
    public Configuration requestConfiguration();

    public void returnConfiguration(Configuration configuration);

    public PreconfTest requestPreconfTest();

    public void returnTestsAndDefaultDir(PreconfTest preconfTest, String defDir);
}
