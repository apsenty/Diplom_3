package ru.yandex.praktikum.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    //кнопка Выход
    private final By signOutButton = By.xpath(".//button[text()='Выход']");
    //кнопка Конструктор
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //логотип Stellar Burgers
    private final By stellarBurgersLogo = By.className("AppHeader_header__logo__2D0X2");

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //нажатие кнопки Выход
    public void clickOnSignOutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(signOutButton));
        driver.findElement(signOutButton).click();
    }
    //переход на страницу Конструктора (по кнопке Конструктор)
    public void clickOnConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    //переход на страницу Конструктора (по логотипу)
    public void clickOnStellarBurgersLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }
    //видимость кнопки Выход
    public boolean isSignOutButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
        return driver.findElement(signOutButton).isDisplayed();
    }
    //ожидание выхода
    public void signOutWait() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }
}
