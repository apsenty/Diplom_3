package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.TestBase;
import static org.junit.Assert.*;

public class SignInTest extends TestBase {

    @Step("Авторизация на сайте")
    public void signIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);
    }

    @Step("Нажатие на кнопку \"Личный кабинет\"")
    public void clickOnLkButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
    }

    @Step("Нажатие на кнопку \"Войти в аккаунт\"")
    public void clickOnSignInButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnSignInButton();
    }

    @Step("Переход по ссылке Войти на странице регистрации")
    public void signInFromRegPage() {
        driver.get(URL_REGISTRATION_PAGE);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickOnSignInLink();
    }

    @Step("Переход по ссылке Войти на странице восстановления пароля")
    public void signInFromPRPage() {
        driver.get(URL_PASSWORD_RECOVERY_PAGE);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.clickOnSignInLink();
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void signInFromProfileButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        clickOnLkButton();
        signIn();
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной странице")
    public void signInFromButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        clickOnSignInButton();
        signIn();
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInFromRegistrationPage(){
        signInFromRegPage();
        signIn();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInFromPasswordRecoveryPage() {
        signInFromPRPage();
        signIn();
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isCreateOrderButtonVisible());
    }
}
