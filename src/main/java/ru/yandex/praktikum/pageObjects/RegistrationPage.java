package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    //поле Имя
    private By nameField = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]//input");
    //поле email
    private By emailField = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]//input");
    //поле Пароль
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    //кнопка Зарегистрироваться
    private By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //ссылка Войти
    private By signInLink = By.xpath(".//a[text()='Войти']");
    //подсказка "Некорректный пароль"
    private By incorrectPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //ввод имени
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //ввод почты
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    //ввод пароля
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    //нажатие кнопки Зарегистрироваться
    public void clickOnSignUpButton() {
        driver.findElement(signUpButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(2));
    }
    //видимость подсказки "Некорректный пароль"
    public boolean checkIncorrectPasswordMessageIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordMessage));
        return driver.findElement(incorrectPasswordMessage).isDisplayed();
    }
    //нажатие ссылки Войти
    public void clickOnSignInLink() {
        driver.findElement(signInLink).click();
    }
    //один метод для регистрации, в который на вход передаем значения
    public void signUp(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        clickOnSignUpButton();
    }
}
