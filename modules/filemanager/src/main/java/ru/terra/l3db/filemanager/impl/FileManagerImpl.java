package ru.terra.l3db.filemanager.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.l3db.shared.entity.L3DBConfiguration;
import ru.terra.l3db.shared.entity.config.Configuration;
import ru.terra.l3db.shared.parts.FileManager;

import java.io.File;
import java.io.IOException;

/**
 * Date: 15.06.15
 * Time: 10:53
 */
public class FileManagerImpl implements FileManager {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Configuration loadMainConfiguration(File configurationFile) {
        Configuration configuration = null;
        try {
            configuration = new ObjectMapper().readValue(configurationFile, Configuration.class);
        } catch (IOException e) {
            logger.error("Unable to read configuration from file", e);
        }
        return configuration;
    }

    @Override
    public void saveMainConfiguration(Configuration configuration, File targetFile) {
        try {
            new ObjectMapper().writeValue(targetFile, configuration);
        } catch (IOException e) {
            logger.error("Unable to write configuration to file", e);
        }
    }

    @Override
    public String loadEmailTemplate(String path) {
        return null;
    }

    @Override
    public L3DBConfiguration loadL3DBConfig(String path) {
        return null;
    }

//    @Override
//    public Configuration.PETroubleShootConfiguration loadPETConfiguration(String path) {
//        return null;
//    }
}
