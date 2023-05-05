package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.TestBase;
import static org.junit.Assert.*;

import java.time.Duration;

//тесты для Личного кабинета
public class ProfileTest extends TestBase {
    @Step("Авторизация на сайте")
    public void signIn() {
        driver.get(URL_LOGIN_PAGE);
        new WebDriverWait(driver, Duration.ofSeconds(2));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);
    }

    @Step("Переход в личный кабинет")
    public void goToLk() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
    }

    @Step("Переход в конструктор по кнопке Конструктор")
    public void goToConstructorFromConstructorButton() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnConstructorButton();
    }

    @Step("Переход в конструктор по логотипу Stellar Burgers")
    public void goToConstructorFromLogo() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnStellarBurgersLogo();
    }

    @Step("Выход из аккаунта")
    public void signOut() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnSignOutButton();
        profilePage.signOutWait();
    }

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы")
    public void checkGoToLkFromMainPageAfterAuthorization() {
        signIn();
        goToLk();
        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue(profilePage.isSignOutButtonVisible());
    }

    @Test
    @DisplayName("Переход из ЛК в Конструктор по клику на Конструктор")
    public void checkGoToConstructorFromLkWithConstructorButton() {
        signIn();
        goToLk();
        goToConstructorFromConstructorButton();
        assertEquals(URL_MAIN_PAGE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из ЛК в Конструктор по клику на логотип")
    public void checkGoToConstructorFromLkWithLogo() {
        signIn();
        goToLk();
        goToConstructorFromLogo();
        assertEquals(URL_MAIN_PAGE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void signOutFromAccountPositiveCheck() {
        signIn();
        goToLk();
        signOut();
        assertEquals(URL_LOGIN_PAGE, driver.getCurrentUrl());
    }
}
