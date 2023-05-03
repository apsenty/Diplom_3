package ru.yandex.praktikum;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.api.CreateUser;
import ru.yandex.praktikum.api.CreateUserResponse;
import ru.yandex.praktikum.api.LoginUser;
import ru.yandex.praktikum.api.LoginUserResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TestBase {
    protected ChromeDriver driver;

    protected final String email = "olgaleto@yandex.ru";
    protected final String password = "qaws1234";
    protected final String name = "Apsenty";
    protected String userAccessToken;
    protected final String URI_DELETE_USER = "/api/auth/user";

    protected final String URL_MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";
    protected final String URL_LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";
    protected final String URL_REGISTRATION_PAGE = "https://stellarburgers.nomoreparties.site/register";
    protected final String URL_PASSWORD_RECOVERY_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";

    //метод для выбора браузера, через который будут запускаться тесты
    protected void setDriver() throws IOException {
        String driverPath;
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/conf.properties"));
        String browser = System.getProperty("browser");
        if(browser.equals("chrome")) {
            driverPath = properties.getProperty("chrome.driver.path");
        } else if (browser.equals("yandex")) {
            driverPath = properties.getProperty("yandex.driver.path");
        } else {
            throw new RuntimeException("Такой драйвер не предусмотрен, пожалуйста, используйте chrome или yandex");
        }
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Before
    public void setUp() throws IOException {
        setDriver();
        driver = new ChromeDriver();
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
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        LoginUser loginUser = new LoginUser("olgaleto@yandex.ru", "qaws1234");
        LoginUserResponse loginUserResponse = loginUser.getLoginUserResponse(loginUser)
                .body()
                .as(LoginUserResponse.class);
        if (loginUserResponse.isSuccess()) {
            driver.quit();
            userAccessToken = loginUserResponse.getAccessToken().replace("Bearer ","");
            given()
                    .auth().oauth2(userAccessToken)
                    .delete(URI_DELETE_USER);
        } else {
            driver.quit();
        }
    }
}