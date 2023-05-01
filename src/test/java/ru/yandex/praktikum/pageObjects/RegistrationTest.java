package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.TestBase;
import ru.yandex.praktikum.api.LoginUser;
import ru.yandex.praktikum.api.LoginUserResponse;
import java.time.Duration;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class RegistrationTest extends TestBase {
    MainPage objMainPage = new MainPage(driver);
    LoginPage objLoginPage = new LoginPage(driver);
    RegistrationPage objRegistrationPage = new RegistrationPage(driver);

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationPositiveCheck() {
    //проходим регистрацию и проверяем, что отображается страница входа
        objMainPage.clickOnLkButton();
        objLoginPage.clickOnSignUpLink();
        objRegistrationPage.signUp("Apsenty", "olgaleto@yandex.ru", "qaws1234");
        assertTrue(objLoginPage.checkLoginTextIsVisible());
    }

    @Test
    @DisplayName("Ошибка при указании пароля менее 6 символов")
    public void registrationPasswordLessThen6SymbolsShouldReturnError() {
    //вводим неправильный пароль, нажимаем "зарегистрироваться", проверяем, что отображается подсказка
        objMainPage.clickOnLkButton();
        objLoginPage.clickOnSignUpLink();
        objRegistrationPage.signUp("Apsenty", "olgaleto@yandex.ru", "1234");
        assertTrue(objRegistrationPage.checkIncorrectPasswordMessageIsVisible());
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
