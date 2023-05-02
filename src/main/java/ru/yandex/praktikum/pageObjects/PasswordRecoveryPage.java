package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    //поле email
    private final By emailField = By.tagName("input");
    //кнопка Восстановить
    private final By recoveryButton = By.xpath(".//button[text()='Восстановить']");
    //ссылка Войти
    private final By signInLink = By.xpath(".//a[text()='Войти']");

    private WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    //заполнение поля почты
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    //нажатие кнопки Восстановить
    public void clickOnRecoveryButton() {
        driver.findElement(recoveryButton).click();
    }
    //нажатие ссылки Войти
    public void clickOnSignInLink() {
        driver.findElement(signInLink).click();
    }
}
