package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.TestBase;
import static org.junit.Assert.*;

public class SignInTest extends TestBase {

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void signInFromProfileButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной странице")
    public void signInFromButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInFromRegistrationPage(){
        driver.get(URL_REGISTRATION_PAGE);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInFromPasswordRecoveryPage() {
        driver.get(URL_PASSWORD_RECOVERY_PAGE);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.clickOnSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }
}
