package ru.yandex.praktikum.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LoginUser {
    private String email;
    private String password;
    final String URI_LOGIN_USER = "/api/auth/login";

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginUser() {}

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

    //метод логина клиента в систему
    public Response getLoginUserResponse(Object bodyLoginUser) {
        return given()
                .header("Content-Type", "application/json")
                .and()
                .body(bodyLoginUser)
                .when()
                .post(URI_LOGIN_USER);
    }
}
