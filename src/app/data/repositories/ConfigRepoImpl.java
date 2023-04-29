package app.data.repositories;

import app.data.models.Config;
import app.data.storage.FileManagerImpl;
import app.data.storage.IFileManager;
import app.utils.Paths;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;

public class ConfigRepoImpl implements IConfigRepo {

    private final String filePath = Paths.CONFIG;
    private final IFileManager iFileManager;

    public ConfigRepoImpl() {
        this.iFileManager = new FileManagerImpl();
    }

    @Override
    public Config getConfigData() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        FileReader reader = this.iFileManager.read(this.filePath);
        return gson.fromJson(reader, Config.class);
    }

    @Override
    public void setConfigData(Config config) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonString = gson.toJson(config);
        this.iFileManager.write(this.filePath, jsonString);
    }
}
