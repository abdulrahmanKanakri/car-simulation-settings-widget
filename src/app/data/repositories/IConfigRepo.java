package app.data.repositories;

import app.data.models.Config;

public interface IConfigRepo {
    Config getConfigData();
    void setConfigData(Config config);
}
