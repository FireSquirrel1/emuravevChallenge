package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static constans.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.gen5.api.Assertions.assertEquals;

public class ApiTests {
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final Date date = new Date();

    @Test
    public void testGetUsers() {
        Response response =
                given().log().uri()
                        .get(GET_PEOPLE_URL)
                        .then().extract().response();

        JsonPath body = response.getBody().jsonPath();
        List<String> usersEmails = body.getList("data.email");

        assertEquals(usersEmails.size(),6);
        System.out.println("YES 6 USERS");
    }

    @Test
    public void testFindUsers(){
        given().log().uri()
                .get(GET_PEOPLE_URL)
                .then().assertThat().body("data.email", hasItems("george.bluth@reqres.in","emma.wong@reqres.in"));
        System.out.println("USERS FIND");
    }

    @Test
    public void testRegisterNewUser(){
        Response response = given().log().uri()
                .contentType("application/json").body(USER_JSON)
                .when().post(POST_CREATE_USER_URL)
                .then().log().body().extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201);
        System.out.println("USER CREATED IS " + dateFormat.format(date));
    }
}
