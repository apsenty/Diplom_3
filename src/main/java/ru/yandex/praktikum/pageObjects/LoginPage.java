package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //поле email
    private By emailField = By.xpath(".//input[@name='name']");
    //поле Пароль
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    //кнопка Войти
    private By signInButton = By.xpath(".//button[text()='Войти']");
    //ссылка Зарегистрироваться
    private By signUpLink = By.xpath(".//a[text()='Зарегистрироваться']");
    //ссылка Восстановить пароль
    private By passwordRecoveryLink = By.xpath(".//a[text()='Восстановить пароль']");
    //кнопка Конструктор
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //логотип Stellar Burgers
    private By stellarBurgersLogo = By.className("AppHeader_header__logo__2D0X2");
    //кнопка Выход (при авторизованном пользователе)
    private By signOutButton = By.xpath(".//button[text()='Выход']");
    //текст "Вход"
    private By loginText = By.xpath(".//h2[text()='Вход']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //видимость кнопки Войти
    public boolean checkSignInButtonIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        return driver.findElement(signInButton).isDisplayed();
    }
    //видимость текста Вход
    public boolean checkLoginTextIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginText));
        return driver.findElement(loginText).isDisplayed();
    }

    //ввод email
    //ввод пароля
    //нажатие кнопки Войти
    //переход по ссылке Зарегистрироваться
    public void clickOnSignUpLink(){
        driver.findElement(signUpLink).click();
    }
    //переход по ссылке Восстановить пароль
    //переход на страницу Конструктора (по кнопке Конструктор)
    //переход на страницу Конструктора (по логотипу)
    //нажатие кнопки Выход
}
