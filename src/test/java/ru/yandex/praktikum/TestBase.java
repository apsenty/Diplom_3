package ru.yandex.praktikum;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.api.CreateUser;
import ru.yandex.praktikum.api.CreateUserResponse;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class TestBase {
    protected WebDriver driver;

    protected final String email = "olgaleto@yandex.ru";
    protected final String password = "qaws1234";
    protected final String name = "Apsenty";
    protected String userAccessToken;
    protected final String URI_DELETE_USER = "/api/auth/user";

    protected final String URL_MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    protected final String URL_LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    protected final String URL_REGISTRATION_PAGE = "https://stellarburgers.nomoreparties.site/register";
    protected final String URL_PASSWORD_RECOVERY_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(URL_MAIN_PAGE);
        new WebDriverWait(driver, Duration.ofSeconds(2));

        //метод для создания пользователя через апи
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        CreateUser createUser = new CreateUser(email, password, name); //создание пользователя
        CreateUserResponse createUserResponse = createUser.getCreateUserResponse(createUser)
                .body()
                .as(CreateUserResponse.class);
        userAccessToken = createUserResponse.getAccessToken().replace("Bearer ","");
    }

    @After
    public void tearDown() {
        driver.quit();

        //метод для удаления пользователя через апи
        given()
                .auth().oauth2(userAccessToken)
                .delete(URI_DELETE_USER);
    }
}