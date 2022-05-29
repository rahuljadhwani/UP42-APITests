package services;

import org.testng.annotations.Test;
import pojo.requests.FetchAccessTokenRequestPojo;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class FetchAccessToken {

    //POST for fetching access token and logic to verify its validity

    FetchAccessTokenRequestPojo fetchAccessTokenRequestPojo = new FetchAccessTokenRequestPojo();
    Map<String, Object> requestMap = new LinkedHashMap<>();

    public void fetchAccessToken(){
//        fetchAccessTokenRequestPojo.setGrantType("client_credentials");
//        given().auth().none().contentType("application/x-www-form-urlencoded").body(fetchAccessTokenRequestPojo).log().all().post("https://92f9eed8-4c66-4a90-9979-364a7d818bcd:3xkmBqUZ.0v1AjwQ4JFYvgrI9KXrUgnCVikQYTGkWRh9@api.up42.com/oauth/token")
//                .then().log().all();
//        given().auth().oauth2("eyJ0eXAiOiJKV1QiLCJraWQiOiIxIiwidG9rZW5fdHlwZSI6IkFDQ0VTUyIsImFsZyI6IlJTNTEyIn0.eyJpc3MiOiJiYWNrZW5kLWNvcmUiLCJqdGkiOiJiNGQ0YTczZi0zNGIyLTQ2ZjAtOGEwNy1hNmIzZDU5NDk0MzUiLCJpYXQiOjE2NTM3NDc0NzcsInN1YiI6IjkyZjllZWQ4LTRjNjYtNGE5MC05OTc5LTM2NGE3ZDgxOGJjZCIsImF1ZCI6ImFwaS51cDQyLmNvbSIsImV4cCI6MTY1Mzc0Nzc3NywiYXV0aG9yaXRpZXMiOlsiVklFV19QUk9KRUNUIiwiUlVOX0pPQiJdLCJjbGllbnRfaWQiOiI5MmY5ZWVkOC00YzY2LTRhOTAtOTk3OS0zNjRhN2Q4MThiY2QiLCJjbGllbnRfdHlwZSI6IkFQSV9LRVkiLCJhY2NvdW50X2lkIjoiOTkxOGU3ZGItODg3Yi00ZTBlLWE3ODUtZDcwYWI0Yjg5ZjI1In0.Kf2F4ML5y90Ozr1aEFsUqJYPkBaIz6XxRJDewsUpl5nZKeDJaOrgIDO_wsU59vua536QK_Se9hPlcKmpw6DYIcGghmdP6tOZrhwLTwzK-a6zkRSLROjilS0Mg5vUOJi3ZPQExY2jTK6lFwAEzzw3c7JBo-NBc-c91Lxgahx6t0snRQZXQx3KCY4_4TR7XXLZJizEIXvkfiTrGHDrrKgh6OjoxV3okY6paPc1WLf-cjLpaneiSgGH8lBUjkvyYnnSDlE5jEiOUKifRXE-LXZ0incNZkEIXobo7xYtOAbAC6xsbjbbF8a-X03yED4yHvzOfN4AGAEpbfNaOXhd_F5TrHY2Fsm89qjj6z2wBy03LU3j9b0oXQcPO8Ey_3rbN1O5dqCy5yENEMttlDVtDXVFEZMp167wBhOgIUtWOwHwEpl-BNBH8bsf6c3V5xsHzpWanDVZjD_FIWHx7VfV5WpnBn6pmUeqqgzVmEkt6SgJbvnhJolsNe0tMwsy7DJzaW0HbAPXV6sMe-7ApVOwWnqfamJf3_4udnaGzIjgX5Obrm1598Td7OnMBRmczpbDnyazJHK7q47b_4CCbxJUwxn_mXNfU7nLeX_vmF6lfZqntXDFl679GemWOgmCYQ6Z5_NFR4fsSf-Sk7PRBSRFX2cNAfxrZE1H9-1V_f4-Y9r3Tm0")
//                .log().all().when().get("https://api.up42.com/projects/92f9eed8-4c66-4a90-9979-364a7d818bcd/jobs/6c9ad5d8-cb4e-4f61-a132-35f0a2c362ed").getBody().prettyPrint();
    }


}
