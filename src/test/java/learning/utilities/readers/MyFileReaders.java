package learning.utilities.readers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import static learning.utilities.constants.APIKeys.API_KEYS;

public class MyFileReaders {
    private static final Logger LOGGER = LogManager.getLogger(MyFileReaders.class);

    public static void readApiKeysJSONFile() {
        try {
            String apiKeysJsonPath = System.getenv("API_KEYS_JSON_PATH");
            File file = new File(apiKeysJsonPath);
            FileReader fileReader = new FileReader(file);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            JSONObject jsonObject = new JSONObject(jsonTokener);

            for(String key: jsonObject.keySet()) {
                API_KEYS.put(key, jsonObject.getString(key));
            }
        } catch(FileNotFoundException fileNotFoundException) {
            LOGGER.error(Arrays.toString(fileNotFoundException.getStackTrace()));
        }
    }
}
