package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This class will create a Map of key-value pairs used for constructing fields and payload and same canbe used for validations
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class PropertyReaderUtil {

    private PropertyReaderUtil(){

    }

    static HashMap<String, String> propertyFileData = new HashMap<>();

    public static HashMap<String, String> readPropertyFileAsMap(String filePathFromProjectRoot) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+filePathFromProjectRoot);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Map.Entry<Object, Object> entry : properties.entrySet()){
            propertyFileData.put((String) entry.getKey(), (String) entry.getValue());
        }
        return propertyFileData;
    }

}
