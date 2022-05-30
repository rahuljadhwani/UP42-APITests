package constants;

import lombok.Getter;
import lombok.Setter;
import utils.PropertyReaderUtil;
import java.util.HashMap;


/**
 * This class contains Framework Constants and default data map accumulated by reading Property files
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class FrameworkConstants {

    /**
     * Constructor is made private to prevent object-creation of this class, as this class contains all static methods.
     */
    private FrameworkConstants(){}

   static  {
        FrameworkConstants.setPropertyMap(PropertyReaderUtil.readPropertyFileAsMap(FrameworkConstants.getFrameworkPropertyFilePath()));
        FrameworkConstants.setPropertyMap(PropertyReaderUtil.readPropertyFileAsMap(FrameworkConstants.getInvalidDateFilePath()));
    }


    @Getter
    private static final String frameworkPropertyFilePath = "src/main/resources/ProjectDetails/ProjectDetails.properties";

    @Getter
    private static final String invalidDateFilePath = "src/main/resources/GenericData/InvalidData.properties";

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
