package ru.yandex.praktikum.api;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateUser {
    private String email;
    private String password;
    private String name;
    final String URI_CREATE_USER = "/api/auth/register";

    public CreateUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public CreateUser() {} //конструктор без параметров


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //метод получения ответа на запрос регистрации пользователя
    public Response getCreateUserResponse(Object bodyCreateUser) {
        return given()
                .header("Content-Type", "application/json")
                .and()
                .body(bodyCreateUser)
                .when()
                .post(URI_CREATE_USER);
    }
}
