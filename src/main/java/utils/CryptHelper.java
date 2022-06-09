package utils;

import java.util.Base64;

public final class CryptHelper {

    private CryptHelper(){

    }

    public static String decodeData(String dataScource){
       return new String(Base64.getDecoder().decode(dataScource));
    }
}
