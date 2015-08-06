package ru.terra.l3db.shared.entity;

import ru.terra.l3db.shared.entity.config.Configuration;

/**
 * Date: 06.08.15
 * Time: 16:46
 */
public abstract class Configurable {
    protected Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
