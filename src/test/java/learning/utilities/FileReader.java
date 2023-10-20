package learning.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fileInputStream = null;
        Properties properties = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(fileInputStream);

        // FileNotFoundException will be raised if the file is not found
        // As FileNotFoundException is a child class of IOException, we can catch IOException

        } catch(IOException ioException) {
            ioException.printStackTrace();
        } finally {
            assert fileInputStream != null;
            fileInputStream.close();
        }
        return properties;
    }
}

