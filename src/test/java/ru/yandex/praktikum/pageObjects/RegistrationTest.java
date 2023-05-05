package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.TestBase;
import java.io.IOException;
import java.time.Duration;
import static org.junit.Assert.*;

public class RegistrationTest extends TestBase {

    @Before
    public void setUp() throws IOException {
        setDriver();
        driver = new ChromeDriver();
        driver.get(URL_MAIN_PAGE);
        new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @Step("Переход в ЛК")
    public void goToLk() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
    }

    @Step("Переход на страницу регистрации")
    public void goToSignUp() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnSignUpLink();
    }

    @Step("Заполнение полей регистрации")
    public void setRegistrationFields(String name, String email, String password) {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.signUp(name, email, password);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationPositiveCheck() {
    //проходим регистрацию и проверяем, что отображается страница входа
        LoginPage loginPage = new LoginPage(driver);
        goToLk();
        goToSignUp();
        setRegistrationFields("Apsenty", "olgaleto@yandex.ru", "qaws1234");
        assertTrue(loginPage.checkLoginTextIsVisible());
    }
}
