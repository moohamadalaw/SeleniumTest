package base;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBase {

    protected String baseUrl = "https://thinking-tester-contact-list.herokuapp.com";

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = baseUrl;
    }


}
