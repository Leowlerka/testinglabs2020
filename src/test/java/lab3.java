import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class lab3 {
    private static String URL = "https://api.nasa.gov/planetary/apod?";
    private static String apiKey = "PDbzOotTMfudI6b5UWogoF2wnSYpXqihSHFotWNe";

    @BeforeClass
    public static void setupRestAssured() {
        RestAssured.requestSpecification = new RequestSpecBuilder().setAccept(ContentType.JSON).
                setBaseUri(URL).build();
    }

    @Test
    public void getApod() {
        given().param("api_key", apiKey).get().then().statusCode(200).assertThat().
                body("copyright", equalTo("Lionel Majzik"));

    }

    @Test
    public void getApodByData() {
        given().param("date", "1999-07-24").param("api_key", apiKey).get().then().
                statusCode(200).assertThat().body("title", equalTo("Infrared Saturn"));

    }
}
