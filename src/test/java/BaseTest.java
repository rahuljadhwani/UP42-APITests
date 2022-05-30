import constants.FrameworkConstants;
import org.testng.annotations.AfterTest;
import utils.PropertyReaderUtil;

public class BaseTest {

    @AfterTest
    public void cleanUp(){
        FrameworkConstants.setPropertyMap(null);
    }


}
