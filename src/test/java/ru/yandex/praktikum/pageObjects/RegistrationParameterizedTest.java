package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.TestBase;
import java.io.IOException;
import java.time.Duration;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RegistrationParameterizedTest extends TestBase {
    private final String incorrectPassword;
    private final boolean isErrorMessageVisible;

    public RegistrationParameterizedTest(String incorrectPassword, boolean isErrorMessageVisible) {
        this.incorrectPassword = incorrectPassword;
        this.isErrorMessageVisible = isErrorMessageVisible;
    }

    @Parameterized.Parameters(name = "Появление подсказки при некорректном пароле. " +
            "Тестовые данные: {0}, {1}")
    public static Object[][] setData() {
        return new Object[][] {
                {"12345", true},
                {" ", true},
                {"q", true},
                {"&", true},
        };
    }

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
    @DisplayName("Ошибка при указании пароля менее 6 символов")
    public void registrationPasswordLessThen6SymbolsShouldReturnError() {
        //вводим неправильный пароль, нажимаем "зарегистрироваться", проверяем, что отображается подсказка
        RegistrationPage registrationPage = new RegistrationPage(driver);
        goToLk();
        goToSignUp();
        setRegistrationFields("Apsenty", "olgaleto@yandex.ru", incorrectPassword);
        assertEquals(isErrorMessageVisible, registrationPage.checkIncorrectPasswordMessageIsVisible());
    }
}
