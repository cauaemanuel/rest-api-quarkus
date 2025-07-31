package arg.acme.controller;

import arg.acme.controller.dto.CreateUserRequestDto;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {


    @Test
    @DisplayName("Should create an user successfully")
    @Order(1)
    public void createUserTest() {

        var user = new CreateUserRequestDto("John Doe", 18);
        var response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user/criar")
                .then().extract().response();

        assertEquals(201, response.statusCode());
        assertNotNull(response.jsonPath());
    }


    @Test
    @DisplayName("should list all users")
    @Order(2)
    public void listAllUsersTest(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/user")
                .then()
                .statusCode(200)
                .body("size()", Matchers.is(1));
    }
}