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
    //текст "Вход"
    private By loginText = By.xpath(".//h2[text()='Вход']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //ввод email
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    //ввод пароля
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    //нажатие кнопки Войти
    public void clickOnSignInButton() {
        driver.findElement(signInButton).click();
    }
    //переход по ссылке Зарегистрироваться
    public void clickOnSignUpLink(){
        driver.findElement(signUpLink).click();
    }
    //переход по ссылке Восстановить пароль
    public void clickOnPasswordRecoveryLink() {
        driver.findElement(passwordRecoveryLink).click();
    }
    //видимость кнопки Войти - скорее всего удалить
    /* public boolean checkSignInButtonIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        return driver.findElement(signInButton).isDisplayed();
    } */
    //видимость текста Вход
    public boolean checkLoginTextIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginText));
        return driver.findElement(loginText).isDisplayed();
    }

    //метод входа в ЛК
    public void signIn(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickOnSignInButton();
    }
}
