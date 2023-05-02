package ru.yandex.praktikum.pageObjects;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.TestBase;
import ru.yandex.praktikum.api.CreateUser;
import ru.yandex.praktikum.api.CreateUserResponse;
import static org.junit.Assert.*;

import java.time.Duration;

//тесты для Личного кабинета
public class ProfileTest extends TestBase {
    @Before
    public void setUp() {
        //создание пользователя через апи
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        CreateUser createUser = new CreateUser(email, password, name); //создание пользователя
        CreateUserResponse createUserResponse = createUser.getCreateUserResponse(createUser)
                .body()
                .as(CreateUserResponse.class);
        userAccessToken = createUserResponse.getAccessToken().replace("Bearer ","");
        //авторизация на сайте
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(URL_LOGIN_PAGE);
        new WebDriverWait(driver, Duration.ofSeconds(2));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.signIn(email, password);
    }

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы")
    public void checkGoToLkFromMainPageAfterAuthorization() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue(profilePage.isSignOutButtonVisible());
    }

    @Test
    @DisplayName("Переход из ЛК в Конструктор по клику на Конструктор")
    public void checkGoToConstructorFromLkWithConstructorButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnConstructorButton();
        assertEquals(URL_MAIN_PAGE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из ЛК в Конструктор по клику на логотип")
    public void checkGoToConstructorFromLkWithLogo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnStellarBurgersLogo();
        assertEquals(URL_MAIN_PAGE, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void signOutFromAccountPositiveCheck() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLkButtonPage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickOnSignOutButton();
        profilePage.signOutWait();
        assertEquals(URL_LOGIN_PAGE, driver.getCurrentUrl());
    }
}
