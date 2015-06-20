package ru.terra.l3db.filemanager.impl;

import ru.terra.l3db.shared.entity.Configuration;
import ru.terra.l3db.shared.entity.PreconfTest;
import ru.terra.l3db.shared.parts.FileManager;

/**
 * Date: 15.06.15
 * Time: 10:53
 */
public class FileManagerImpl implements FileManager {
    @Override
    public Configuration requestConfiguration() {
        return null;
    }

    @Override
    public void returnConfiguration(Configuration configuration) {

    }

    @Override
    public PreconfTest requestPreconfTest() {
        return null;
    }

    @Override
    public void returnTestsAndDefaultDir(PreconfTest preconfTest, String defDir) {

    }
}
