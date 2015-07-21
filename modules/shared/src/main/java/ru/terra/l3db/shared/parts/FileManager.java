package ru.terra.l3db.shared.parts;

import ru.terra.l3db.shared.entity.Configuration;
import ru.terra.l3db.shared.entity.L3DBConfiguration;
import ru.terra.l3db.shared.entity.PreconfTest;

import java.io.File;

/**
 * Date: 15.06.15
 * Time: 10:34
 */
public interface FileManager {
    public Configuration loadMainConfiguration(File configurationFile);

    public void saveMainConfiguration(Configuration configuration, File targetFile);

    public PreconfTest requestPreconfTest();

    public void returnTestsAndDefaultDir(PreconfTest preconfTest, String defDir);

    public String loadEmailTemplate(String path);

    public L3DBConfiguration loadL3DBConfig(String path);

//    public PETroubleShootConfiguration loadPETConfiguration(String path);
}
