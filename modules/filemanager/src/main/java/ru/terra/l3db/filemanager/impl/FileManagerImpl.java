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
    public Configuration loadMainConfiguration() {
        return null;
    }

    @Override
    public void saveMainConfiguration(Configuration configuration) {

    }

    @Override
    public PreconfTest requestPreconfTest() {
        return null;
    }

    @Override
    public void returnTestsAndDefaultDir(PreconfTest preconfTest, String defDir) {

    }

    @Override
    public String loadEmailTemplate(String path) {
        return null;
    }

    @Override
    public Configuration.L3DBConfiguration loadL3DBConfig(String path) {
        return null;
    }

    @Override
    public Configuration.PETroubleShootConfiguration loadPETConfiguration(String path) {
        return null;
    }
}
