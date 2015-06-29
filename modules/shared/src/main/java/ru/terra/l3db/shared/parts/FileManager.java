package ru.terra.l3db.shared.parts;

import ru.terra.l3db.shared.entity.Configuration;
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

    public Configuration.L3DBConfiguration loadL3DBConfig(String path);

    public Configuration.PETroubleShootConfiguration loadPETConfiguration(String path);
}
