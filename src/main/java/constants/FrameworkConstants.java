package constants;

import lombok.Getter;
import lombok.Setter;
import utils.PropertyReaderUtil;

import java.util.HashMap;

public class FrameworkConstants {

    private FrameworkConstants(){}

   static  {
        FrameworkConstants.setPropertyMap(PropertyReaderUtil.readPropertyFileAsMap(FrameworkConstants.getFrameworkPropertyFilePath()));
    }

    @Getter
    private static final String frameworkPropertyFilePath = "src/main/resources/ProjectDetails/ProjectDetails.properties";

    @Getter
    @Setter
    private static HashMap<String, String> propertyMap;

    public static String getProjectID(){
        return getPropertyMap().get("ProjectID");

    }
    public static String getProjectAPIKey(){
        return getPropertyMap().get("ProjectAPIKey");
    }
}
